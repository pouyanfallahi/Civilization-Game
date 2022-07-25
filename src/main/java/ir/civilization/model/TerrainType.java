package ir.civilization.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static ir.civilization.utils.ColorConstant.*;

public enum TerrainType {

    DESERT('D', "Desert", 1, ANSI_YELLOW_BACKGROUND, Arrays.asList(TerrainFeatureType.OASIS, TerrainFeatureType.PLAIN)),
    MEADOW('M', "Meadow", 1, ANSI_GREEN_BACKGROUND, Arrays.asList(TerrainFeatureType.FORREST, TerrainFeatureType.SWAMP)),
    HILL('h', "Hill", 2, ANSI_ORANGE_BACKGROUND, Arrays.asList(TerrainFeatureType.FORREST, TerrainFeatureType.DENSE_FOREST)),
    MOUNTAIN('m', "Maointain", -1, ANSI_BROWN_BACKGROUND, Collections.emptyList()),
    OCEAN('o', "Ocean", -1, ANSI_CYAN_BACKGROUND, Collections.emptyList()),
    FIELD('f', "Field", 1, ANSI_PURPLE_BACKGROUND, Arrays.asList(TerrainFeatureType.FORREST, TerrainFeatureType.DENSE_FOREST)),
    SNOW('s', "Snow", 1, ANSI_WHITE_BACKGROUND, Collections.emptyList()),
    TUNDRA('t', "Tundra", 1, ANSI_LIVER_BACKGROUND + ANSI_WHITE, Collections.singletonList(TerrainFeatureType.FORREST));


    private char symbol;
    private String name;
    private int cost;
    private final String color;
    private final List<TerrainFeatureType> terrainFeatures;

    TerrainType(char symbol, String name, int cost, String color, List<TerrainFeatureType> terrainFeatures) {
        this.symbol = symbol;
        this.name = name;
        this.cost = cost;
        this.color = color;
        this.terrainFeatures = terrainFeatures;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public String getName() {
        return this.name;
    }

    public int getCost() {
        return this.cost;
    }

    public String getTerrain() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public List<TerrainFeatureType> getTerrainFeatures() {
        return terrainFeatures;
    }
}