package ir.civilization.model;

import ir.civilization.holder.GameContext;
import ir.civilization.holder.GameHolder;
import ir.civilization.model.map.MapObject;
import ir.civilization.model.unit.Unit;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static ir.civilization.utils.ColorConstant.*;

public class MapView {

    public static List<Function<Tile, String>> getTilesViewFunctions() {
        List<Function<Tile, String>> functions = new ArrayList<>();
        functions.add((t) -> {
            Position position = t.getPosition();
            return String.format(" %-1s(%s,%s)%-3s", "", position.getX(), position.getY(), "");
        });

        functions.add((t) -> {
            MapObject occupant = t.getOccupant();
            if (occupant != null) {
                Civilization owner = occupant.getOwner();
                if (owner != null) {
                    return String.format(" %-8s ", owner.getSymbol());
                }
            }
            return String.format(" %-8s ", "");
        });

        functions.add((t) -> {
            List<TerrainFeatureType> terrainFeatures = t.getType().getTerrainFeatures();
            Optional<TerrainFeatureType> hasPlain = terrainFeatures.stream().filter(tf -> tf == TerrainFeatureType.PLAIN).findAny();
            if (hasPlain.isPresent() && t.isHasRiver())
                return String.format(" %-8s ", TerrainFeatureType.PLAIN.getSymbol());
            if (CollectionUtils.isEmpty(terrainFeatures))
                return String.format(" %-8s ", "");
            return String.format(" %-8s ", terrainFeatures.get(0).getSymbol());
        });

        functions.add((t) -> {
            Unit unitNez = t.getUnitNez();
            if (unitNez != null)
                return String.format(" %-8s ", unitNez);

            return String.format(" %-8s ", "");
        });

        functions.add((t) -> {
            Unit unitGNez = t.getUnitGNez();
            if (unitGNez != null)
                return String.format(" %-8s ", unitGNez);

            return String.format(" %-8s ", "");
        });

        functions.add((t) -> String.format(" %-8s ", t.getType().getCost()));
        functions.add((t) -> String.format(" %-8s ", t.getType().getSymbol()));
        return functions;
    }

    public static void printMap(Tile[][] tiles) {
        List<Function<Tile, String>> functions = getTilesViewFunctions();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < 13 * tiles.length; j++) {
                System.out.print(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "/" + ANSI_RESET);
            }
            System.out.println();
            Tile[] tile = tiles[i];

            boolean f = false;
            for (Function<Tile, String> function : functions) {
                if (f)
                    System.out.println();
                if (!f)
                    f = true;

                for (int z = 0; z < tile.length; z++) {
                    Tile t = tile[z];
                    GameContext context = GameHolder.getCreatedContext();
                    if (!t.isHasRiver())
                        System.out.print(" " + ANSI_BLACK_BACKGROUND + "|" + ANSI_RESET + " ");
                    else
                        System.out.print(" " + ANSI_BLUE_BACKGROUND + ANSI_WHITE + "*" + ANSI_RESET + " ");
                    String s = "";
                    Tile visibleTile = t.getVisibleCurrentTileOrHistory(context.getCivilization());
                    if (visibleTile == null)
                        s = String.format(" %-8s ", "");
                    else
                        s = t.getType().getColor() + function.apply(visibleTile) + ANSI_RESET;
                    System.out.print(s);
                    if (z == tile.length - 1)
                        System.out.print(ANSI_BLACK_BACKGROUND + "|" + ANSI_RESET);
                }
            }

            if (i == tiles.length - 1) {
                System.out.println();
                for (int j = 0; j < 13 * tiles.length; j++) {
                    System.out.print(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "/" + ANSI_RESET);
                }
                System.out.println();
            } else {
                System.out.println();
            }
        }
    }

}
