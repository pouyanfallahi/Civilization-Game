package ir.civilization.menu.info.action;


import ir.civilization.dao.CityDao;
import ir.civilization.dto.EmptyCmdLoader;
import ir.civilization.dto.unit.CityResponseDTO;
import ir.civilization.holder.GameHolder;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.model.Civilization;
import ir.civilization.utils.DtoUtils;
import ir.civilization.utils.JacksonUtils;
import ir.civilization.validator.UserValidator;

public class CityInfoMenuAction extends AbstractMenuAction<EmptyCmdLoader> {

    public static final CityInfoMenuAction INSTANCE = new CityInfoMenuAction();

    private final CityDao cityDao = CityDao.INSTANCE;

    private CityInfoMenuAction() {
    }

    @Override
    public Class<EmptyCmdLoader> getDtoClazz() {
        return EmptyCmdLoader.class;
    }

    @Override
    public void takeAction(EmptyCmdLoader v) {
        // validation user authentication
        UserValidator.checkAuthentication();

        Civilization civilization = GameHolder.getCreatedContext().getCivilization();
        String json = JacksonUtils.getJsonFromObject(
                DtoUtils.createAndLoadList(
                        cityDao.findAllByCivilization(civilization),
                        CityResponseDTO::new
                )
        );
        System.out.println(json);
    }

}
