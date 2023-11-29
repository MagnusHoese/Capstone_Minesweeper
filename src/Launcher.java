import gameLogic.GameController;
import gameLogic.Timer;
import gameObjects.Board;
import input.ConsoleInput;
import renderers.BoardRenderer;
import renderers.TextBoardRenderer;

public class Launcher {

    private static int boardWidth = 8;
    private static int boardHeight = 8;
    private static int boardBombs = 10;

    public static void main(String[] args) {

        Board board = new Board(boardWidth, boardHeight, boardBombs);

        ConsoleInput input = new ConsoleInput();
        Timer timer = new Timer();
        BoardRenderer renderer = new TextBoardRenderer(board, timer);
        new GameController(board, renderer, input, timer);
    }
}


/*
        Is my state a design pattern. Could you argue that its also a observer pattern?
        Should i make mvc?


        - On this line:
        "gameLogic.Blank current = (gameLogic.Blank)blockArray[i];
         System.out.print(" "+ current.getSurroundingBombs() + " ");"
         Do i have to do this, or is there a better practice way to call a subclass function
         from the superclass?


 */