package game_map;

import app_main.Settings;
import entities.Entity;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
    Map<Coordinate, Entity> game_map = new HashMap<>();
    public GameMap(){
        this.init();
    }

    private void init(){
        System.out.println(Settings.startMap);
    }

    public boolean isCoordinateFree(Coordinate c){
        return !game_map.containsKey(c);
    }

}
