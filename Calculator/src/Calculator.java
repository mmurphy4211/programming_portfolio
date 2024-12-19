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

public class Calculator extends JFrame {
    private JTextField display;
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public Calculator() {
        // Set up the JFrame
        setTitle("Simple Calculator");
        setSize(350, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display field
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        // Create button panel using GridBagLayout
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Define button labels according to the new layout
        String[] buttons = {
            "1", "2", "3", "4",
            "5", "6", "7", "8",
            "9", "0", "+", "-",
            "/", "*", "+/-", "."
        };

        int row = 0, col = 0;

        // Add number and operation buttons
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(new ButtonClickListener());
            
            gbc.gridx = col;
            gbc.gridy = row;
            panel.add(button, gbc);
            
            col++;
            if (col > 3) {
                col = 0;
                row++;
            }
        }

        // Add Clear (C) button that spans two columns
        JButton clearButton = new JButton("C");
        clearButton.setFont(new Font("Arial", Font.PLAIN, 18));
        clearButton.addActionListener(new ButtonClickListener());
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 2; // Span two columns
        panel.add(clearButton, gbc);

        // Add Equals (=) button that spans two columns
        JButton equalsButton = new JButton("=");
        equalsButton.setFont(new Font("Arial", Font.PLAIN, 18));
        equalsButton.addActionListener(new ButtonClickListener());
        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.gridwidth = 2; // Span two columns
        panel.add(equalsButton, gbc);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    // Action listener for the buttons
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "C": // Clear button
                    display.setText("");
                    firstNumber = 0;
                    secondNumber = 0;
                    operator = "";
                    startNewNumber = true;
                    break;
                case "+/-": // Toggle sign
                    if (!display.getText().isEmpty()) {
                        double currentNumber = Double.parseDouble(display.getText());
                        currentNumber = -currentNumber;
                        display.setText(String.valueOf(currentNumber));
                    }
                    break;
                case "+": case "-": case "*": case "/": // Arithmetic operations
                    firstNumber = Double.parseDouble(display.getText());
                    operator = command;
                    display.setText("");
                    break;
                case "=": // Calculate result
                    if (!operator.isEmpty()) {
                        secondNumber = Double.parseDouble(display.getText());
                        double result = 0;
                        switch (operator) {
                            case "+": result = firstNumber + secondNumber; break;
                            case "-": result = firstNumber - secondNumber; break;
                            case "*": result = firstNumber * secondNumber; break;
                            case "/":
                                if (secondNumber != 0) {
                                    result = firstNumber / secondNumber;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Cannot divide by zero!");
                                    return;
                                }
                                break;
                        }
                        display.setText(String.valueOf(result));
                        startNewNumber = true;
                    }
                    break;
                default: // Number and decimal point buttons
                    if (startNewNumber) {
                        display.setText("");
                        startNewNumber = false;
                    }
                    display.setText(display.getText() + command);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator());
    }
}

