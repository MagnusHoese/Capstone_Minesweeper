import input.ConsoleInput;
import input.InputController;

public class Launcher {

    private static int boardWidth = 8;
    private static int boardHeight = 8;
    private static int boardBombs = 10;

    public static void main(String[] args) {

        Board board = new Board(boardWidth, boardHeight, boardBombs);

        ConsoleInput input = new ConsoleInput();

        GameController gameController = new GameController(board, input);

        int round = 0;
        while (true) {
            gameController.gameRound(round);
            round++;

        }

    }
}


/*

        - If i want to access e.g. x from block(superclass) in blank(subclass), shouldnt it just work?
        or do i have to use a getter or something even better

        - On this line:
        "Blank current = (Blank)blockArray[i];
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