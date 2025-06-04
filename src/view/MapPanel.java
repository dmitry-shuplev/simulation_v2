package view;

import game_map.GameMap;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {
  private MapComponents components;
    public MapPanel(GameMap gm) {
        components = new MapComponents(gm);
        setLayout(new BorderLayout());
        add(components, BorderLayout.CENTER);
    }
}
