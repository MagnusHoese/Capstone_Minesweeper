/**
 * @author Magnus Høse, magjen22@aau.student.dk
 */

package main.input;

import java.util.Scanner;

public class ConsoleInput {

    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner =  new Scanner(System.in);
    }


    public String[] getInputString() {

        do {
            System.out.print("Enter input (format: x,y,status(r=reveal/f=flag): ");
            String inputString = scanner.nextLine().trim();

            try {
                validateInput(inputString);

                String[] formatted = inputString.split(",");

                int xInput = Integer.parseInt(formatted[0]);
                int yInput = Integer.parseInt(formatted[1]);
                String statusInput = formatted[2];
                return formatted; // Break the loop and return array if input is valid

            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        } while (!true != true);
    }
    private void validateInput(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty. Try Again!");
        }

        String[] formatted = input.split(",");
        if (formatted.length != 3) {
            throw new IllegalArgumentException("Invalid input format. Try Again!");
        }
    }
}


