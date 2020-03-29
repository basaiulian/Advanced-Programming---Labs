package com.company.lab6.compulsory;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        resetBtn.addActionListener(this::reset);
        loadBtn.addActionListener(this::loadImage);
        exitBtn.addActionListener(this::exit);
    }

    private void save(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png"));

        // Open the save dialog
        int status = fileChooser.showSaveDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(frame.canvas.image, "PNG", new File(fileChooser.getSelectedFile().getAbsolutePath()));
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    private void reset(ActionEvent e) {
        this.frame.canvas.setVisible(false);
        this.frame.canvas.createOffscreenImage();
        this.frame.canvas.setVisible(true);
    }

    private void loadImage(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "png"));

        // Open the save dialog
        int status = fileChooser.showSaveDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            System.out.println(fileChooser.getSelectedFile().getAbsolutePath());

            BufferedImage bufferedImage = null;
            try {
                bufferedImage = ImageIO.read(new File(fileChooser.getSelectedFile().getAbsolutePath()));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

            reset(e);

            assert bufferedImage != null;

            this.frame.canvas.createOffscreenImage(bufferedImage);
            this.frame.canvas.repaint();
        }
    }

    private void exit(ActionEvent e) {
        if (JOptionPane.showConfirmDialog(null ,"Confirm if you Want to Exit","Warning", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            System.exit(0);
    }
}