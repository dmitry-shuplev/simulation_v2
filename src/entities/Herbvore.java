package entities;

import app_main.Settings;
import game_map.Coordinate;

public class Herbvore extends Creature{
    public Herbvore(Coordinate c){
       super(c);
       setHealth(Settings.HERBIVORE_HEALTH);
    }
}
