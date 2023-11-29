package renderers;

import gameLogic.Timer;
import gameObjects.Block;
import enums.BlockType;
import gameObjects.Board;

import static enums.TextManipulation.*;

public class TextBoardRenderer implements BoardRenderer {
    private static final String BOARD_SEPARATOR = " --- +";

    private final Board board;
    private final Timer timer;

    public TextBoardRenderer(Board board, Timer timer) {
        this.board = board;
        this.timer = timer;
    }

    @Override
    public void draw() {
        drawBoard();
        printGameInformation();
    }

    private void printGameInformation() {
        System.out.printf("Bombs in total: %s | Flags set: %s | Bombs left: %s %n",
                underlineReformat(board.getBoardBombs()),
                underlineReformat(board.getFlagCount()),
                underlineReformat(board.getBoardBombs() - board.getFlagCount()));

        System.out.printf("Time spend yet: %s seconds %n", underlineReformat(timer.getSeconds()));
    }

    private void drawBoard() {
        printVerticalCount();

        printSeperator();
        for (int y = 0; y < board.getBoardHeight(); y++) {
            System.out.print(y+1); //Print horizontal count
            for (int x = 0; x < board.getBoardWidth(); x++) {
                System.out.print(" | ");
                printBlockContent(board.getBlockObject(x, y));
            }
            System.out.print(" |");
            printSeperator();
        }
    }

    private void printBlockContent(Block block) {
        if (!block.isBlankRevealed()) {
            if (block.hasFlag()) {
                System.out.print(GREEN_BACKGROUND.getAnsiCode() + " ~ " + RESET.getAnsiCode());
            } else {
                System.out.print(BLACK_BACKGROUND.getAnsiCode() + "   " + RESET.getAnsiCode());
            }
        } else {
            printRevealedBlockContent(block);
        }
    }

    private void printRevealedBlockContent(Block block) {
        if (block.getBlockType() == BlockType.BOMB) {
            System.out.print(block.getColor() + " # " + RESET.getAnsiCode());
        } else {
            if (block.getSurroundingBombs() == 0) {
                System.out.print("   ");
            } else {
                System.out.print(" " + printWithAppropriateNumber(block) + " ");
            }
        }
    }

    private void printSeperator() {
        System.out.println();
        System.out.print("--+");
        for(int width = 0; width < board.getBoardWidth(); width++) {

            System.out.print(BOARD_SEPARATOR);
        }
        System.out.println();
    }

    private void printVerticalCount(){
        StringBuilder verticalCount = new StringBuilder("  |");
        for(int width = 0; width < board.getBoardWidth(); width++) {
            verticalCount.append("  ").append(width+1).append("  |");
        }
        System.out.print(verticalCount);
    }

    private String underlineReformat(Object input) {
        return UNDERLINED.getAnsiCode() + input.toString() + RESET.getAnsiCode();
    }

    private String printWithAppropriateNumber(Block block) {
        return block.getColor() + block.getSurroundingBombs() + RESET.getAnsiCode();
    }
}
