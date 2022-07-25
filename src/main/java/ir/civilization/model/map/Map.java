package ir.civilization.model.map;

import ir.civilization.model.Position;
import ir.civilization.model.TerrainType;
import ir.civilization.model.Tile;
import lombok.Getter;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

@Getter
public class Map {

    private Tile[][] map;

    public Map(int rows, int columns) {
        // TileType[] types = TileType.values();
        map = new Tile[rows][columns];

//        for (int r = 0; r < map.length; r++) {
//            for (int c = 0; c < map[r].length; c++) {
//                int i = rand.nextInt(3);
//                map[r][c] =;
//            }
//        }

        //Populate the map with different Terrain types
        populateMap();
    }

    public Set<Tile> getMapAsSet() {
        return Arrays.stream(this.map)
                .flatMap(Arrays::stream)
                .collect(Collectors.toSet());
    }

    //this will also populate the map hopefully
    private void populateMap() {
        TerrainType[][] tiles = new TerrainType[10][10];
        //populates with whatever terrain you want
        //this could be made better if you make map give you an array of
        //TileTypes instead
        SecureRandom rand = new SecureRandom();
        SecureRandom riverRand = new SecureRandom();

        for (int r = 0; r < 10; r++) {
            TerrainType[] row = new TerrainType[10];
            for (int c = 0; c < 10; c++) {
                int seed = rand.nextInt(8);
                TerrainType type = null;

                switch (seed) {
                    case 1:
                        type = TerrainType.DESERT;
                        break;
                    case 2:
                        type = TerrainType.MEADOW;
                        break;
                    case 3:
                        type = TerrainType.HILL;
                        break;
                    case 4:
                        type = TerrainType.MOUNTAIN;
                        break;
                    case 5:
                        type = TerrainType.OCEAN;
                        break;
                    case 6:
                        type = TerrainType.FIELD;
                        break;
                    case 7:
                        type = TerrainType.SNOW;
                        break;
                    case 0:
                        type = TerrainType.TUNDRA;
                        break;
                }

                int i = rand.nextInt(3);
                map[r][c] =  new Tile(null, type, Position.builder()
                        .x(r)
                        .y(c)
                        .build(), i == 0);
                row[c] = type;
            }
            tiles[r] = row;
        }
    }

    public Tile getTile(int r, int c) {
        validateInput(r, c);
        return map[r][c];
    }

    public boolean isEmpty(int r, int c) {
        return map[r][c].getOccupant() == null;
    }

    public int getRows() {
        return map.length;
    }

    public int getColumns() {
        return map[0].length;
    }

    public Tile getNearestNonBandit(int r, int c) {
        return bfs(r, c);
    }

    private void validateInput(int r, int c) {
        if ((r < 0 || r > this.map.length)
                || (c < 0 || c > this.map[0].length))
            throw new IllegalArgumentException(String.format("invalid tile position (%d,%d)", r, c));
    }

    private Tile bfs(int r, int c) {
        Queue<Tile> queue = new LinkedList<Tile>();
        Set<Tile> closed = new HashSet<Tile>();
        Tile current;
        queue.add(map[r][c]);
        closed.add(map[r][c]);
        while (!queue.isEmpty()) {
            current = queue.remove();
            if (!current.isEmpty()
                    && (current.getOccupant().isFriendly())) {
                return current;
            } else {
                for (int dr = current.getPosition().getX() - 1; dr <= current.getPosition().getX() + 1;
                     dr++) {
                    for (int dc = current.getPosition().getY() - 1;
                         dc <= current.getPosition().getY() + 1; dc++) {
                        if  (dr >= 0 && dr < 10 && dc >= 0 && dc < 10) {
                            if (!closed.contains(map[dr][dc])) {
                                queue.add(map[dr][dc]);
                                closed.add(map[dr][dc]);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static int getDirectedRow(Tile start, Tile end) {
        return normalizeComponent(end.getPosition().getX() - start.getPosition().getX());
    }

    public static int getDirectedCol(Tile start, Tile end) {
        return normalizeComponent(end.getPosition().getY() - start.getPosition().getY());
    }

    private static int normalizeComponent(int value) {
        if (value < 0) {
            return -1;
        } else if (value > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public Tile getRandomEmptyTile() {
        Tile tile = this.getRandomTile();
        while (!tile.isEmpty() && tile.isAccessible()) tile = this.getRandomTile();
        return tile;
    }

    private static final SecureRandom TILE_SELECTION_RANDOM = new SecureRandom();

    private Tile getRandomTile() {
        int x = TILE_SELECTION_RANDOM.nextInt(10);
        int y = TILE_SELECTION_RANDOM.nextInt(10);
        return this.getTile(x, y);
    }
}
