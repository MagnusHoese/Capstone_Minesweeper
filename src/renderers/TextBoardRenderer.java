package renderers;

import gameObjects.Block;
import gameObjects.Board;

public class TextBoardRenderer implements BoardRenderer {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String BLACK_BACKGROUND = "\u001B[40m";
    private static final String GREEN_BACKGROUND = "\u001B[42m";
    private static final String RED_BACKGROUND = "\u001B[41m";
    private static final String BOARD_SEPARATOR = " --- +";

    private Board board;

    public TextBoardRenderer(Board board) {
        this.board = board;
    }

    @Override
    public void draw() {
        drawBoard();
        printGameInformation();
    }

    private void printGameInformation() {
        System.out.printf("Bombs in total: %d | Flags set: %d | Bombs left: %d %n",
                board.getBoardBombs(), board.getFlagCount(), board.getBoardBombs() - board.getFlagCount());
    }

    private void drawBoard() {
        printSeperator();
        for (int y = 0; y < board.getBoardHeight(); y++) {
            for (int x = 0; x < board.getBoardWidth(); x++) {
                System.out.print(" | ");
                printBlockContent(board.getBlockObject(x, y));
            }
            System.out.print(" |");
            printSeperator();
        }
    }

    private void printBlockContent(Block block) {
        if (!block.isBlankRevealed() || block.isBomb()) {
            if (block.hasFlag()) {
                System.out.print(RED_BACKGROUND + " ~ " + ANSI_RESET);
            } else if (block.isBomb()) {
                System.out.print(BLACK_BACKGROUND + " # " + ANSI_RESET);
            } else {
                System.out.print(BLACK_BACKGROUND + " # " + ANSI_RESET);
            }
        } else {
            printRevealedBlockContent(block);
        }
    }

    private void printRevealedBlockContent(Block block) {
        if (block.getSurroundingBombs() == 0) {
            System.out.print("   ");
        } else {
            System.out.print(" " + block.getSurroundingBombs() + " ");
        }
    }

    private void printSeperator() {
        System.out.println();
        System.out.print(" +");
        for(int width = 0; width < board.getBoardWidth(); width++) {
            System.out.print(BOARD_SEPARATOR);
        }
        System.out.println();
    }
}
