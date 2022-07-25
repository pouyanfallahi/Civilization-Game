package ir.civilization.menu.map.action;


import ir.civilization.dto.EmptyCmdLoader;
import ir.civilization.holder.MapHolder;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.model.MapView;
import ir.civilization.validator.UserValidator;

public class ShowMapMenuAction extends AbstractMenuAction<EmptyCmdLoader> {

    public static final ShowMapMenuAction INSTANCE = new ShowMapMenuAction();

    private ShowMapMenuAction() {
    }

    @Override
    public Class<EmptyCmdLoader> getDtoClazz() {
        return EmptyCmdLoader.class;
    }

    @Override
    public void takeAction(EmptyCmdLoader v) {
        UserValidator.checkAuthentication();
        MapView.printMap(MapHolder.MAP.getMap());
    }

}
