package actions;

import Interfaces.Movable;
import entities.Creature;
import entities.Entity;
import game_map.Coordinate;
import game_map.GameMap;

import java.util.Map;

import static app_main.Settings.Direction.*;

public class GameMapAction {
    private GameMap gameMap;
private ActionsWithEntity entityExexute;

    public GameMapAction(GameMap m) {
        this.gameMap = m;
    }

    public void stepAllEntites() {
        for (Map.Entry<Coordinate, Entity> entry : gameMap.getGame_map_copy().entrySet()) {
            Entity entity = entry.getValue();
        if(entity instanceof Creature){
             ((Movable) entity).move(LEFT, gameMap);
        }
        }

    }


}
