package ir.civilization.menu.select.action;


import ir.civilization.dao.CityDao;
import ir.civilization.dto.PositionDTO;
import ir.civilization.dto.SelectCityDTO;
import ir.civilization.holder.GameContext;
import ir.civilization.holder.GameHolder;
import ir.civilization.holder.MapHolder;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.model.City;
import ir.civilization.model.Tile;
import ir.civilization.model.map.MapObject;
import ir.civilization.model.unit.Unit;
import ir.civilization.validator.UserValidator;

public class CitySelectMenuAction extends AbstractMenuAction<SelectCityDTO> {

    public static final CitySelectMenuAction INSTANCE = new CitySelectMenuAction();

    private static final CityDao CITY_DAO = CityDao.INSTANCE;

    private CitySelectMenuAction() {
    }

    @Override
    public Class<SelectCityDTO> getDtoClazz() {
        return SelectCityDTO.class;
    }

    @Override
    public void takeAction(SelectCityDTO dto) {
        // validation user authentication
        UserValidator.checkAuthentication();

        GameContext gameContext = GameHolder.getCreatedContext();
        Unit activeUnit = gameContext.getActiveUnit();
        if (activeUnit != null)
            throw new IllegalArgumentException("no active unit founded!");

        PositionDTO position = dto.getPosition();
        String name = dto.getName();
        City city = null;
        if (position != null) {
            int x = position.getX();
            int y = position.getY();
            MapObject occupant = MapHolder.MAP.getTile(x, y).getOccupant();
            if (occupant instanceof City)
                city = (City) occupant;
        } else if (name != null) {
            city = CITY_DAO.findCityByName(name, MapHolder.MAP);
        } else
            throw new IllegalStateException("position or name must be provided!");

        if (city == null)
            throw new IllegalStateException("cannot found any valid city!");

        Tile tile = city.getTile();
        if (tile.isNotAccessible())
            throw new IllegalArgumentException("tile is not accessible: " + tile.getType());

        gameContext.setActiveCity(city);
        System.out.printf("city \"%s\" selected as an active city!\n", city.getName());
    }

}
