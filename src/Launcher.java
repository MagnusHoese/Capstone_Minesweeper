public class Launcher {

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String BLACK_BACKGROUND = "\u001B[40m";

    public static void main(String[] args) {
        //Block block1 = new Block(0, 0, true);

        Board board = new Board();

        Block[] blockArray = board.getBlockArray();

        /*Blank current = (Blank)blockArray[1];
        System.out.println(current.getSurroundingBombs());*/
/*
        for(int i = 0; i < blockArray.length; i++) {
            System.out.printf("(" + blockArray[i].getIndex() + ")");
            if((i+1)%8 == 0) {
                System.out.println();
            }
        }

 */
        System.out.println();
        for(int i = 0; i < blockArray.length; i++){

/*
            //          DEBUG show x+y
            System.out.printf("(" + blockArray[i].getX() + " ," + blockArray[i].getY() + ")");
*/

/*
            //          DEBUG show index

            System.out.printf("(" + blockArray[i].getIndex() + ")");

*/


            //          DEBUG show bomb+blank surrounding

            if(blockArray[i].getBombStatus()) {
                System.out.print(BLACK_BACKGROUND + " ¤ " + ANSI_RESET);
            } else {
                Blank current = (Blank)blockArray[i];
                System.out.print(" "+ current.getSurroundingBombs() + " ");
            }



            if((i+1)%8 == 0) {
                System.out.println();
            }


        }
    }
}


/*

        - If i want to access e.g. index from block(superclass) in blank(subclass), shouldnt it just work?
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