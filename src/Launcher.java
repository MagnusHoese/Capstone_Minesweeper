import gameLogic.GameController;
import gameLogic.Timer;
import gameObjects.Board;
import input.ConsoleInput;
import renderers.TextBoardRenderer;

import java.util.TimerTask;

public class Launcher {

    private static int boardWidth = 8;
    private static int boardHeight = 8;
    private static int boardBombs = 10;

    public static void main(String[] args) {

        Board board = new Board(boardWidth, boardHeight, boardBombs);

        ConsoleInput input = new ConsoleInput();
        Timer timer = new Timer();
        TextBoardRenderer renderer = new TextBoardRenderer(board, timer);
        GameController gameController = new GameController(board, renderer, input, timer);

        gameController.startGame();
    }


}


/*

        - If i want to access e.g. x from block(superclass) in blank(subclass), shouldnt it just work?
        or do i have to use a getter or something even better

        - On this line:
        "gameLogic.Blank current = (gameLogic.Blank)blockArray[i];
         System.out.print(" "+ current.getSurroundingBombs() + " ");"
         Do i have to do this, or is there a better practice way to call a subclass function
         from the superclass?

         - Should i make generateBoard as a class, as another method or just in the initBoard()? What is most OOP

         - In methods, should i make variables private or are they already protected by their scope

         -What is the difference between int and Integer, and should we know it


         Noter:
         I initBoard() skal der sættes alle standard variabler så som:
         antal blocks, antal bomber, osv

 */