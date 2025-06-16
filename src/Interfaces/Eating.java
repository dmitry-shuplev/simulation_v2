package Interfaces;

import entities.Alive;
import entities.Creature;
import entities.Entity;
import game_map.Coordinate;
import game_map.CoordinateUtils;
import game_map.GameMap;

import java.util.List;
import java.util.Map;

public interface Eating {
    default boolean eat(GameMap gameMap) {
        if (this.getHealth()<=0){gameMap.remove(this.getCoordinate());}
        List<Coordinate> neighbors = CoordinateUtils.getNaigborsCoordinates(getCoordinate());
        Creature creature = (Creature) this;
        for (Coordinate neigborCoordinate : neighbors) {
            Entity entity = gameMap.getEntity(neigborCoordinate);
            if (entity == null || !(entity instanceof Alive)) {
                continue;
            }
            Alive neighbor = (Alive) entity;
            if (neighbor.getClass().getSimpleName().equals(getFoodMarker())) {
                neighbor.takeDamage(100);
                creature.increaceLife();
                if (neighbor.getHealth() <= 0) {
                    gameMap.remove(neigborCoordinate);
                    neighbor.setCoordinate(new Coordinate(0, 0));
                    gameMap.remove(getCoordinate());
                    creature.setCoordinate(neigborCoordinate);
                    gameMap.setEntity(creature);
                }
                return true;
            }
        }
        return false;
    }

    Coordinate getCoordinate();

    int getHealth();

    String getFoodMarker();

}
