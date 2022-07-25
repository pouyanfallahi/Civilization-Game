package ir.civilization.model.unit;

public class CivilianUnit extends Unit {

    @Override
    public Unit createCopy() {
        return new CivilianUnit();
    }
}
