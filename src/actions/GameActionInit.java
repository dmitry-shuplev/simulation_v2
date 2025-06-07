package actions;

import app_main.Settings;
import entities.Entity;
import entities.Herbivore;
import entities.Predator;
import game_map.Coordinate;
import game_map.GameMap;

import java.util.HashMap;
import java.util.Map;

public class GameActionInit {
    private GameMap gameMap;
    Randomiser randomiser;

    public GameActionInit(GameMap m) {
        this.gameMap = m;
        this.randomiser = new Randomiser(gameMap);
        this.fillGameMap();
     //stub
        //gameMap.setEntity(new Herbivore(new Coordinate(0, 0)));
        gameMap.setEntity(new Herbivore(new Coordinate(12, 10)));
        gameMap.setEntity(new Predator(new Coordinate(0, 5)));
    }

    private void fillGameMap() {
        Map<String, Integer> startMap = new HashMap<>(Settings.START_MAP);
        for (Map.Entry<String, Integer> entry : startMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                createEntity(entry.getKey());
            }
        }
    }

    public void createEntity(String entityName) {
        Coordinate entityCoordinate = randomiser.getFreeCoordinate();
        try {
            Class<?> clazz = Class.forName("entities." + entityName);
            var constructor = clazz.getDeclaredConstructor(Coordinate.class);
            Object entity = constructor.newInstance(entityCoordinate);
            gameMap.setEntity((Entity) entity);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
