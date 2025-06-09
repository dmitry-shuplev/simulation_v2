package Interfaces;

import app_main.Settings;
import entities.Alive;
import entities.Creature;
import entities.Entity;
import game_map.Coordinate;
import game_map.CoordinateUtils;
import game_map.GameMap;

import java.util.List;

public interface Eating {
    public default void eat(GameMap gameMap) {
        List<Coordinate> neighbors = CoordinateUtils.getNaigborsCoordinates(getCoordinate());
        Creature creature = (Creature) gameMap.getEntity(getCoordinate());
        for (Coordinate neigborCoordinate : neighbors) {
            Entity entity = gameMap.getEntity(neigborCoordinate);

            if(entity==null || !(entity instanceof Alive)){continue;}
            Alive neighbor = (Alive) entity;
            if (neighbor.getClass().getSimpleName().equals(getFoodMarker())) {
                 neighbor.takeDamage();
                 creature.increaceLife();
            }
            if(neighbor.getHealth()<=0){
                gameMap.remove(neigborCoordinate);
                gameMap.remove(getCoordinate());
                creature.setCoordinate(neigborCoordinate);
                gameMap.setEntity(creature);
                //log
                System.out.println(creature.getHealth());
            }


        }
    }

    Coordinate getCoordinate();
    String getFoodMarker();
}
