/**
 * @author Magnus Høse, magjen22@aau.student.dk
 */

package main.enums;

public enum TextManipulation {
    RESET("\u001B[0m"),
    BLACK_BACKGROUND("\u001B[40m"),
    GREEN_BACKGROUND("\u001B[42m"),
    RED_BACKGROUND("\u001B[41m"),
    UNDERLINED("\033[4m");

    private final String ansiCode;
    TextManipulation(String ansiCode) {
        this.ansiCode = ansiCode;
    }


    public String getAnsiCode() {
        return ansiCode;
    }
}
