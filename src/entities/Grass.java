package entities;

import app_main.Settings;
import game_map.Coordinate;

import java.util.Collection;

public class Grass extends Entity{
    int quantity;
    public Grass(Coordinate c){
        super(c);
        int quntity = app_main.Settings.GRASS_QUANTITY;
    }
}
