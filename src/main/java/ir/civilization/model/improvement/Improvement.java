package ir.civilization.model.improvement;

import ir.civilization.model.technology.Technology;
import ir.civilization.model.resource.Resource;
import ir.civilization.model.terrain.TerrainFeatures;
import lombok.Data;

import java.util.List;

@Data
public class Improvement {

    private String name;
    private TileEfficiency tileEfficiency;
    private List<Resource> resourcesNeedThisDevelopment;
    private Technology preRequestTech;
    private List<TerrainFeatures> builtInThesePlaces;

}
