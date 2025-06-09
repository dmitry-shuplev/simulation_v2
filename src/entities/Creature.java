package entities;


import Interfaces.*;
import game_map.Coordinate;

public abstract class Creature extends Alive implements Movable, PathFinder, Eating {
    private int health;
    protected String foodMarker;

    public Creature(Coordinate c) {
        super(c);
    }

    public String getFoodMarker() {
        return foodMarker;
    }

}
