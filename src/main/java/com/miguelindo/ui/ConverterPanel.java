package com.miguelindo.ui;

import com.miguelindo.model.ConversionResult;
import com.miguelindo.unit.ConvertibleUnit;
import com.miguelindo.unit.LengthUnit;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class ConverterPanel extends JPanel {
    private final JTextField userInput;
    private final JTextPane result;
    private final JComboBox<ConvertibleUnit> from;
    private final JComboBox<ConvertibleUnit> to;
    private final JLabel resultLongText;

    // Helper
    private void handleConversion() {
        try {
            double input = Double.parseDouble(userInput.getText());
            ConvertibleUnit fromUnit = (ConvertibleUnit) from.getSelectedItem();
            ConvertibleUnit toUnit = (ConvertibleUnit) to.getSelectedItem();

            assert fromUnit != null;
            double valueResult = fromUnit.convert(input, toUnit);
            ConversionResult conversionResult = new ConversionResult(input, valueResult, fromUnit, toUnit);

            result.setText(String.valueOf(valueResult));
            resultLongText.setText(conversionResult.getResultString());
        } catch(NumberFormatException err) {
            resultLongText.setText("Invalid input.");
        }
    }

    public void loadCategory(ConvertibleUnit[] units) {
        from.setModel(new DefaultComboBoxModel<>(units));
        to.setModel(new DefaultComboBoxModel<>(units));
        userInput.setText("");
        result.setText("");
        resultLongText.setText("");
    }

    // Main panel
    public ConverterPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        // Linha 1
        JPanel row1 = new JPanel(new GridLayout(1, 2, 20, 0));
        row1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        userInput = new JTextField();
        result = new JTextPane();
        result.setEditable(false);
        result.setFocusable(false);

        row1.add(userInput);
        row1.add(result);

        // Linha 2
        JPanel row2 = new JPanel(new GridLayout(1, 2, 20, 0));
        row2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        from = new JComboBox<>(LengthUnit.values());
        to = new JComboBox<>(LengthUnit.values());

        row2.add(from);
        row2.add(to);

        // Linha 3
        JPanel row3 = new JPanel(new GridLayout(1, 1, 0, 0));
        row3.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        resultLongText = new JLabel("", SwingConstants.CENTER);
        resultLongText  .setAlignmentX(Component.CENTER_ALIGNMENT);
        resultLongText  .setAlignmentY(Component.CENTER_ALIGNMENT);

        row3.add(resultLongText);

        // Coluna Principal
        JPanel mainColumn = new JPanel();
        mainColumn.setLayout(new BoxLayout(mainColumn, BoxLayout.Y_AXIS));

        mainColumn.add(row1);
        mainColumn.add(Box.createVerticalStrut(20));
        mainColumn.add(row2);
        mainColumn.add(Box.createVerticalStrut(20));
        mainColumn.add(row3);

        // Eventos
        userInput.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { update(); }
            public void removeUpdate(DocumentEvent e) { update(); }
            public void insertUpdate(DocumentEvent e) { update(); }

            public void update() {
                handleConversion();
            }
        });

        from.addItemListener(_ -> handleConversion());

        to.addItemListener(_ -> handleConversion());

        add(mainColumn, BorderLayout.NORTH);
    }
}