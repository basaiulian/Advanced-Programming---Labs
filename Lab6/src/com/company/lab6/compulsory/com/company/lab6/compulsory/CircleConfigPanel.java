package com.company.lab6.compulsory;

import javax.swing.*;
import java.awt.*;

public class CircleConfigPanel extends JPanel {
    private MainFrame frame;
    private JLabel label;
    private JSpinner radiusField;
    private JSpinner colorField;
    private JSpinner shapeField;
    private JLabel radiusLabel;
    private JLabel colorLabel;
    private JLabel shapeLabel;

    public CircleConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public JSpinner getRadiusField() {
        return radiusField;
    }

    public JSpinner getColorField() {
        return colorField;
    }

    public JSpinner getShapeField() {
        return shapeField;
    }

    public void init(){
        radiusLabel = new JLabel("Radius:");
        colorLabel = new JLabel("Color:");
        shapeLabel = new JLabel("Shape:");

        radiusField = new JSpinner(new SpinnerNumberModel(15, 15, 120, 1));
        radiusField.setValue(40);
        radiusField.setToolTipText("Number between 15 and 100");

        String[] colors = new String[]{
                "Random", "White", "Black", "Red", "Green", "Blue", "Magenta", "Orange", "Yellow"
        };
        SpinnerListModel colorModel = new SpinnerListModel(colors);
        colorField = new JSpinner(colorModel);

        ((JSpinner.DefaultEditor) colorField.getEditor()).getTextField().setEditable(false);

        Dimension dimension = colorField.getPreferredSize();
        dimension.width = dimension.width + 10;
        colorField.setPreferredSize(dimension);

        String[] shapes = new String[]{
                "Circles", "RegularPolygon"
        };

        SpinnerListModel shapeModel = new SpinnerListModel(shapes);
        shapeField = new JSpinner(shapeModel);

        ((JSpinner.DefaultEditor) shapeField.getEditor()).getTextField().setEditable(false);

        dimension.width = dimension.width + 30;
        shapeField.setPreferredSize(dimension);

        add(radiusLabel);
        add(radiusField);
        add(colorLabel);
        add(colorField);
        add(shapeLabel);
        add(shapeField);

        frame.add(this);



    }

}
