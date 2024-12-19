/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mattm
 */
// ElevatorTest.java
public class ElevatorTest {
    public static void main(String[] args) {
        // Create an instance of the Elevator class
        Elevator elevator = new Elevator();

        // Display the starting floor
        elevator.displayCurrentFloor(); // Should be on the first floor

        // Go to the second floor
        elevator.goUp();
        elevator.displayCurrentFloor(); // Should be on the second floor

        // Go to the third floor
        elevator.goUp();
        elevator.displayCurrentFloor(); // Should be on the third floor

        // Attempt to go to the fourth floor
        elevator.goUp(); // Should notify that it's already on the top floor

        // Go back to the second floor
        elevator.goDown();
        elevator.displayCurrentFloor(); // Should be on the second floor

        // Go back to the first floor
        elevator.goDown();
        elevator.displayCurrentFloor(); // Should be on the first floor
    }
}
