package com.company.lab6.compulsory;


import com.sun.deploy.panel.ControlPanel;
import com.sun.xml.internal.bind.v2.TODO;
import sun.security.krb5.Config;

import javax.swing.*;

import java.awt.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {

        super("My Drawing Application");
        this.setResizable(false);
        configPanel = new ConfigPanel(this);
        init();
    }

    private void init() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(configPanel, NORTH);
        //create the components
        canvas = new DrawingPanel(this);
        //TODO

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, CENTER); //this is BorderLayout.CENTER
        //TODO


        //invoke the layout manager
        pack();
    }
}
