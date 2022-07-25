package ir.civilization.holder;

public class GameHolder {

    public static final ThreadLocal<GameContext> GTL = new ThreadLocal<>();

    public static GameContext getCreatedContext() {
        GameContext gameContext = GTL.get();
        if (gameContext == null) {
            gameContext = new GameContext();
            GTL.set(gameContext);
        }

        return gameContext;
    }

}
