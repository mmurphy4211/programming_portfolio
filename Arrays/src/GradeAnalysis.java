/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mattm
 */
import java.util.Scanner;

public class GradeAnalysis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] grades = new int[10];
        int count = 0;
        int sum = 0;

        // Read up to 10 grades, stop when a negative number is entered
        System.out.println("Enter grades (up to 10). Enter a negative number to stop:");
        while (count < 10) {
            int grade = input.nextInt();
            if (grade < 0) break; // Sentinel value to stop input
            grades[count] = grade;
            sum += grade;
            count++;
        }

        if (count == 0) {
            System.out.println("No grades entered.");
            return;
        }

        // Calculate average
        double average = (double) sum / count;
        int aboveOrEqual = 0;
        int below = 0;

        // Determine how many grades are above or below the average
        for (int i = 0; i < count; i++) {
            if (grades[i] >= average) {
                aboveOrEqual++;
            } else {
                below++;
            }
        }

        // Print the grades
        System.out.println("Grades entered:");
        for (int i = 0; i < count; i++) {
            System.out.print(grades[i] + " ");
        }

        // Print the result
        System.out.printf("%nAverage grade: %.2f%n", average);
        System.out.println(aboveOrEqual + " grades are above or equal to the average.");
        System.out.println(below + " grades are below the average.");
    }
}