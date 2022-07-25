package ir.civilization.dao;

import ir.civilization.model.Civilization;
import ir.civilization.model.Tile;
import ir.civilization.model.unit.Unit;

import java.util.Collection;
import java.util.stream.Collectors;

public class UnitDao {

    public static final UnitDao INSTANCE = new UnitDao();

    public Collection<Unit> getUnitsByCivilization(Civilization civilization) {
        return civilization.getTiles()
                .stream()
                .map(Tile::getUnits)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    public Collection<Unit> getUnitsByTile(Tile tile) {
        return tile.getUnits();
    }

}
