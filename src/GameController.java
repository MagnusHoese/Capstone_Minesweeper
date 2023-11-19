import input.ConsoleInput;

public class GameController {

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String BLACK_BACKGROUND = "\u001B[40m";

    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String RED_BACKGROUND = "\u001B[41m";

    private Board board;

    private ConsoleInput input;
    private int boardHeight;
    private int boardWidth;
    private Block[][] blockArray;

    public int newX; // TODO: SKAL LAVES OM
    public int newY; // TODO: SKAL LAVES OM

    public GameController(Board board, ConsoleInput input) {
        this.board = board;
        this.input = input;
        this.boardHeight = board.getBoardHeight();
        this.boardWidth = board.getBoardWidth();
        this.blockArray = board.getBlockArray();
    }
    public void drawBoard(boolean areBombsRevealed, int newX, int newY) {


        System.out.printf("Bombs in total: %d | Flags set: %d | Bombs left: %d %n", board.getBoardBombs(), board.getFlagCount(blockArray), board.getBoardBombs() - board.getFlagCount(blockArray));

        System.out.println("boardWidth: " + boardWidth + ", boardHeight: " + boardHeight);


        for(int y = 0; y < boardHeight; y++) {
            for (int x = 0; x < boardWidth; x++) {



                System.out.print(" | ");

                //System.out.println(blockArray[i][j].getBlankStatus());


                if (!blockArray[x][y].isBlankRevealed() || blockArray[x][y].getBombStatus()) {
                    if (blockArray[x][y].getBombStatus()) {
                        System.out.print(BLACK_BACKGROUND + " # " + ANSI_RESET);
                        //System.out.print(" # ");
                    } else {
                        //System.out.print(" # ");
                        System.out.print(BLACK_BACKGROUND + " # " + ANSI_RESET);
                    }
                } else if (blockArray[x][y].hasFlag()) {
                    System.out.print(BLACK_BACKGROUND + " ~ " + ANSI_RESET);
                } else {
                    if(x == newX && y == newY) {
                        System.out.print(GREEN_BACKGROUND + " " + blockArray[x][y].getSurroundingBombs() + " "+ ANSI_RESET);
                    } else {
                        if (blockArray[x][y].getSurroundingBombs() == 0) {
                            System.out.print("   ");
                        } else {
                            System.out.print(" " + blockArray[x][y].getSurroundingBombs() + " ");
                        }
                    }
                }
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


        blockArray[1][1].setFlag(true);

        int inputX = input.getInputString() - 1;
        int inputY = input.getInputString() - 1;

        newX = inputX;
        newY = inputY;





        blockArray[newX][newY].setBlankStatus(true); //Simulerer at man har valgt en celle

        System.out.printf("input.Input x was %d, and input y was %d %n", newX, newY);




        return blockArray;
    }

}
