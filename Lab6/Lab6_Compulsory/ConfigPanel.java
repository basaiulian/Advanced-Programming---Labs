package com.company.lab6.compulsory;

import javax.swing.*;
import javax.swing.colorchooser.ColorSelectionModel;
import java.awt.*;
import java.util.Collections;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JSpinner sizeField;
    JSpinner colorField;
    JComboBox colorCombo; // the color of the shape

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the labels and the spinners
        JLabel sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 10, 1));
        sidesField.setValue(5); //default number of sides
        sidesField.setToolTipText("Number between 3 and 10");//cand pui sageata pe Field sa ti apara un popup cu textul
        JLabel sizeLabel = new JLabel("Size:");
        sizeField = new JSpinner(new SpinnerNumberModel(3, 3, 10, 1));
        sizeField.setValue(5);
        sizeField.setToolTipText("Number between 3 and 10");
        JLabel colorLabel = new JLabel("Color:");

        // (*) mai jos fac un model custom pt spinner, sa putem adauga nume de culori
        // (**) am setat sa nu poata fi editate valorile ( daca de ex in Spinner aveam "Blue", puteam sterge sa scriu orice altceva
        // (***) am marit putin latimea spinnerului pt ca erau culori gen Yellow, Orange care nu incapeau bine in Spinner

        //(*)
        String[] colors = new String[]{
                "Random", "White", "Black", "Red", "Green", "Blue", "Magenta", "Orange", "Yellow"
        };
        SpinnerListModel model = new SpinnerListModel(colors);
        colorField = new JSpinner(model);

        //(**)
        ((JSpinner.DefaultEditor) colorField.getEditor()).getTextField().setEditable(false);

        //(***)
        Dimension dimension = colorField.getPreferredSize();
        dimension.width = dimension.width + 10;
        colorField.setPreferredSize(dimension);

        //aici vad abia acum, dupa ce am facut eu culorile, ca vrea colorCombo gen cu casute, ca la paint. o sa vedem poate nu e greu de facut...
        //create the colorCombo, containing the values: Random and Black
        //TODO
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(sizeLabel);
        add(sizeField);
        add(colorLabel);
        add(colorField);
        //add(colorCombo);
    }
}
