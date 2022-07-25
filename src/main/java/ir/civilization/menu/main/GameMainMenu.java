package ir.civilization.menu.main;

import ir.civilization.menu.AbstractMenu;
import ir.civilization.menu.info.InfoMenu;
import ir.civilization.menu.map.MapMenu;
import ir.civilization.menu.play.PlayMenu;
import ir.civilization.menu.profile.ProfileMenu;
import ir.civilization.menu.select.SelectMenu;
import ir.civilization.menu.unit.UnitMenu;
import ir.civilization.menu.user.UserMenu;

import java.util.Arrays;
import java.util.List;

public class GameMainMenu {

    private final List<AbstractMenu> menus;

    public static final GameMainMenu INSTANCE = new GameMainMenu();

    private GameMainMenu() {
        this.menus = Arrays.asList(
                InfoMenu.INSTANCE,
                MapMenu.INSTANCE,
                PlayMenu.INSTANCE,
                ProfileMenu.INSTANCE,
                SelectMenu.INSTANCE,
                UnitMenu.INSTANCE,
                UserMenu.INSTANCE
        );
    }

    public void handleMenu(String input) {
        for (AbstractMenu menu : menus) {
            try {
                menu.run(input);
            } catch (Exception e) {
                String message = e.getMessage();
                if (message != null)
                    System.out.println(message);
                else
                    e.printStackTrace();
            }
        }
    }

}
