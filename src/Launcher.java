import java.awt.*;

public class Launcher {

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String BLACK_BACKGROUND = "\u001B[40m";

    public static final String GREEN_TEXT = "\u001B[32m";

    private static int boardWidth = 8;
    private static int boardHeight = 8;
    private static int boardBombs = 20;

    public static void main(String[] args) {

        Board board = new Board(boardWidth, boardHeight, boardBombs);

        Input input = new Input();

        Block[][] blockArray = board.getBlockArray();

        //blockArray[1][1].setBlankStatus(true);
/*
        for(int i = 0; i < blockArray.length; i++) {
            System.out.printf("(" + blockArray[i].getIndex() + ")");
            if((i+1)%8 == 0) {
                System.out.println();
            }
        }

 */


        //System.out.println(GREEN_TEXT + "  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |" + ANSI_RESET);
        //System.out.println("--+ --- + --- + --- + --- + --- + --- + --- + --- +");


        /*for(int i = 0; i < blockArray.length; i++){

/*
            //          DEBUG show x+y
            System.out.printf("(" + blockArray[i].getX() + " ," + blockArray[i].getY() + ")");
*/

/*
            //          DEBUG show index

            System.out.printf("(" + blockArray[i].getIndex() + ")");

*/


            //          DEBUG show bomb+blank surrounding
/*
            if((i+1)%8 == 1) {
                System.out.print(GREEN_TEXT + ((i/8)+1) + ANSI_RESET);

            }

            System.out.print(" | ");
            if ((blockArray[i].getBlankStatus())) {

                if (blockArray[i].getBombStatus()) {
                    System.out.print(BLACK_BACKGROUND + " ¤ " + ANSI_RESET);
                } else {
                    Blank current = (Blank) blockArray[i];
                    System.out.print(" " + current.getSurroundingBombs() + " ");
                }
            } else {
                System.out.print("   ");
            }



            if((i+1)%8 == 0) {
                System.out.print(" |");
                System.out.println();
                System.out.println("--+ --- + --- + --- + --- + --- + --- + --- + --- +");
            }


        }*/

        //System.out.println(blockArray[6].getSurroundingBlanks());


        for(int i = 0; i < boardWidth; i++) {
            for(int j = 0; j < boardHeight; j++) {
                System.out.print(" | ");

                //System.out.println(blockArray[i][j].getBlankStatus());

                /*if (blockArray[i][j].getBombStatus()) {
                    System.out.print(BLACK_BACKGROUND + " ¤ " + ANSI_RESET);
                } else {
                    Blank current = (Blank) blockArray[i][j];
                    current.checkSurroundingBlanks();
                }*/
                if (blockArray[i][j].getBlankStatus()) {

                    System.out.print("   ");
                } else {
                    if (!blockArray[i][j].getBombStatus()) {
                        Blank current = (Blank) blockArray[i][j];
                        current.checkSurroundingBlanks();
                    }
                    System.out.print( blockArray[i][j].getColor() + " " + blockArray[i][j].getSurroundingBombs() + " " + ANSI_RESET);
                }

            }
            System.out.print(" |");
            System.out.println();
            System.out.println(" + --- + --- + --- + --- + --- + --- + --- + --- +");
        }

        System.out.println(Color.RED);
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