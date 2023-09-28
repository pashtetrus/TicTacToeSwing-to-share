package ru.geekbrains.jdk;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;

    JButton btnStart = new JButton("Start new game");
    ButtonGroup buttonGroup = new ButtonGroup();
    JRadioButton buttonMode1 = new JRadioButton("Человек против компьютера");
    JRadioButton buttonMode2 = new JRadioButton("Человек против человека");
    JSlider slider = new JSlider(3, 10, 3);

    JSlider winLengthSlider = new JSlider(3, 3, 3);
    JLabel fieldSizeLabel = new JLabel("Размер поля (по умолчанию 3):");
    JLabel winLengthLabel = new JLabel("Длина выигрышной строки (по умолчанию 3):");

    private static int fieldSize = 3;
    private static int mode = 0;
    private static int winLength = 3;

    public SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        buttonGroup.add(buttonMode1);
        buttonGroup.add(buttonMode2);
        buttonMode1.setSelected(true);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonMode2.isSelected()) {
                    mode = 1;
                }
                gameWindow.startNewGame(mode, fieldSize, fieldSize, winLength);
                setVisible(false);
            }
        });
        setLayout(new GridLayout(10, 1));
        add(new JLabel("Выберите режим игры:"));
        add(buttonMode1);
        add(buttonMode2);
        add(fieldSizeLabel);
        add(slider);
        add(winLengthLabel);
        add(winLengthSlider);
        JPanel panBottom = new JPanel(new GridLayout(1, 1));
        panBottom.add(btnStart);
        add(panBottom, BorderLayout.SOUTH);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                fieldSize = slider.getValue();
                fieldSizeLabel.setText("Размер поля: " + fieldSize);
                winLengthSlider.setMaximum(fieldSize);
            }
        });
        winLengthSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                winLength = winLengthSlider.getValue();
                winLengthLabel.setText("Длина выигрышной последовательности: " + winLength);
            }
        });
    }
}
