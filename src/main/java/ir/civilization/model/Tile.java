package ir.civilization.model;

import ir.civilization.model.map.MapObject;
import ir.civilization.model.resource.Resource;
import ir.civilization.model.terrain.Terrain;
import ir.civilization.model.terrain.TerrainFeatures;
import ir.civilization.model.unit.CivilianUnit;
import ir.civilization.model.unit.MilitaryUnit;
import ir.civilization.model.unit.Unit;
import ir.civilization.model.unit.UnitType;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

@Getter @Setter
public class Tile {

    private Resource resource;
    private Terrain terrainType;
    private TerrainFeatures terrainF;
    private TileSituation condition;

    private final TerrainType type;
    private final Position position;
    private MapObject occupant;

    private MilitaryUnit unitNez;
    private CivilianUnit unitGNez;

    private Map<Unit, Tile> unitHistory;

    private final boolean hasRiver;

    public Tile(MapObject occupant, TerrainType type, Position position, boolean hasRiver) {
        this.occupant = occupant;
        this.type = type;
        this.position = position;
        this.hasRiver = hasRiver;
    }

    public void addToHistory(Unit unit) {
        Tile copy = this.createCopy();
        Map<Unit, Tile> history = this.getCreatedUnitHistory();
        history.put(unit, copy);
    }

    public Tile createCopy() {
        Tile tile = new Tile(this.getOccupant(), this.getType(), this.getPosition(), this.hasRiver);
        tile.setUnit(this.getUnitGNez().createCopy());
        tile.setUnit(this.getUnitNez().createCopy());
        return tile;
    }

    public void setUnit(Unit unit) {
        if (unit instanceof MilitaryUnit) {
            if (this.unitNez != null)
                throw new IllegalArgumentException("military unit is not empty");

            unitNez = (MilitaryUnit) unit;
        }
        else if (unit instanceof CivilianUnit) {
            if (this.unitNez != null)
                throw new IllegalArgumentException("civilian unit is not empty");

            unitGNez = (CivilianUnit) unit;
        }
        addToHistory(unit);
    }

    public void removeUnit(Unit unit) {
        if (unit.equals(this.unitNez))
            unitNez = null;
        else if (unit.equals(this.unitGNez))
            unitGNez = null;
    }

    public boolean isEmpty() {
        return occupant == null;
    }

    public boolean isNotAccessible() {
        return !this.isAccessible();
    }

    public boolean isAccessible() {
        List<TerrainFeatureType> terrainFeatures = this.getType().getTerrainFeatures();
        Optional<TerrainFeatureType> terrainFeature = terrainFeatures.stream()
                .filter(tf -> tf == TerrainFeatureType.FORREST)
                .findAny();
        return type != TerrainType.HILL && this.type != TerrainType.MOUNTAIN && !terrainFeature.isPresent();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return Objects.equals(position, tile.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    /**
     * Return null if tile is invisible
     */
    public Tile getVisibleCurrentTileOrHistory(Civilization civilization) {
        Set<Tile> tiles = civilization.getTiles();
        if (tiles.contains(this))
            return this;

        for (Tile tile : tiles) {
            double ac = Math.abs(tile.getPosition().getY() - this.getPosition().getY());
            double cb = Math.abs(tile.getPosition().getX() - this.getPosition().getX());

            List<Unit> units = tile.getUnits();

            double distance = Math.hypot(ac, cb);


            if (CollectionUtils.isNotEmpty(units)) {
                if (distance == 1 && !this.isInvisible())
                    return this;
                else if (distance == 2)
                    return this;
            }

            if (distance == 1)
                return this;

            Map<Unit, Tile> unitHistory = this.getUnitHistory();
            if (unitHistory != null) {
                Set<Unit> unitKeys = unitHistory.keySet();
                for (Unit unitKey : unitKeys) {
                    if (unitKey.equals(tile.getUnitNez()) || unitKey.equals(tile.getUnitGNez()))
                        return unitHistory.get(unitKey);
                }
            }
        }

        return null;
    }

    public boolean isInvisible() {
        return this.getType() == TerrainType.MOUNTAIN;
    }

    public Unit getUnit(UnitType unitType) {
        switch (unitType) {
            case COMBAT:
                return this.getUnitNez();
            case NONCOMBAT:
                return this.getUnitGNez();
            default:
                throw new IllegalStateException("WTF");
        }
    }

    public List<Unit> getUnits() {
        List<Unit> units = new ArrayList<>();
        if (this.getUnitNez() != null)
            units.add(this.getUnitNez());
        if (this.getUnitGNez() != null)
            units.add(this.getUnitGNez());
        return units;
    }

    public Map<Unit, Tile> getCreatedUnitHistory() {
        if (this.unitHistory == null)
            this.unitHistory = new HashMap<>();

        return unitHistory;
    }
}
