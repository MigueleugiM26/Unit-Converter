package com.miguelindo.ui;

import com.miguelindo.unit.LengthUnit;
import com.miguelindo.unit.TemperatureUnit;
import com.miguelindo.unit.WeightUnit;

import javax.swing.*;
import java.awt.*;

public class CategorySelector extends JPanel {

    public CategorySelector(ConverterPanel converterPanel) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        JPanel row1 = new JPanel(new GridLayout(1, 3, 20, 0));
        row1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        JButton lengthButton = new JButton("Length");
        JButton temperatureButton = new JButton("Temperature");
        JButton weightButton = new JButton("Weight");

        row1.add(lengthButton);
        row1.add(temperatureButton);
        row1.add(weightButton);

        // Events
        lengthButton.addActionListener(_ -> converterPanel.loadCategory(LengthUnit.values()));
        temperatureButton.addActionListener(_ -> converterPanel.loadCategory(TemperatureUnit.values()));
        weightButton.addActionListener(_ -> converterPanel.loadCategory(WeightUnit.values()));

        add(row1, BorderLayout.NORTH);
    }
}
