package main.enums;

public enum BlockColors {

    BLACK0("\u001B[30;"),
    BLUE1("\u001B[34m"),
    GREEN2("\u001B[32m"),
    RED3("\u001B[31m"),
    DARKBLUE4("\u001B[34;1m"),
    BORDEAUX5("\u001B[31;1m"),
    CYAN6("\u001B[36m"),
    DARKBLACK7("\u001B[30;1m"),
    GRAY8("\u001B[37m");


    private final String color;
    BlockColors(String color) {
        this.color = color;
    }

    private String getColor() {
        return color;
    }

    public static String getColorByIndex(int index) {

        if (index >= 0 && index < values().length) {
            return values()[index].getColor();
        } else {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
    }
}
