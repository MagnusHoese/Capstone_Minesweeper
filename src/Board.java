import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Board {

    private int boardWidth;
    private int boardHeight;
    private int boardSize;
    private int boardBombs;

    private Block[][] blockArray;


    public Board(int boardWidth, int boardHeight, int boardBombs) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;

        this.boardSize = this.boardWidth * this.boardHeight;

        this.boardBombs = Math.min(boardBombs, this.boardSize);

        initBoard();
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int getBoardBombs() {
        return boardBombs;
    }

    /*public int getBlockXByID(int index) {
        return blockArray[index].getX();
    }

    public int getBlockYByID(int index) {
        return blockArray[index].getY();
    }

    public boolean getBombStatusByID(int index) {
        return blockArray[index].getBombStatus();
    }

    public boolean getBlankStatusByID(int index) {
        return blockArray[index].getBlankStatus();
    }*/

    public void initBoard() {
        //Init blockArray
        blockArray = new Block[this.boardWidth][this.boardHeight];
        //Generate board
        generateBoard();

    }

    public void generateBoard() {
        for(int i = 0; i< 8; i++) {
            for(int j = 0; j < 8; j++) {

                //First load all black spaces
                blockArray[i][j] = new Blank(this, i, j);

            }
        }


        //Generate the list of indexes where a bomb should be placed

        //Integer[][] bombIndex = new Integer[this.boardBombs][this.boardBombs]; //We use Integer instead of int, in order to convert the set to the array bombIndex
        Random rand = new Random();
        /*Set<Integer><Integer> set = new LinkedHashSet<Integer><Integer>(); //To avoid dublicates i use a Linked Hash Set

        while (set.size() < this.boardBombs) {
            set.add(rand.nextInt(this.boardSize));
        }
        set.toArray(bombIndex);


        for (int j : bombIndex) {
            blockArray[j] = new Bomb(this, getBlockXByID(j), getBlockYByID(j), j);
        }
        */
        for(int i = 0; i < this.boardBombs; i++) {
            int randomXIndex = rand.nextInt(this.boardWidth);
            int randomYIndex = rand.nextInt(this.boardHeight);

            blockArray[randomXIndex][randomYIndex] = new Bomb(this, randomXIndex, randomYIndex);
        }

    }

    public Block[][] getBlockArray() {
        return this.blockArray;
    }

}
