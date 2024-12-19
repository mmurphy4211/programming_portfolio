/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mattm
 */
import java.util.Scanner;

public class CalculateAge {

    // Method to calculate age
    public static int CalculateAge(int birthDate, int todayDate) {
        int age = (todayDate - birthDate) / 10000;
        return age;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input birth date (YYYYMMDD)
        System.out.print("Enter birth year: ");
        int birthYear = scanner.nextInt();
        System.out.print("Enter birth month: ");
        int birthMonth = scanner.nextInt();
        System.out.print("Enter birth day: ");
        int birthDay = scanner.nextInt();
        int birthDate = birthYear * 10000 + birthMonth * 100 + birthDay;

        // Input today's date (YYYYMMDD)
        System.out.print("Enter current year: ");
        int currentYear = scanner.nextInt();
        System.out.print("Enter current month: ");
        int currentMonth = scanner.nextInt();
        System.out.print("Enter current day: ");
        int currentDay = scanner.nextInt();
        int todayDate = currentYear * 10000 + currentMonth * 100 + currentDay;

        // Call CalculateAge method and display the result
        int age = CalculateAge(birthDate, todayDate);
        System.out.println("You are " + age + " years old.");

        scanner.close();
    }
}
