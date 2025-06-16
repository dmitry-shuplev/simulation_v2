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

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void increaceLife() {
        if (health <= maxHealth) {
            health += 30;
        }
    }
}
