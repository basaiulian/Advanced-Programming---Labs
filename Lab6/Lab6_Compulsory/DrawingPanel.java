package com.company.lab6.compulsory;

import java.lang.Math;

import com.company.lab6.compulsory.MainFrame;
import com.company.lab6.compulsory.RegularPolygon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.darkGray); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }

    //...NEXT SLIDE
    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //createOffscreenImage();
                drawShape(e.getX(), e.getY());
                repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }

    private void drawShape(int x, int y) {
        //(DONE) TODO; generate a random number
        int randomRadius,randomR,randomG,randomB;
        randomRadius = new Random().nextInt(100);
        int radius = randomRadius;
        //(DONE) TODO; get the value from UI (in ConfigPanel)
        int sides = (int) frame.configPanel.sidesField.getValue();

        //aici am luat culoarea setata in colorField-ul din ConfigPanel si ii setez valoarea
        //la final este cazul default, random unde ii setez valorile pt R G B si ultima valoare e pentru transparenta
        String color = (String) frame.configPanel.colorField.getValue();
        Color shapeColor;
        switch(color){
            case "White":
                shapeColor = Color.WHITE;
                break;
            case "Black":
                shapeColor = Color.BLACK;
                break;
            case "Red":
                shapeColor = Color.RED;
                break;
            case "Green":
                shapeColor = Color.GREEN;
                break;
            case "Blue":
                shapeColor = Color.BLUE;
                break;
            case "Magenta":
                shapeColor = Color.MAGENTA;
                break;
            case "Orange":
                shapeColor = Color.ORANGE;
                break;
            case "Yellow":
                shapeColor = Color.YELLOW;
                break;
            default:

                randomR = new Random().nextInt(255);
                randomG = new Random().nextInt(255);
                randomB = new Random().nextInt(255);
                shapeColor = new Color(randomR,randomG,randomB,100);//(DONE) TODO; create a transparent random Color.
                break;
        }

        graphics.setColor(shapeColor);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }

    @Override
    public void update(Graphics g) {
    } //Why did I do that?

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}