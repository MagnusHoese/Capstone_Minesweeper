public class GameController {

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String BLACK_BACKGROUND = "\u001B[40m";

    public static final String GREEN_BACKGROUND = "\u001B[42m";

    private Board board;
    private int boardHeight;
    private int boardWidth;

    public int newX; // TODO: SKAL LAVES OM
    public int newY; // TODO: SKAL LAVES OM

    public GameController(Board board) {
        this.board = board;
        this.boardHeight = board.getBoardHeight();
        this.boardWidth = board.getBoardWidth();
    }
    public void drawBoard(boolean areBombsRevealed, int newX, int newY) {

        Block[][] blockArray = board.getBlockArray();
        System.out.println("boardWidth: " + boardWidth + ", boardHeight: " + boardHeight);


        for(int y = 0; y < boardHeight; y++) {
            for (int x = 0; x < boardWidth; x++) {



                System.out.print(" | ");

                //System.out.println(blockArray[i][j].getBlankStatus());


                if (!blockArray[x][y].isBlankRevealed() || blockArray[x][y].getBombStatus()) {
                    if (blockArray[x][y].getBombStatus()) {
                        System.out.print(BLACK_BACKGROUND + " # " + ANSI_RESET);
                    } else {
                        System.out.print(" # ");
                    }

                } else {
                    if(x == newX && y == newY) {
                        System.out.print(GREEN_BACKGROUND + " " + blockArray[x][y].getSurroundingBombs() + " "+ ANSI_RESET);
                    } else
                        System.out.print(" " + blockArray[x][y].getSurroundingBombs() + " ");
                }
                //System.out.print("i(boardWidth): " + i + ", j(boardHeight): " + j);
            }

            System.out.print(" |");
            System.out.println();
            System.out.println(" + --- + --- + --- + --- + --- + --- + --- + --- +");
        }
    }

    public void gameRound(int round) {

        boolean areBombsRevealed = false;

        Block[][] blockArray;

        if(round == 0) {
            drawBoard(areBombsRevealed, newX, newY);
        }

        blockArray = getInput();

        updateBoard(blockArray);

        areBombsRevealed = checkForRevealedBombs();

        drawBoard(areBombsRevealed, newX, newY);


    }

    private void updateBoard(Block[][] blockArray) {
        boolean blanksRevealed = true;

        int index = 0;
        // Continue iterating until no more blanks are revealed
        while (blanksRevealed) {

            blanksRevealed = false;

            for (int y = 0; y < boardHeight; y++) {
                for (int x = 0; x < boardWidth; x++) {
                    if (!blockArray[x][y].getBombStatus() && !blockArray[x][y].isBlankRevealed()) {
                        index++;
                        System.out.print(index + " ");
                        Blank current = (Blank) blockArray[x][y];
                        current.checkSurroundingBlanks();

                        // Check if the current blank has been revealed in this iteration
                        if (current.isBlankRevealed()) {
                            blanksRevealed = true;

                        }

                    }
                }
            }
        }

        // Once no more blanks are revealed, update the board
        board.setBlockArray(blockArray);
    }

    private boolean checkForRevealedBombs() {
        return false;
    }

    private Block[][] getInput() {
        Block[][] blockArray = board.getBlockArray();

        int inputX = 4;
        int inputY = 1;

        newX += inputX;
        newY = inputY;



        blockArray[newX][newY].setBlankStatus(true); //Simulerer at man har valgt en celle

        System.out.printf("Input x was %d, and input y was %d %n", newX, newY);




        return blockArray;
    }

}