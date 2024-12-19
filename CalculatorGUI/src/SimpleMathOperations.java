/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mattm
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleMathOperations {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Math Operations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);

        // Components
        JLabel firstNumberLabel = new JLabel("First Number:");
        JTextField firstNumberInput = new JTextField(5);
        JLabel secondNumberLabel = new JLabel("Second Number:");
        JTextField secondNumberInput = new JTextField(5);
        
        JRadioButton addButton = new JRadioButton("Add");
        JRadioButton subtractButton = new JRadioButton("Subtract");
        JRadioButton multiplyButton = new JRadioButton("Multiply");
        JRadioButton divideButton = new JRadioButton("Divide");

        ButtonGroup group = new ButtonGroup();
        group.add(addButton);
        group.add(subtractButton);
        group.add(multiplyButton);
        group.add(divideButton);

        JButton calculateButton = new JButton("Calculate");
        JTextField resultOutput = new JTextField(10);
        resultOutput.setEditable(false);

        // Panel setup
        JPanel panel = new JPanel();
        panel.add(firstNumberLabel);
        panel.add(firstNumberInput);
        panel.add(secondNumberLabel);
        panel.add(secondNumberInput);
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(calculateButton);
        panel.add(resultOutput);

        frame.add(panel);

        // Action listener for calculation
        calculateButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(firstNumberInput.getText());
                int num2 = Integer.parseInt(secondNumberInput.getText());
                int result = 0;

                if (addButton.isSelected()) {
                    result = num1 + num2;
                } else if (subtractButton.isSelected()) {
                    result = num1 - num2;
                } else if (multiplyButton.isSelected()) {
                    result = num1 * num2;
                } else if (divideButton.isSelected()) {
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(frame, "Cannot divide by zero!");
                        return;
                    }
                    result = num1 / num2;
                }
                resultOutput.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input! Please enter integers.");
            }
        });

        frame.setVisible(true);
    }
}

