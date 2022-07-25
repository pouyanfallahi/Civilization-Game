package ir.civilization.dao;

import ir.civilization.model.City;
import ir.civilization.model.Civilization;
import ir.civilization.model.Tile;
import ir.civilization.model.map.Map;

import java.util.Collection;
import java.util.stream.Collectors;

public class CityDao {

    public static final CityDao INSTANCE = new CityDao();

    private CityDao() {}

    public Collection<City> findAllByCivilization(Civilization civilization) {
        return civilization.getTiles()
                .stream()
                .map(Tile::getOccupant)
                .filter(mo -> mo instanceof City)
                .map(mo -> (City) mo)
                .collect(Collectors.toSet());
    }

    public City findCityByName(String name, Map map) {
        return map.getMapAsSet()
                .stream()
                .map(Tile::getOccupant)
                .filter(mo -> mo instanceof City)
                .map(mo -> (City) mo)
                .filter(c -> name.equalsIgnoreCase(c.getName()))
                .findAny()
                .orElse(null);
    }

}
