package main.input;

import java.util.Scanner;

public class ConsoleInput {

    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner =  new Scanner(System.in);
    }


    public String[] getInputString() {

        do {
            System.out.print("Enter main.input (format: x,y,status(r=reveal/f=flag): ");
            String inputString = scanner.nextLine().trim();

            if (inputString.isEmpty()) {
                System.out.println("Input cannot be empty. Try Again!");
                continue;
            }

            String[] formatted = inputString.split(",");

            if (formatted.length != 3) {
                System.out.println("Invalid main.input format. Try Again!");
                continue;
            }

            try {
                int xInput = Integer.parseInt(formatted[0]);
                int yInput = Integer.parseInt(formatted[1]);
                String statusInput = formatted[2];
                return formatted; // Break the loop and return array if main.input is valid

            } catch (NumberFormatException e) {
                System.out.println("Invalid numeric main.input. Try Again!");
            }

        } while (true);
    }
}


