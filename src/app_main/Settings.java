package app_main;

import java.util.Map;

public class Settings {
    public static final int VIEW_WIDTH = 1200;
    public static final int VIEW_HEIGHT = 600;

    public static final int GAME_FIELD_X_MAX = 30;
    public static final int GAME_FIELD_Y_MAX = 12;
    public static final int GRASS_QUANTITY = 1;
    public static final int HERBIVORE_HEALTH = 1;
    public static final int PREDATOR_HEALTH = 1;

    public final static Map<String, Integer> START_MAP = Map.of(
            "Herbivore", 5,
            "Predator", 2,
            "Grass", 6,
            "Tree", 20,
            "Rock", 50
    );

    public enum Direction {
        UP,
        DOWN,
        RIGHT,
        LEFT
    }


}
   