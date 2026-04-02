package com.miguelindo.ui;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    private final JFrame window;

    public MainWindow() {
        window = new JFrame();
        window.setTitle("Unit Converter");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 500);
        window.setLocationRelativeTo(null);

        ConverterPanel converterPanel = new ConverterPanel();
        CategorySelector categorySelector = new CategorySelector(converterPanel);

        window.add(converterPanel, BorderLayout.CENTER);
        window.add(categorySelector, BorderLayout.SOUTH);
    }

    public void show() {
        window.setVisible(true);
    }
}
