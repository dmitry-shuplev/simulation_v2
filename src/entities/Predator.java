package entities;

import app_main.Settings;
import game_map.Coordinate;

public class Predator extends Creature{
    public Predator(Coordinate c){
        super(c);
        foodMarker = "Herbivore";
        setHealth(app_main.Settings.PREDATOR_HEALTH);
        maxHealth = Settings.HERBIVORE_HEALTH_MAX;

    }
}
