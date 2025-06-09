package entities;

import game_map.Coordinate;

public class Grass extends Alive {

    public Grass(Coordinate c) {
        super(c);
         setHealth(app_main.Settings.GRASS_QUANTITY);
    }
}



