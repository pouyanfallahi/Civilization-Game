package ir.civilization.menu.play;


import ir.civilization.dao.user.UserDao;
import ir.civilization.dto.PlayGameDTO;
import ir.civilization.game.GameTurnThread;
import ir.civilization.holder.MapHolder;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.model.City;
import ir.civilization.model.Civilization;
import ir.civilization.model.Tile;
import ir.civilization.model.map.Map;
import ir.civilization.model.user.User;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayGameMenuAction extends AbstractMenuAction<PlayGameDTO> {

    public static final PlayGameMenuAction INSTANCE = new PlayGameMenuAction();

    private static final UserDao USER_DAO = UserDao.INSTANCE;

    private PlayGameMenuAction() {
    }

    @Override
    public Class<PlayGameDTO> getDtoClazz() {
        return PlayGameDTO.class;
    }

    @Override
    @SneakyThrows
    public void takeAction(PlayGameDTO dto) {
        // validation user authentication
//        UserValidator.checkAuthentication();
        List<String> players = dto.getPlayers();
        System.out.println("players: " + players);

        List<Civilization> civilizations = new ArrayList<>();
        Map map = MapHolder.MAP;
        char symbol = 'A';
        for (String player : players) {
            Optional<User> user = USER_DAO.findByUsername(player);
            if (!user.isPresent())
                throw new IllegalArgumentException(String.format("User with username %s does not exist!", player));

            Civilization civilization = new Civilization();
            civilization.setSymbol(symbol++);
            civilization.setUser(user.get());
            Tile tile = map.getRandomEmptyTile();
            civilization.getTiles().add(tile);
            City city = new City(civilization);
            tile.setOccupant(city);
            civilizations.add(civilization);
        }

        GameTurnThread gameTurnThread = new GameTurnThread(civilizations);
        gameTurnThread.start();
        gameTurnThread.join();
    }

}
