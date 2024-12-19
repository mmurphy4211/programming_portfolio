/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // Components
        JLabel celsiusLabel = new JLabel("Celsius:");
        JTextField celsiusInput = new JTextField(10);
        JButton convertButton = new JButton("Calculate");
        JButton clearButton = new JButton("Clear");
        JLabel fahrenheitLabel = new JLabel("Fahrenheit:");
        JTextField fahrenheitOutput = new JTextField(10);
        fahrenheitOutput.setEditable(false);

        // Panel setup
        JPanel panel = new JPanel();
        panel.add(celsiusLabel);
        panel.add(celsiusInput);
        panel.add(convertButton);
        panel.add(clearButton);
        panel.add(fahrenheitLabel);
        panel.add(fahrenheitOutput);

        frame.add(panel);

        // Action listener for conversion
        convertButton.addActionListener(e -> {
            try {
                double celsius = Double.parseDouble(celsiusInput.getText());
                double fahrenheit = (celsius * 9 / 5) + 32;
                fahrenheitOutput.setText(String.format("%.2f", fahrenheit));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input! Please enter a valid number.");
            }
        });

        // Action listener for clearing inputs
        clearButton.addActionListener(e -> {
            celsiusInput.setText("");
            fahrenheitOutput.setText("");
        });

        frame.setVisible(true);
    }
}
