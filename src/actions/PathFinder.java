package actions;

import entities.Creature;
import game_map.Coordinate;
import game_map.GameMap;

import java.util.List;

public class PathFinder {
    GameMap gameMap;
    Creature creature;

    public PathFinder(GameMap gm, Creature cr) {
        gameMap = gm;
        creature = cr;
    }



}
