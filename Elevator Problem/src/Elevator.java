/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mattm
 */

public class Elevator {
    // Instance variable to track the current floor
    private int currentFloor;

    // Constructor to initialize the elevator on the first floor
    public Elevator() {
        currentFloor = 1;
    }

    // Method to go up by one floor
    public void goUp() {
        if (currentFloor < 3) {
            currentFloor++;
            System.out.println("Elevator moved up to floor " + currentFloor);
        } else {
            System.out.println("You are already on the top floor.");
        }
    }

    // Method to go down by one floor
    public void goDown() {
        if (currentFloor > 1) {
            currentFloor--;
            System.out.println("Elevator moved down to floor " + currentFloor);
        } else {
            System.out.println("You are already on the ground floor.");
        }
    }

    // Method to display the current floor
    public void displayCurrentFloor() {
        System.out.println("The elevator is currently on floor " + currentFloor);
    }
}

