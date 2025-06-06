package entities;

import Interfaces.Movable;
import game_map.Coordinate;

public class Predator extends Creature implements Movable {

    public Predator(Coordinate c){
        super(c);
        setHealth(app_main.Settings.PREDATOR_HEALTH);
        foodMarker = "Herbivore";
    }
}
