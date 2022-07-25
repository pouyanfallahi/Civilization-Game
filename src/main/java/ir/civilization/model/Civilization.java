package ir.civilization.model;

import ir.civilization.model.technology.Technology;
import ir.civilization.model.unit.Unit;
import ir.civilization.model.user.User;
import lombok.Data;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Data
public class Civilization {


    private String name;
    private char symbol;

    private Technology technology = new Technology();

    private int numSettlements;

    private Treasury treasury = new Treasury(50);
    private int food = 50;
    private int resources = 50;
    private int happiness = 50;

    private User user;
    private Set<Tile> tiles = new HashSet<>();

    public boolean hasAccessToUnit(Unit unit) {
        Optional<Unit> uo = this.tiles.stream()
                .map(Tile::getUnits)
                .flatMap(Collection::stream)
                .filter(u -> u.equals(unit))
                .findAny();
        return uo.isPresent();
    }

}
