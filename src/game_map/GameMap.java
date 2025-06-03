package game_map;

import app_main.Settings;
import entities.Entity;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
    Map<Coordinate, Entity> game_map;

    public GameMap() {
        game_map = new HashMap<>();
    }


    public void setEntity(Entity entity) {
        game_map.put(entity.getCoordinate(), entity);
    }



    public boolean isCoordinateFree(Coordinate c) {
        return !game_map.containsKey(c);
    }

}
