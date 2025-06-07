package actions;

import Interfaces.Movable;
import app_main.Settings;
import entities.Creature;
import entities.Entity;
import entities.Herbivore;
import game_map.Coordinate;
import game_map.GameMap;

import java.awt.image.DirectColorModel;
import java.util.Map;

import static app_main.Settings.Direction.*;

public class GameMapAction {
    private GameMap gameMap;

    public GameMapAction(GameMap m) {
        this.gameMap = m;
    }

    public void stepAllEntites() {
        for (Map.Entry<Coordinate, Entity> entry : gameMap.getGame_map_copy().entrySet()) {
            Entity entity = entry.getValue();
        if(entity instanceof Creature){
            Creature creature = (Creature) entity;
            Coordinate preyCoordinate = creature.findPreyCoordinate(gameMap);
            System.out.println(creature.findPath(gameMap, preyCoordinate));
            creature.move(creature.getNextStepDirection(gameMap), gameMap);
        }
        }

    }

    private Settings.Direction getNextStepDirection(Creature hanter, Entity prey){


        //log
        return UP;
    }


}
