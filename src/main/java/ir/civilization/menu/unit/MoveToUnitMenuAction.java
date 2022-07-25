package ir.civilization.menu.unit;


import ir.civilization.dto.PositionDTO;
import ir.civilization.holder.GameContext;
import ir.civilization.holder.GameHolder;
import ir.civilization.holder.MapHolder;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.model.Tile;
import ir.civilization.model.unit.Unit;
import ir.civilization.validator.UserValidator;

public class MoveToUnitMenuAction extends AbstractMenuAction<PositionDTO> {

    public static final MoveToUnitMenuAction INSTANCE = new MoveToUnitMenuAction();

    private MoveToUnitMenuAction() {
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

        int x = v.getX();
        int y = v.getY();
        Tile newTile = MapHolder.MAP.getTile(x, y);
        if (newTile.isNotAccessible())
            throw new IllegalArgumentException("tile is not accessible: " + newTile.getType());

        int cost = newTile.getType().getCost();
        if (cost == -1)
            throw new IllegalStateException("Tile unreachable!");

        int mp = gameContext.getMp();
        if (cost > mp)
            throw new IllegalStateException(String.format("Your MP count is not enough to go there! traveling cost: %d , your mp: %d", cost, mp));

        // decrease player mp
        gameContext.decreaseMp(cost);

        final Tile oldTile = activeUnit.getTile();
        newTile.setUnit(activeUnit);

        activeUnit.setTile(newTile);

        if (oldTile == null)
            System.out.println("Unit old tile is null!");
        else
            oldTile.removeUnit(activeUnit);

        System.out.printf("unit moved to tile (%d,%d) successfully!\n", x, y);
    }

}
