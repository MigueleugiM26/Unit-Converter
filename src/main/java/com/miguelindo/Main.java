package com.miguelindo;

import com.formdev.flatlaf.FlatDarkLaf;
import com.miguelindo.ui.MainWindow;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        UIManager.put("defaultFont", new Font("Segoe UI", Font.PLAIN, 14));
        FlatDarkLaf.setup();
        SwingUtilities.invokeLater(() -> new MainWindow().show());
    }
}