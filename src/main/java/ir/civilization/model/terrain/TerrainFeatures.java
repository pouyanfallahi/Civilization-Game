package ir.civilization.model.terrain;

import lombok.Data;

@Data
public class TerrainFeatures {

    private String name;
    private int food;
    private int products;
    private boolean gold;
    private double fightingChanges;
    private int travelCosts;
    private String possibleResources;

}
