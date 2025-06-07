package entities;

import Interfaces.Movable;
import Interfaces.PathFinder;
import game_map.Coordinate;

public class Predator extends Creature{

    public Predator(Coordinate c){
        super(c);
        setHealth(app_main.Settings.PREDATOR_HEALTH);
        foodMarker = "Herbivore";
    }
}
