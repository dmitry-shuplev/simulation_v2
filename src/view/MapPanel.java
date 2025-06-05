package view;

import game_map.GameMap;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {
  private MapComponents components;
    public MapPanel(JComponent map_view) {
        setLayout(new BorderLayout());
        add(map_view, BorderLayout.CENTER);
    }

}
