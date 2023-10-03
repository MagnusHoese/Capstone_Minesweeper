public class Launcher {
    public static void main(String[] args) {
        //Block block1 = new Block(0, 0, true);

        Board board = new Board();

        Block[] blockArray = board.getBlockArray();

        /*Blank current = (Blank)blockArray[1];
        System.out.println(current.getSurroundingBombs());*/


        for(int i = 0; i < blockArray.length; i++){

/*
            //          DEBUG show x+y
            System.out.printf("(" + blockArray[i].getX() + " ," + blockArray[i].getY() + ")");
*/

/*
            //          DEBUG show index

            System.out.printf("(" + blockArray[i].getIndex() + ")");

*/


            //          Debug show bomb+blank surrounding

            if(blockArray[i].getBombStatus()) {
                System.out.print(" ¤ ");
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

 */