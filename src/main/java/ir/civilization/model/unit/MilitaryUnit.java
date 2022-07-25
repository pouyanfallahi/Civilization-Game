package ir.civilization.model.unit;

public class MilitaryUnit extends Unit {

    @Override
    public Unit createCopy() {
        return new MilitaryUnit();
    }
}
