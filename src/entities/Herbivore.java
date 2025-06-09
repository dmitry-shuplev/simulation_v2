package entities;

import app_main.Settings;
import game_map.Coordinate;

public class Herbivore extends Creature {
    public Herbivore(Coordinate c){
       super(c);
       foodMarker = "Grass";
       setHealth(Settings.HERBIVORE_HEALTH);
       maxHealth = Settings.HERBIVORE_HEALTH_MAX;
    }
}
