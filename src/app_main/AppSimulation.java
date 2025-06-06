package app_main;

import actions.GameActionInit;
import actions.GameMapAction;
import game_map.GameMap;
import view.ButtonPanel;
import view.MapComponents;
import view.MapPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

public class AppSimulation extends JFrame {
    private int stepCounter = 0;
    private GameMap gameMap;
    private MapComponents mapComponents;
    //private ActionsWithEntity entityExecute;
    private GameMapAction entityExecute;

    private int width = Settings.VIEW_WIDTH;
    private int height = Settings.VIEW_HEIGHT;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppSimulation::new);
    }

    public AppSimulation() {
        this.gameMap = new GameMap();
        entityExecute = new GameMapAction(gameMap);
        setSize(width, height);
        setTitle("Проект Симуляция road_map Сергея Жукова версия 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mapComponents = new MapComponents(gameMap);
        MapPanel mapPanel = new MapPanel(mapComponents);
        JPanel southPanel = new JPanel(new FlowLayout());
        JLabel infoLabel = new JLabel("Шаг : 0, Инициация.");

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextTurn(infoLabel);
            }
        });
        ButtonPanel buttonPanel = new ButtonPanel(timer);
        southPanel.add(infoLabel);
        southPanel.add(buttonPanel);

        setLayout(new BorderLayout());
        add(mapPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        setLocation(200, 200);
        setVisible(true);
        this.startSimulation();
    }


    public void nextTurn(JLabel labelInfo) {
        stepCounter++;
        labelInfo.setText("Шаг : " + stepCounter);
        entityExecute.stepAllEntites();
        mapComponents.repaint();
    }

    public void startSimulation() {
        new GameActionInit(gameMap);
        System.out.println(gameMap.toString());
    }

    public void pauseSimulation() {
//этот метод под вопросом
    }

}
