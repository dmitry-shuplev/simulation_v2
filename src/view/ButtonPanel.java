package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {

    public ButtonPanel() {
        setBackground(Color.BLUE);
        JButton startButton = new JButton("Старт");
        JButton finishButton = new JButton("Финиш");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//добавить логику кнопки

           }
        });

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //Добавить логику кнопки
            }
        });
        add(startButton);
        add(finishButton);
    }

}
