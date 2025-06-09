package entities;

import game_map.Coordinate;

public abstract class Alive extends Entity {
    private  int health;

    public Alive(Coordinate c){
        super(c);
    }
    protected void setHealth(int health) { // Реализация метода setHealth из интерфейса Alive
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage() {
        health--;
    }

    public void increaceLife() {
        health++;
    }
}
