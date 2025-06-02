package app_main;

import game_map.GameMap;
import view.ButtonPanel;
import view.MapPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

public class AppSimulation extends JFrame {
    private int stepCounter = 0;

    public AppSimulation() {
        setSize(1200, 600);
        setTitle("Проект Симуляция road_map Сергея Жукова версия 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MapPanel mapPanel = new MapPanel();
        JLabel infoLabel = new JLabel("Шаг : 0, Инициация.");

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextTurn(infoLabel);
            }
        });
        ButtonPanel buttonPanel = new ButtonPanel(timer);

        setLayout(new BorderLayout());
        add(mapPanel, BorderLayout.NORTH);
        add(infoLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        setLocation(200, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppSimulation::new);
        GameMap gm = new GameMap();
    }

    public void nextTurn(JLabel labelInfo) {
        stepCounter++;
        labelInfo.setText("Шаг : " + stepCounter);
    }

    public void startSimulation() {
// здесь действия по инициализации карты
    }

    public void pauseSimulation() {
//этот метод под вопросом
    }

}
