package ir.civilization.model;

import static ir.civilization.utils.ColorConstant.*;

public enum TerrainFeatureType {

    OASIS("O", "oasis", 1, ANSI_YELLOW_BACKGROUND),
    FORREST("F", "forrest", 1, ANSI_GREEN_BACKGROUND),
    ICE("I", "ice", 2, ANSI_ORANGE_BACKGROUND),
    DENSE_FOREST("D", "Dense forest", -1, ANSI_BROWN_BACKGROUND),
    SWAMP("S", "swamp", -1, ANSI_CYAN_BACKGROUND),
    RIVER("R", "river", 1, ANSI_PURPLE_BACKGROUND),
    PLAIN("P", "plain", 1, ANSI_WHITE_BACKGROUND);

    private String symbol;
    private String name;
    private int cost;

    TerrainFeatureType(String symbol, String name, int cost, String color) {
        this.symbol = symbol;
        this.name = name;
        this.cost = cost;
    }

    public String getSymbol() {
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

}