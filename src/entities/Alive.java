package entities;

import game_map.Coordinate;

public abstract class Alive extends Entity {
    protected int health;
    protected int maxHealth;

    public Alive(Coordinate c) {
        super(c);
    }

    protected void setHealth(int health) { // Реализация метода setHealth из интерфейса Alive
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage() {
        health -= 100;
    }

    public void increaceLife() {
        if (health <= maxHealth) {
            health += 30;
        }
    }
}
