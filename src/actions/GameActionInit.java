package actions;

import app_main.Settings;
import game_map.GameMap;

import java.util.HashMap;
import java.util.Map;

public class GameActionInit {
    private GameMap game_map;
    private ActionsWithEntity actions;

    public GameActionInit(GameMap m) {
        this.game_map = m;
        this.actions = new ActionsWithEntity(game_map);
        this.fillGameMap();

    }

    private void fillGameMap() {
        Map<String, Integer> startMap = new HashMap<>(Settings.START_MAP);
        for (Map.Entry<String, Integer> entry : startMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                actions.createEntyti(entry.getKey());
            }
        }
    }


}
