package ir.civilization;

import ir.civilization.initializer.ClassInitializer;
import ir.civilization.menu.main.GameMenuRunner;
import org.apache.commons.cli.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        ClassInitializer.INSTANCE.initializeAllClasses();
////        UserMenu.INSTANCE.run("user create --username ali --password a123 --nickname a");
////        UserMenu.INSTANCE.run("user create --username akbar --password a123 --nickname ak");
////        System.out.println(UserDao.INSTANCE.findByUsername(AuthenticatedUserHolder.INSTANCE.getPrinciple()));
//        GameMainMenu.INSTANCE.handleMenu("user login --username mmad --password a12345");
//        System.out.println(UserDao.INSTANCE.findByUsername(AuthenticatedUserHolder.INSTANCE.getPrinciple()));
////        ProfileMenu.INSTANCE.run("profile change --nickname mmad");
////        System.out.println(UserDao.INSTANCE.findByUsername(AuthenticatedUserHolder.INSTANCE.getPrinciple()));
////        ProfileMenu.INSTANCE.run("profile change --password --current a123 --new a12345");
////        System.out.println(UserDao.INSTANCE.findByUsername(AuthenticatedUserHolder.INSTANCE.getPrinciple()));
////        MapMenu.INSTANCE.run("map show");
////        SelectMenu.INSTANCE.run("select unit --unit_type COMBAT -x 4 -y 4");
////        MapMenu.INSTANCE.run("map show");
////        UnitMenu.INSTANCE.run("unit moveto -x 4 -y 7");
//        GameMainMenu.INSTANCE.handleMenu("play game --players ali,mmad,akbar");
//        GameMainMenu.INSTANCE.handleMenu("map show");
//        GameMainMenu.INSTANCE.handleMenu("user logout");
//        System.out.println(AuthenticatedUserHolder.INSTANCE.getPrinciple());
//        GameMainMenu.INSTANCE.handleMenu("map show");
        GameMenuRunner runner = new GameMenuRunner();
        runner.run();

//        new GameTurnThread(Arrays.asList("ali", "mmad", "akbar"));
    }

}