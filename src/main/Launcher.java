/**
 * @author Magnus Høse, magjen22@aau.student.dk
 */

package main;

import main.gameLogic.GameController;
import main.gameLogic.Timer;
import main.gameObjects.Board;
import main.input.ConsoleInput;
import main.renderers.BoardRenderer;
import main.renderers.TextBoardRenderer;

public class Launcher {

    private static int boardWidth = 8;
    private static int boardHeight = 8;
    private static int boardBombs = 1;

    public static void main(String[] args) {

        Board board = new Board(boardWidth, boardHeight, boardBombs);

        ConsoleInput input = new ConsoleInput();
        Timer timer = new Timer();
        BoardRenderer renderer = new TextBoardRenderer(board, timer);
        new GameController(board, renderer, input, timer);
    }
}
