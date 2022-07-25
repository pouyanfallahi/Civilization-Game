package ir.civilization.model.improvement;

import ir.civilization.model.TerrainType;
import ir.civilization.model.resource.Resource;
import ir.civilization.model.technology.TechKind;

import java.util.Arrays;
import java.util.List;

public enum ImprovementType {

    CAMP(null, Arrays.asList(Resource.FUR,Resource.IVORY,Resource.DEER), Arrays.asList(TechKind.TRAPPING), Arrays.asList(TerrainType.DESERT,TerrainType.MEADOW,TerrainType.TUNDRA,TerrainType.HILL)),
    FARM(null, Arrays.asList(Resource.WHEAT), Arrays.asList(TechKind.AGRICULTURE),Arrays.asList(TerrainType.DESERT,TerrainType.MEADOW) ),
    WOOD_FACTORY(null,null, Arrays.asList(TechKind.CONSTRUCTION),null),
    MINE(null,Arrays.asList(Resource.GEMSTONE,Resource.GOLD,Resource.SILVER,Resource.COAL,Resource.IRON),Arrays.asList(TechKind.MINING),Arrays.asList(TerrainType.MEADOW,TerrainType.DESERT,TerrainType.TUNDRA,TerrainType.HILL)),
    PASTURE(null,Arrays.asList(Resource.HORSE,Resource.COW,Resource.SHEEP), Arrays.asList(TechKind.ANIMAL_HUSBANDRY), Arrays.asList(TerrainType.DESERT,TerrainType.TUNDRA,TerrainType.MEADOW)),
    FARMING(null, Arrays.asList(Resource.BANANA,Resource.COTTON,Resource.SUGAR,Resource.SILK),Arrays.asList(TechKind.CALENDAR),Arrays.asList(TerrainType.DESERT,TerrainType.MEADOW)),
    LIVESTOCK( null ,Arrays.asList(Resource.HORSE,Resource.COW,Resource.SHEEP), Arrays.asList(TechKind.STEEL), Arrays.asList(TerrainType.DESERT,TerrainType.TUNDRA,TerrainType.MEADOW)),
    STONE_MINE(null, Arrays.asList(Resource.MARBLE),Arrays.asList(TechKind.MASONRY),Arrays.asList(TerrainType.TUNDRA,TerrainType.MEADOW,TerrainType.DESERT)),
    TRADING_POST(null, null, Arrays.asList(TechKind.ENGINEERING), Arrays.asList(TerrainType.MEADOW,TerrainType.DESERT,TerrainType.TUNDRA,TerrainType.SNOW)),
    FACTORY(null,null,Arrays.asList(TechKind.ENGINEERING),Arrays.asList())

    ;
    private TileEfficiency tileEfficiency;
    private List<Resource> resourcesNeedThisDevelopment;
    private List<TechKind> preRequestTech;
    private List<TerrainType> builtInThesePlaces;

    ImprovementType(TileEfficiency tileEfficiency, List<Resource> resourcesNeedThisDevelopment, List<TechKind> preRequestTech, List<TerrainType> builtInThesePlaces) {

        this.tileEfficiency = tileEfficiency;
        this.resourcesNeedThisDevelopment = resourcesNeedThisDevelopment;
        this.preRequestTech = preRequestTech;
        this.builtInThesePlaces = builtInThesePlaces;
    }
}
