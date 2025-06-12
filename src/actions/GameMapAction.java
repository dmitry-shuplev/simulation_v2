package actions;

import app_main.Settings;
import entities.*;
import game_map.Coordinate;
import game_map.GameMap;

import java.util.Map;

import static app_main.Settings.Direction.*;

public class GameMapAction {
    private GameMap gameMap;
    private Randomiser randomiser;

    public GameMapAction(GameMap m) {
        this.gameMap = m;
        this.randomiser = new Randomiser(gameMap);
    }

    public void stepAllEntites() {
        for (Map.Entry<Coordinate, Entity> entry : gameMap.getGame_map_copy().entrySet()) {
            Entity entity = entry.getValue();
            WorkLoop:
            if (entity instanceof Creature) {
                Creature creature = (Creature) entity;
                boolean wasEaten = creature.eat(gameMap);
                if(randomiser.isHerbivoreLose() && creature instanceof Herbivore){
                    break WorkLoop;
                }
                if (!wasEaten) {
                    creature.move(creature.getNextStepDirection(gameMap), gameMap);
                }
            }
        }
        gameMap.setEntity(new Grass(new Randomiser(gameMap).getFreeCoordinate()));

    }

}
