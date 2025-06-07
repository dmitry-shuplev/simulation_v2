package entities;

import Interfaces.*;
import app_main.Settings;
import game_map.Coordinate;

public class Herbivore extends Creature {
    public Herbivore(Coordinate c){
       super(c);
       setHealth(Settings.HERBIVORE_HEALTH);
       foodMarker = "Grass";
    }
}
