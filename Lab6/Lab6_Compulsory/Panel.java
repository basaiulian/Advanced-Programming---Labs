package com.company.lab6.compulsory;

import javax.swing.*;
import java.awt.*;

import static java.awt.GridBagConstraints.*;

public class Panel extends JPanel {
    public Panel() {
        JLabel configLabel;
        JLabel sizeLabel;
        JLabel sidesNumberLabel;
        JLabel strokeLabel;
        JLabel colorLabel;

        JTextField sizeTextField;
        JTextField sidesNumberTextField;
        JTextField strokeTextField;
        JTextField colorTextField;

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weighty = 1;
        constraints.anchor = NORTH;
        configLabel = new JLabel("Configuration Panel");
        configLabel.setFont(new Font("Comic Sans MS", Font.BOLD,18));
        add(configLabel, constraints);

        //Labels
        sizeLabel = new JLabel("Size");
        constraints.weightx = 1;
        constraints.insets.set(60,100,0,0);
        constraints.anchor = NORTHWEST;
        sizeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,12));
        add(sizeLabel, constraints);

        sidesNumberLabel = new JLabel("Sides number");
        constraints.insets.set(60,205,0,0);
        sidesNumberLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,12));
        add(sidesNumberLabel,constraints);

        strokeLabel = new JLabel("Stroke");
        constraints.insets.set(60,350,0,0);
        strokeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,12));
        add(strokeLabel,constraints);

        colorLabel = new JLabel("Color");
        constraints.insets.set(60,485,0,0);
        colorLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,12));
        add(colorLabel,constraints);

        //TextFields
        sizeTextField = new JTextField(7);
        sizeTextField.setToolTipText("Size should be positive!");
        constraints.insets.set(80,70,0,0);
        add(sizeTextField,constraints);

        sidesNumberTextField = new JTextField(7);
        sidesNumberTextField.setToolTipText("Sides number should be positive!");
        constraints.insets.set(80,200,0,0);
        add(sidesNumberTextField,constraints);

        strokeTextField = new JTextField(7);
        strokeTextField.setToolTipText("Stroke should be positive!");
        constraints.insets.set(80,330,0,0);
        add(strokeTextField,constraints);

        colorTextField = new JTextField(7);
        colorTextField.setToolTipText("What is your favourite color?");
        constraints.insets.set(80,460,0,0);
        add(colorTextField,constraints);



    }
}
