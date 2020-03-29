package com.company.lab6.compulsory;

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

    void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.darkGray);
        graphics.fillRect(0, 0, W, H);
    }

    void createOffscreenImage(BufferedImage image) {
        graphics = image.createGraphics();
        this.image = image;
    }

    //...NEXT SLIDE
    void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //createOffscreenImage();
                drawRegularPolygon(e.getX(), e.getY());
                //drawCircle(e.getX(),e.getY());  //functioneaza cu circleConfigPanel
                repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }

    private void drawRegularPolygon(int x, int y) {
        int randomRadius, randomR, randomG, randomB;
        randomRadius = new Random().nextInt(100);
        int radius = randomRadius;
        int sides = (int) frame.regularPolygonConfigPanel.getSidesField().getValue();

        String color = (String) frame.regularPolygonConfigPanel.getColorField().getValue();
        Color shapeColor;
        switch (color) {
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
                shapeColor = new Color(randomR, randomG, randomB, 100);//(DONE) TODO; create a transparent random Color.
                break;
        }
        graphics.setColor(shapeColor);
        graphics.fill(new RegularPolygon(x, y, radius, sides));

    }

    private void drawCircle(int x, int y) {
        int randomR,randomG,randomB;
        int radius = (int)frame.circleConfigPanel.getRadiusField().getValue();

        String color = (String) frame.circleConfigPanel.getColorField().getValue();
        Color shapeColor;
        switch (color){
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
                shapeColor = new Color(randomR, randomG, randomB, 100);//(DONE) TODO; create a transparent random Color.
                break;
        }
        graphics.setColor(shapeColor);
        graphics.fillOval(x,y,radius,radius);
    }

    @Override
    public void update(Graphics graphics) {
        createOffscreenImage();
    } //Why did I do that?

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(image, 0, 0, this);
    }
}