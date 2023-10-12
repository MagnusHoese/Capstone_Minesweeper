import java.util.*;

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

    public boolean getBombStatus(int x, int y) {
        return blockArray[x][y].getBombStatus();
    }

    public boolean getBlankStatus(int x, int y) {
        return blockArray[x][y].getBlankStatus();
    }

    public boolean isWithinBounds(int neighborX, int neighborY) {
        return (neighborX >= 0 && neighborX < boardWidth) &&
                (neighborY >= 0 && neighborY < boardHeight);

    }

    /*public int getBlockXByID(int index) {
        return blockArray[index].getX();
    }

    public int getBlockYByID(int index) {
        return blockArray[index].getY();
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
        for(int i = 0; i < this.boardWidth; i++) {
            for(int j = 0; j < this.boardHeight; j++) {

                //First load all black spaces
                blockArray[i][j] = new Blank(this, i, j);

            }
        }


        //Generate the list of indexes where a bomb should be placed
        Random rand = new Random();

        Set<Block> set = new LinkedHashSet<Block>();

        int index = 0;

        while (set.size() < this.boardBombs) {
            int randomXIndex = rand.nextInt(this.boardWidth);
            int randomYIndex = rand.nextInt(this.boardHeight);

            set.add(new Bomb(this, randomXIndex, randomYIndex));
            index++;
        }
        System.out.println(index);

        for(Block bomb: set)
            blockArray[bomb.getX()][bomb.getY()] = bomb;


    }

    public Block[][] getBlockArray() {
        return this.blockArray;
    }

}
