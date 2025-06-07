package Interfaces;

import entities.Entity;
import game_map.Coordinate;
import game_map.CoordinateUtils;
import game_map.GameMap;

import java.util.List;

public class Eating {
    public void eat(GameMap gameMap) {
        List<Coordinate> neighbors = CoordinateUtils.getNaigborsCoordinates(getCoordinate());
        for (Coordinate neigborCoordinate : neighbors) {
            Entity neighbor = gameMap.getEntity(neigborCoordinate);
            if (neighbor.getClass().getSimpleName().equals(getFoodMarker())) {
neighbor.
            }

        }
    }

    Coordinate getCoordinate();

    String getFoodMarker();

}
