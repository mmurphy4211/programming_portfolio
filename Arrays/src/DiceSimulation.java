/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mattm
 */
import java.security.SecureRandom;

public class DiceSimulation {
    public static void main(String[] args) {
        // Create SecureRandom instance
        SecureRandom random = new SecureRandom();
        
        // Array to store frequency of faces (1-10)
        int[] frequency = new int[10];

        // Simulate rolling a die 1,000,000 times
        for (int i = 0; i < 1_000_000; i++) {
            int diceRoll = random.nextInt(10) + 1; // Generate a number between 1 and 10
            frequency[diceRoll - 1]++; // Increment the corresponding face count
        }

        // Print frequency of each face
        System.out.println("Face   Frequency");
        System.out.println("====   =========");
        for (int i = 0; i < frequency.length; i++) {
            System.out.printf("%2d    %9d%n", i + 1, frequency[i]);
        }
    }
}