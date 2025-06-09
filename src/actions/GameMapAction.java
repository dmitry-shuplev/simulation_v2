package actions;

import app_main.Settings;
import entities.*;
import game_map.Coordinate;
import game_map.GameMap;

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
            if (entity instanceof Creature) {
                Creature creature = (Creature) entity;
                boolean wasEaten = creature.eat(gameMap);
                //log
                if (!wasEaten) {
                    creature.move(creature.getNextStepDirection(gameMap), gameMap);
                } else {
                    System.out.println("Существо:" + creature.getClass().getSimpleName() + " уже когото съело,");
                }
                System.out.println("Существо" + creature.getClass().getSimpleName() + "Здоровье:"+creature.getHealth());
            }
        }
        gameMap.setEntity(new Grass(new Randomiser(gameMap).getFreeCoordinate()));

    }

}
