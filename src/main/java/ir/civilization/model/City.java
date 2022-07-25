package ir.civilization.model;

import ir.civilization.model.map.MapObject;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class City extends MapObject {

    private String name;
    private char symbol;
    private Tile tile;

    public City(Civilization owner) {
        super(owner);
    }

    @Override
    public char symbol() {
        return this.getOwner().getSymbol();
    }
}
