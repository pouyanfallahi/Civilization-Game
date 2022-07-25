package ir.civilization.game;

import ir.civilization.holder.GameContext;
import ir.civilization.holder.GameHolder;
import ir.civilization.menu.main.GameMenuRunner;
import ir.civilization.model.Civilization;

public class GameUserThread extends Thread {

    private final Civilization civilization;

    public GameUserThread(Civilization civilization) {
        super(civilization.getUser().getUsername());
        this.civilization = civilization;
    }

    @Override
    public void run() {
        ThreadLocal<GameContext> gtl = GameHolder.GTL;
        if (gtl.get() == null) {
            GameContext createdContext = GameHolder.getCreatedContext();
            createdContext.setCivilization(civilization);
        }
        new GameMenuRunner().run();
    }

}
