package Interfaces;

import app_main.Settings.Direction;
import entities.Entity;
import game_map.Coordinate;
import game_map.CoordinateUtils;
import game_map.GameMap;

public interface Movable {

     default void move(Direction dir, GameMap gameMap) {
        if (!this.isAlive()) {
            gameMap.remove(this.getCoordinate());
        }
        if (dir == Direction.HOLD_POSITION) return;
        Coordinate newCoordinate = CoordinateUtils.getCoorFromDirection(this.getCoordinate(), dir);
        if (newCoordinate.isCorrect() & gameMap.isCoordinateFree(newCoordinate)) {
            gameMap.remove(this.getCoordinate());
            this.setCoordinate(newCoordinate);
            gameMap.setEntity((Entity) this);
        }

    }

    int getHealth();

    boolean isAlive();

    Coordinate getCoordinate();

    void setCoordinate(Coordinate c);
}
