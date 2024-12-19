/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mattm
 */
import java.util.Scanner;

public class ProgramLessonDemo {
    public static void main(String[] args)
    {
        //Define variables (int, double, char)
        double gallons = 0.0;
        double hours = 0.0;
        double gph = 0.0;
        
        Scanner input = new Scanner(System.in);
        
        //Enter the gallons
        System.out.print("Enter the gallons: ");
        gallons = input.nextDouble();
        
        // Enter the hours
        System.out.print("Enter the hours: ");
        hours = input.nextDouble();
        
        //Calculate the gallons per hour: gph
        gph = gallons / hours;
        
        // Output results
        System.out.printf("%s %.2f %s\n", "The boat used ", gph, "gallons per hour.");
    }
}        
