package Interfaces;

import app_main.Settings.Direction;
import entities.Entity;
import game_map.Coordinate;
import game_map.GameMap;

public interface Movable {
    public default void move(Direction dir, GameMap gameMap) {
        Coordinate c = this.getCoordinate();
        Coordinate newCoordinate = new Coordinate(c);
        switch (dir) {
            case UP:
                newCoordinate.setPosY(c.getPosY() - 1);
                break;
            case DOWN:
                newCoordinate.setPosY(c.getPosY() + 1);
                break;
            case LEFT:
                newCoordinate.setPosX(c.getPosX() - 1);
                break;
            case RIGHT:
                newCoordinate.setPosX(c.getPosX() + 1);
                break;
        }
        if (newCoordinate.isCorrect()&gameMap.isCoordinateFree(newCoordinate)) {
            gameMap.remove(c);
            this.setCoordinate(newCoordinate);
            gameMap.setEntity((Entity) this);
        }

    }

    Coordinate getCoordinate();

    void setCoordinate(Coordinate c);
}
