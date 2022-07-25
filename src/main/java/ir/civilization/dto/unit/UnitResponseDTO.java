package ir.civilization.dto.unit;

import ir.civilization.dto.DtoLoader;
import ir.civilization.model.unit.Unit;
import lombok.Data;

@Data
public class UnitResponseDTO implements DtoLoader<Unit> {

    private String name;
    private int cost;
    private String combatType;
    private Integer combatStrength;
    private Integer rangedCombatStrength;
    private int movementSpeed;

    @Override
    public void loadFrom(Unit unit) {
        this.name = unit.getName();
        this.cost = unit.getCost();
        this.combatType = unit.getCombatType();
        this.combatStrength = unit.getCombatStrength();
        this.rangedCombatStrength = unit.getRangedCombatStrength();
        this.movementSpeed = unit.getMovement();
    }
}
