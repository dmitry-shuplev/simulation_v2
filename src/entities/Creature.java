package entities;


import Interfaces.*;
import game_map.Coordinate;
import game_map.GameMap;

public abstract class Creature extends Alive implements Movable, PathFinder, Eating {
    protected String foodMarker;

    public Creature(Coordinate c) {
        super(c);
    }

    public String getFoodMarker() {
        return foodMarker;
    }


    public void deleteByHealthStatus(GameMap gameMap){
        if (health<=0) {gameMap.remove(this.getCoordinate());}
    }

}
