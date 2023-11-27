package input;

import java.util.Scanner;

public class ConsoleInput {

    private int xInput;
    private int yInput;
    private String statusInput;

    public void setInputString() {
        Scanner in = new Scanner(System.in);

        do {
            System.out.print("Enter input (format: x,y,status): ");
            String inputString = in.nextLine().trim();

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
                break; // Break the loop if input is valid
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


