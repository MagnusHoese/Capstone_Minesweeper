package main.gameObjects;

import main.enums.BlockType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void generateBoard_createsBoardWithCorrectDimensionsAndBombs() {
        int width = 8;
        int height = 8;
        int bombs = 10;

        Board board = new Board(width, height, bombs);

        assertEquals(width, board.getBoardWidth());
        assertEquals(height, board.getBoardHeight());
        assertEquals(bombs, board.getBoardBombs());

    }

    @Test
    void generateBoard_boardWontCreateBoardWithMoreBombsThanCells() {
        int width = 8;
        int height = 8;
        int size = width * height;
        int bombs = size + 1;

        Board board = new Board(width, height, bombs);

        assertNotEquals(bombs, board.getBoardBombs());

    }
    @Test
    void placeBombs_distributesBombsCorrectly() {
        // Arrange
        int width = 8;
        int height = 8;
        int bombs = 10;

        // Act
        Board board = new Board(width, height, bombs); // The placeBombs are called in the constructor


        // Assert
        assertEquals(bombs, countPlacedBombs(board), "Incorrect number of bombs placed"); //

        // Check that bombs are placed in valid positions
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (board.getBombStatus(x, y)) {
                    assertTrue(board.isWithinBounds(x, y), "Bomb placed out of bounds");
                }
            }
        }
    }

    private int countPlacedBombs(Board board) {
        int bombCount = 0;
        for (int y = 0; y < board.getBoardWidth(); y++) {
            for (int x = 0; x < board.getBoardWidth(); x++) {
                if (board.getBlockObject(x,y).isBomb()) {
                    bombCount++;
                }
            }
        }
        return bombCount;
    }

    @Test
    void setSurroundingBombs_calculatesCorrectly() {
        // Arrange
        int width = 3;
        int height = 3;
        int bombs = 1;

        Board board = new Board(width, height, bombs);

        //To test the board get overwritten
        overwriteBoard(width, height, board);

        // Manually place a bomb in the center (1, 1)
        board.getBlockObject(1, 1).setIsRevealed(true); // Simulate a revealed bomb

        // Act
        board.setSurroundingBombs();

        // Assert
        // Verify that the surrounding bombs are calculated correctly for each blank space
        assertEquals(1, board.getBlockObject(0, 0).getSurroundingBombs(), "Incorrect surrounding bombs for (0, 0)");
        assertEquals(1, board.getBlockObject(0, 1).getSurroundingBombs(), "Incorrect surrounding bombs for (0, 1)");
        assertEquals(1, board.getBlockObject(0, 2).getSurroundingBombs(), "Incorrect surrounding bombs for (0, 2)");
        assertEquals(1, board.getBlockObject(1, 0).getSurroundingBombs(), "Incorrect surrounding bombs for (1, 0)");
        assertEquals(0, board.getBlockObject(1, 1).getSurroundingBombs(), "Incorrect surrounding bombs for (1, 1)"); // Center, where the bomb is
        assertEquals(1, board.getBlockObject(1, 2).getSurroundingBombs(), "Incorrect surrounding bombs for (1, 2)");
        assertEquals(1, board.getBlockObject(2, 0).getSurroundingBombs(), "Incorrect surrounding bombs for (2, 0)");
        assertEquals(1, board.getBlockObject(2, 1).getSurroundingBombs(), "Incorrect surrounding bombs for (2, 1)");
        assertEquals(1, board.getBlockObject(2, 2).getSurroundingBombs(), "Incorrect surrounding bombs for (2, 2)");
    }

    private void overwriteBoard(int width, int height, Board board) {
        for (int x = 0; x < width; x++) {
            List<Block> row = new ArrayList<>();
            for (int y = 0; y < height; y++) {
                row.add(new Blank(board, x, y));
            }
            board.getBlockList().set(x, row);
        }
        board.getBlockList().get(1).set(1, new Bomb(board, 1,1));
    }
}