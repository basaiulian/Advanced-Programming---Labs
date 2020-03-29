package com.company.lab6.compulsory;

import javax.swing.*;
import java.awt.*;

public class RegularPolygonConfigPanel extends JPanel {
    private MainFrame frame;
    private JLabel label; // we’re drawing regular polygons
    private JLabel sidesLabel;
    private JLabel sizeLabel; //the size is random(radius)
    private JLabel colorLabel;
    private JLabel shapesLabel;
    private JSpinner sidesField; // number of sides
    private JSpinner sizeField;
    private JSpinner colorField;
    private JSpinner shapeField;

    public MainFrame getFrame() {
        return frame;
    }

    public JLabel getLabel() {
        return label;
    }

    public JSpinner getSidesField() {
        return sidesField;
    }

    public JSpinner getSizeField() {
        return sizeField;
    }

    public JSpinner getColorField() {
        return colorField;
    }

    public JSpinner getShapeField() {
        return shapeField;
    }

    public RegularPolygonConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public void init(){
        //setLayout(new GridLayout(1, 5));
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 10, 1));
        sidesField.setValue(5); //default number of sides
        sidesField.setToolTipText("Number between 3 and 10");
        sizeLabel = new JLabel("Size:");
        sizeField = new JSpinner(new SpinnerNumberModel(3, 3, 10, 1));
        sizeField.setValue(5);
        sizeField.setToolTipText("Number between 3 and 10");
        colorLabel = new JLabel("Color:");
        shapesLabel = new JLabel("Shape:");
        String[] shapes = new String[]{
                "Select shape", "Circles", "RegularPolygon"
        };

        SpinnerListModel shapeModel = new SpinnerListModel(shapes);
        shapeField = new JSpinner(shapeModel);

        ((JSpinner.DefaultEditor) shapeField.getEditor()).getTextField().setEditable(false);

        String[] colors = new String[]{
                "Random", "White", "Black", "Red", "Green", "Blue", "Magenta", "Orange", "Yellow"
        };
        SpinnerListModel colorModel = new SpinnerListModel(colors);
        colorField = new JSpinner(colorModel);

        ((JSpinner.DefaultEditor) colorField.getEditor()).getTextField().setEditable(false);

        Dimension dimension = colorField.getPreferredSize();
        dimension.width = dimension.width + 10;
        colorField.setPreferredSize(dimension);

        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(sizeLabel);
        add(sizeField);
        add(colorLabel);
        add(colorField);
        add(shapesLabel);
        add(shapeField);
        //add(colorCombo);

        frame.add(this);

    }



}

