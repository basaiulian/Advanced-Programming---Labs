package com.company.lab6.compulsory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class Main {

    public static void main(String[] args) {
        //Main frame
        JFrame frame = new JFrame();
        frame.setSize(1024,768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Shapes Drawer");
        frame.setResizable(false);

        //Configuration panel
        Panel panel = new Panel();
        panel.setBackground(Color.lightGray);

        //Drawing panel
        JPanel drawingPanel = new JPanel();
        drawingPanel.setLayout(new BoxLayout(drawingPanel,BoxLayout.X_AXIS));
        drawingPanel.setBackground(Color.white);
        Border border = BorderFactory.createLineBorder(Color.black);
        drawingPanel.setBorder(border);

        frame.add(panel);
        panel.setSize(frame.getWidth(),frame.getHeight()/6);
        frame.add(drawingPanel,BorderLayout.CENTER);
        frame.setVisible(true);
    }
}


