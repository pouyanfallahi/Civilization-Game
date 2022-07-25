package ir.civilization.menu.unit.action;


import ir.civilization.dto.FoundCityDTO;
import ir.civilization.holder.GameContext;
import ir.civilization.holder.GameHolder;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.menu.main.GameMenuRunner;
import ir.civilization.model.City;
import ir.civilization.model.Civilization;
import ir.civilization.model.Tile;
import ir.civilization.model.unit.Unit;
import ir.civilization.model.unit.UnitRole;
import ir.civilization.validator.UserValidator;

public class FoundCityMenuAction extends AbstractMenuAction<FoundCityDTO> {

    public static final FoundCityMenuAction INSTANCE = new FoundCityMenuAction();

    private FoundCityMenuAction() {
    }

    @Override
    public Class<FoundCityDTO> getDtoClazz() {
        return FoundCityDTO.class;
    }

    @Override
    public void takeAction(FoundCityDTO v) {
        // validation user authentication
        UserValidator.checkAuthentication();
        if (!v.isHasCityFlag())
            throw new IllegalArgumentException("city flag is not applied to arguments");

        GameContext gameContext = GameHolder.getCreatedContext();
        Unit activeUnit = gameContext.getActiveUnit();
        if (activeUnit == null)
            throw new IllegalArgumentException("no active unit founded!");

        Civilization civilization = gameContext.getCivilization();
        if (!civilization.hasAccessToUnit(activeUnit))
            throw new IllegalStateException("User does not have access to the active unit!");

        Tile tile = activeUnit.getTile();
        if (!tile.isEmpty())
            throw new IllegalStateException("Tile is not empty!");

        UnitRole role = activeUnit.getRole();
        if (role != UnitRole.SETTLER)
            throw new IllegalArgumentException(String.format("unit role is %s and only settlers can found a city!", role));

        City city = new City(civilization);
        System.out.println("please enter city name: ");
        String name = GameMenuRunner.SCANNER.next();
        city.setName(name);
        city.setTile(tile);
        tile.setOccupant(city);
        civilization.getTiles().add(tile);

        System.out.printf("city created successfully on (%d,%d)\n", tile.getPosition().getX(), tile.getPosition().getY());
    }

}
