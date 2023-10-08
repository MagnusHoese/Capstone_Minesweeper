import java.util.Scanner;

public class Input {
    private String inputString;

    public String getInputString() {
        Scanner in = new Scanner(System.in);

        inputString = in.nextLine();

        return inputString;
    }
}
