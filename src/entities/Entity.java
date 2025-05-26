package entities;

import game_map.Coordinate;

public abstract class Entity {
    private Coordinate coordinate;

    public Entity(Coordinate c) {
        coordinate = c;
    }
}
