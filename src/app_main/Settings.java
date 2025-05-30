package app_main;

import game_map.Coordinate;

import java.util.HashMap;
import java.util.Map;

public class Settings {
    public static final int GAME_FIELD_X_MAX = 25;
    public static final int GAME_FIELD_Y_MAX = 10;
    public static final int GRASS_QUANTITY = 1;
    public static final int HERBIVORE_HEALTH = 1;
    public static final int PREDATOR_HEALTH = 1;

    public static Map<String, Integer> startMap = Map.of(
            "Herbvore", 5,
            "Predator", 2,
            "Grass", 6,
            "Tree", 10,
            "Stone", 20
    );

}
   