package ir.civilization.menu.info.action;


import ir.civilization.dao.UnitDao;
import ir.civilization.dto.EmptyCmdLoader;
import ir.civilization.dto.unit.UnitResponseDTO;
import ir.civilization.holder.GameHolder;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.model.Civilization;
import ir.civilization.utils.DtoUtils;
import ir.civilization.utils.JacksonUtils;
import ir.civilization.validator.UserValidator;

public class UnitsInfoMenuAction extends AbstractMenuAction<EmptyCmdLoader> {

    public static final UnitsInfoMenuAction INSTANCE = new UnitsInfoMenuAction();

    private final UnitDao unitDao = UnitDao.INSTANCE;

    private UnitsInfoMenuAction() {
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
                        unitDao.getUnitsByCivilization(civilization),
                        UnitResponseDTO::new
                )
        );
        System.out.println(json);
    }

}
