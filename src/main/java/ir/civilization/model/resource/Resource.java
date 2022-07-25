package ir.civilization.model.resource;

import ir.civilization.model.TerrainType;
import ir.civilization.model.improvement.ImprovementType;

import java.util.Arrays;
import java.util.List;


public enum Resource {

    WHEAT(1, 0, 0, Arrays.asList(TerrainType.FIELD), Arrays.asList(ImprovementType.FARMING)),
    BANANA(1, 0, 0, null, Arrays.asList(ImprovementType.PASTURE)),
    COW(1, 0, 0, Arrays.asList(TerrainType.MEADOW), Arrays.asList(ImprovementType.CAMP)),
    DEER(1, 0, 0, Arrays.asList(TerrainType.HILL, TerrainType.TUNDRA), Arrays.asList(ImprovementType.PASTURE)),
    SHEEP(2, 0, 0, Arrays.asList(TerrainType.MEADOW, TerrainType.DESERT, TerrainType.HILL), Arrays.asList(ImprovementType.FARM)),
    COAL(0, 1, 0, Arrays.asList(TerrainType.FIELD, TerrainType.HILL, TerrainType.MEADOW), Arrays.asList(ImprovementType.MINE)),
    HORSE(0, 1, 0, Arrays.asList(TerrainType.FIELD, TerrainType.MEADOW, TerrainType.TUNDRA), Arrays.asList(ImprovementType.PASTURE)),
    IRON(0, 1, 0, Arrays.asList(TerrainType.SNOW, TerrainType.TUNDRA, TerrainType.HILL, TerrainType.MEADOW, TerrainType.DESERT, TerrainType.FIELD), Arrays.asList(ImprovementType.MINE)),
    FUR(0, 0, 2, Arrays.asList(TerrainType.TUNDRA), Arrays.asList(ImprovementType.FARMING)),
    GEMSTONE(0, 0, 3, Arrays.asList(TerrainType.FIELD, TerrainType.DESERT, TerrainType.MEADOW, TerrainType.HILL, TerrainType.TUNDRA), Arrays.asList(ImprovementType.FARMING)),
    GOLD(0, 0, 2, Arrays.asList(TerrainType.FIELD, TerrainType.DESERT, TerrainType.MEADOW, TerrainType.HILL), Arrays.asList(ImprovementType.CAMP)),
    EATIT(0, 0, 2, Arrays.asList(TerrainType.FIELD, TerrainType.DESERT), Arrays.asList(ImprovementType.MINE)),
    COTTON(0, 0, 2, Arrays.asList(TerrainType.FIELD, TerrainType.DESERT, TerrainType.MEADOW), Arrays.asList(ImprovementType.MINE)),
    IVORY(0, 0, 2, Arrays.asList(TerrainType.FIELD, TerrainType.DESERT, TerrainType.MEADOW), Arrays.asList(ImprovementType.FARMING)),
    MARBLE(0, 0, 2, Arrays.asList(TerrainType.FIELD, TerrainType.DESERT, TerrainType.MEADOW, TerrainType.HILL, TerrainType.TUNDRA), Arrays.asList(ImprovementType.CAMP)),
    SILK(0, 0, 2, null, Arrays.asList(ImprovementType.STONE_MINE)),
    SILVER(0, 0, 2, Arrays.asList(TerrainType.HILL, TerrainType.TUNDRA), Arrays.asList(ImprovementType.FARMING)),
    SUGAR(0, 0, 2, null, Arrays.asList(ImprovementType.MINE)),
    ;


    private int food;
    private int production;
    private int gold;
    private List<TerrainType> canBeFoundOn;
    private List<ImprovementType> improvementNeeded;

    Resource(int food, int production, int gold, List<TerrainType> canBeFoundOn, List<ImprovementType> improvementNeeded) {
        this.food = food;
        this.production = production;
        this.gold = gold;
        this.canBeFoundOn = canBeFoundOn;
        this.improvementNeeded = improvementNeeded;
    }
}


