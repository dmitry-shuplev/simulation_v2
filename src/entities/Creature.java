package entities;

import game_map.Coordinate;

public abstract class Creature extends Entity {
    private int health;

    public Creature(Coordinate c) {
        super(c);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
