package ir.civilization.menu.unit.action;


import ir.civilization.dto.PositionDTO;
import ir.civilization.holder.GameContext;
import ir.civilization.holder.GameHolder;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.model.Civilization;
import ir.civilization.model.unit.Unit;
import ir.civilization.validator.UserValidator;

public class DeleteUnitMenuAction extends AbstractMenuAction<PositionDTO> {

    public static final DeleteUnitMenuAction INSTANCE = new DeleteUnitMenuAction();

    private DeleteUnitMenuAction() {
    }

    @Override
    public Class<PositionDTO> getDtoClazz() {
        return PositionDTO.class;
    }

    @Override
    public void takeAction(PositionDTO v) {
        // validation user authentication
        UserValidator.checkAuthentication();

        GameContext gameContext = GameHolder.getCreatedContext();
        Unit activeUnit = gameContext.getActiveUnit();
        if (activeUnit == null)
            throw new IllegalArgumentException("no active unit founded!");

        Civilization civilization = gameContext.getCivilization();
        if (!civilization.hasAccessToUnit(activeUnit))
            throw new IllegalStateException("User does not have access to the active unit!");

        gameContext.setActiveUnit(null);

        System.out.println("active unit deleted successfully!");
    }

}
