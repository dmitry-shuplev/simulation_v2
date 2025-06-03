package actions;

import game_map.*;
import entities.*;

public class ActionsWithEntity {
    Randomiser randomiser;
    GameMap gameMap;

    public ActionsWithEntity(GameMap gm) {
        this.randomiser = new Randomiser(gm);
        this.gameMap = gm;
    }

    public void createEntyti(String entityName) {
        Coordinate entityCoordinate = randomiser.getFreeCoordinate();
        try {
            Class<?> clazz = Class.forName("entities." + entityName);
            var constructor = clazz.getDeclaredConstructor(Coordinate.class);
            Object entity = constructor.newInstance(entityCoordinate);
            gameMap.setEntity((Entity) entity);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
