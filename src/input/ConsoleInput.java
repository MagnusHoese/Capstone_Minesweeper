package input;

import java.util.Scanner;

public class ConsoleInput {

    private int xInput;
    private int yInput;
    private String statusInput;

    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner =  new Scanner(System.in);
    }


    public String[] getInputString() {

        do {
            System.out.print("Enter input (format: x,y,status): ");
            String inputString = scanner.nextLine().trim();

            if (inputString.isEmpty()) {
                System.out.println("Input cannot be empty. Try Again!");
                continue;
            }

            String[] formatted = inputString.split(",");

            if (formatted.length != 3) {
                System.out.println("Invalid input format. Try Again!");
                continue;
            }

            try {
                xInput = Integer.parseInt(formatted[0]);
                yInput = Integer.parseInt(formatted[1]);
                statusInput = formatted[2];
                return formatted; // Break the loop and return array if input is valid

            } catch (NumberFormatException e) {
                System.out.println("Invalid numeric input. Try Again!");
            }

        } while (true);
    }

    public int getXInput() {
        return xInput;
    }

    public int getYInput() {
        return yInput;
    }

    public String getStatusInput() {
        return statusInput;
    }
}


