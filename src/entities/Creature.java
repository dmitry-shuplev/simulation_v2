package entities;


import Interfaces.*;
import game_map.Coordinate;
import game_map.GameMap;

public abstract class Creature extends Alive implements Movable, PathFinder, Eating {
    private int health;
    protected String foodMarker;
    boolean activity;

    public Creature(Coordinate c) {
        super(c);
        activity = true;
    }

    public String getFoodMarker() {
        return foodMarker;
    }

    public void clearActivityCount(){
        activity = true;
    }

    public boolean isActive(){
        return activity;
    }

    public void stepDone(){
        activity = false;
    }

    public void deleteByHealthStatus(GameMap gameMap){
        if (health<=0) {gameMap.remove(this.getCoordinate());}
    }

}
