package ir.civilization.menu.select.action;


import ir.civilization.dto.SelectUnitDTO;
import ir.civilization.holder.GameContext;
import ir.civilization.holder.GameHolder;
import ir.civilization.holder.MapHolder;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.model.Tile;
import ir.civilization.model.unit.Unit;
import ir.civilization.model.unit.UnitType;
import ir.civilization.validator.UserValidator;

public class UnitSelectMenuAction extends AbstractMenuAction<SelectUnitDTO> {

    public static final UnitSelectMenuAction INSTANCE = new UnitSelectMenuAction();

    private UnitSelectMenuAction() {
    }

    @Override
    public Class<SelectUnitDTO> getDtoClazz() {
        return SelectUnitDTO.class;
    }

    @Override
    public void takeAction(SelectUnitDTO dto) {
        // validation user authentication
        UserValidator.checkAuthentication();

        GameContext gameContext = GameHolder.getCreatedContext();
        Unit activeUnit = gameContext.getActiveUnit();
        if (activeUnit != null)
            throw new IllegalArgumentException("no active unit founded!");

        int x = dto.getPosition().getX();
        int y = dto.getPosition().getY();
        Tile tile = MapHolder.MAP.getTile(x, y);
        if (tile.isNotAccessible())
            throw new IllegalArgumentException("tile is not accessible: " + tile.getType());

        UnitType unitType = dto.getUnitType();
        Unit selectedUnit = tile.getUnit(unitType);
        if (selectedUnit == null)
            throw new IllegalArgumentException(String.format("no %s unit exist in tile (%d,%d)", unitType, x, y));
//            selectedUnit = new MilitaryUnit();

        gameContext.setActiveUnit(selectedUnit);
        System.out.printf("unit \"%s\" selected as an active unit!\n", selectedUnit.getName());
    }

}
