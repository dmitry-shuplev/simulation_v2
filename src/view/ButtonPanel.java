package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private Timer timer;

    public ButtonPanel(Timer timer) {
        this.timer = timer;
        setBackground(Color.BLACK);
        JButton startButton = new JButton("Старт");
        JButton pauseButton = new JButton("Приостановить");

        JButton finishButton = new JButton("Закончить");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Старт");
                timer.start();
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                System.out.println("Пауза");
            }
        });

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        add(startButton);
        add(pauseButton);
        add(finishButton);
    }

}
