package input;


import java.util.Scanner;

public class ConsoleInput {


    public int getInputString() {
        int inputString;

        Scanner in = new Scanner(System.in);

        inputString = in.nextInt();

        return inputString;
    }
}

