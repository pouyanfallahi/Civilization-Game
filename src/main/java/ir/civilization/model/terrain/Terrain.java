package ir.civilization.model.terrain;

import ir.civilization.model.resource.Resource;
import lombok.Data;

import java.util.List;

@Data
public class Terrain {

    private String name;
    private int food;
    private int products;
    private int gold;
    private double fightingChanges;
    private int travelCost;
    private String color;

    private List<TerrainFeatures> possibleFeatures;
    private List<Resource> possibleResources;

}
