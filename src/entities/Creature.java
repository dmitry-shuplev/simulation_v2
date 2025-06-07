package entities;

import Interfaces.Movable;
import Interfaces.PathFinder;
import game_map.Coordinate;

public abstract class Creature extends Entity implements Movable, PathFinder {
    private int health;
    protected String foodMarker;

    public Creature(Coordinate c) {
        super(c);
    }

    public int getHealth() {
        return health;
    }

    public String getFoodMarker(){return foodMarker;}

    public void setHealth(int health) {
        this.health = health;
    }

}
