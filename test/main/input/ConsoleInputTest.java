/**
 * @author Magnus Høse, magjen22@aau.student.dk
 */

package main.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleInputTest {

    @Test
    void validInputString() {
        // Arrange
        String mockScanner = "1,2,flag";

        MockConsoleInput consoleInput = new MockConsoleInput(mockScanner);

        // Act
        String[] result = consoleInput.getInputString();

        // Assert
        assertArrayEquals(new String[]{"1", "2", "flag"}, result, "Valid input string not processed correctly");
    }

    @Test
    void invalidEmptyInputString() {
        // Arrange
        String mockScanner = "";

        MockConsoleInput consoleInput = new MockConsoleInput(mockScanner);


        // Act and assert
        assertThrows(IllegalArgumentException.class, consoleInput::getInputString, "Empty input string should throw an exception");
    }

    @Test
    void invalidIncorrectFormat() {
        // Arrange
        String mockScanner = "1,2,flag,extra";

        MockConsoleInput consoleInput = new MockConsoleInput(mockScanner);

        // Act and assert
        assertThrows(IllegalArgumentException.class, consoleInput::getInputString);


    }

    // Mock class for testing

    private static class MockConsoleInput extends ConsoleInput{

        private final String mockScanner;
        public MockConsoleInput(String mockScanner) {
            this.mockScanner = mockScanner;
        }

        public String[] getInputString() {

            do {
                System.out.print("Enter input (format: x,y,status(r=reveal/f=flag): ");
                String inputString = mockScanner.trim(); // Only change from the original


                validateInput(inputString);

                String[] formatted = inputString.split(",");

                int xInput = Integer.parseInt(formatted[0]);
                int yInput = Integer.parseInt(formatted[1]);
                String statusInput = formatted[2];
                return formatted; // Break the loop and return array if input is valid



            } while (true);
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


}
