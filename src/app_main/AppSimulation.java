package app_main;

import game_map.GameMap;
import view.ButtonPanel;
import view.MapPanel;

import javax.swing.*;
import java.awt.*;

public class AppSimulation extends JFrame {

    public AppSimulation() {
        setSize(1200, 600);
        setTitle("Проект Симуляция road_map Сергея Жукова версия 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MapPanel mapPanel = new MapPanel();
        ButtonPanel buttonPanel = new ButtonPanel();
        setLayout(new BorderLayout());
        add(mapPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        setLocation(200, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppSimulation::new);
        GameMap gm = new GameMap();
    }
}
