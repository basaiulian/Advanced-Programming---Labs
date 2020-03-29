package com.company.lab6.compulsory;

import javax.swing.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    RegularPolygonConfigPanel regularPolygonConfigPanel;
    CircleConfigPanel circleConfigPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        this.setResizable(false);
        regularPolygonConfigPanel = new RegularPolygonConfigPanel(this);
        //circleConfigPanel = new CircleConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);
        init();
    }

    private void init() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // start in center

        //TODO
        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default

        add(regularPolygonConfigPanel, NORTH);

        //functioneaza, dar nu am reusit sa fac sa se schimbe dintr-un configPanel in altul la actionarea spinnerului
        //add(circleConfigPanel, NORTH);

        add(canvas, CENTER);     //this is BorderLayout.CENTER

        add(controlPanel, SOUTH);

        //TODO
        //invoke the layout manager
        pack();
    }

    public void resetCanvas() {
        canvas = new DrawingPanel(this);
    }
}