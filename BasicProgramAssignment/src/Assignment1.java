/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mattm
 */
import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args){
        //Define variables (int, double, char)
        double miles = 0.0;
        double gallon = 0.0;
        double mpg = 0.0;
        
        Scanner input = new Scanner(System.in);
        
        //Enter the gallons
        System.out.print("Enter the miles: ");
        miles = input.nextDouble();
        
        // Enter the hours
        System.out.print("Enter the gallons: ");
        gallon = input.nextDouble();
        
        //Calculate the gallons per hour: gph
        mpg = miles / gallon;
        
        // Output results
        System.out.printf("%s %.2f %s\n", "The car used ", mpg, "miles per gallon.");
    }
}        

    
            
    
       
