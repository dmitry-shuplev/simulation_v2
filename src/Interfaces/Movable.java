package Interfaces;

import app_main.Settings.Direction;
import entities.Entity;
import game_map.Coordinate;
import game_map.CoordinateUtils;
import game_map.GameMap;

public interface Movable {

    public default void move(Direction dir, GameMap gameMap) {
        if (dir == Direction.HOLD_POSITION) return;
        if (this.getHealth()<=0){gameMap.remove(this.getCoordinate());}
        Coordinate newCoordinate = CoordinateUtils.getCoorFromDirection(this.getCoordinate(), dir);
        if (newCoordinate.isCorrect()&gameMap.isCoordinateFree(newCoordinate)) {
            gameMap.remove(this.getCoordinate());
            this.setCoordinate(newCoordinate);
            gameMap.setEntity((Entity) this);
        }

    }
    int getHealth();
    Coordinate getCoordinate();
    void setCoordinate(Coordinate c);
}
