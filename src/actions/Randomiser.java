package actions;

import app_main.Settings.*;
import game_map.Coordinate;
import game_map.GameMap;

import java.util.Random;

import static java.lang.Math.random;


public class Randomiser {
    private final int XMax = app_main.Settings.GAME_FIELD_X_MAX;
    private final int YMax = app_main.Settings.GAME_FIELD_Y_MAX;
    Random random;
    GameMap gameMap;

    public Randomiser(GameMap gm) {
        this.random = new Random();
        this.gameMap = gm;
    }

    public Coordinate getFreeCoordinate() {
        int posX = this.random.nextInt(XMax);
        int posY = this.random.nextInt(YMax);
        Coordinate coordinate = new Coordinate(posX, posY);
        if (!gameMap.isCoordinateFree(coordinate)) {
            this.getFreeCoordinate();
        }
        return coordinate;
    }

    public boolean isHerbivoreLose(){
        return this.random.nextInt(100)>70;
    }

    public boolean isFail() {
        return  random.nextInt(100) >= 70;
    }
}
