package gameObjects;

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

    public void setBlockArray(Block[][] blockArray) {
        this.blockArray = blockArray;
    }

    public Block[][] getBlockArray() {
        return blockArray;
    }

    public boolean getBombStatus(int x, int y) {
        return blockArray[x][y].getBombStatus();
    }

    public boolean isBlankRevealed(int x, int y) {
        return blockArray[x][y].isBlankRevealed();
    }

    public Block getBlockObject(int x, int y) {
        return blockArray[x][y];
    }

    public boolean isWithinBounds(int x, int y) {
        return (x >= 0 && x < boardWidth) &&
                (y >= 0 && y < boardHeight);

    }

    public int getFlagCount(Block[][] blockArray) {
        int flagAmount = 0;
        for(int y = 0; y < boardHeight; y++) {
            for(int x = 0; x < boardWidth; x++) {
                if (blockArray[x][y].hasFlag())
                    flagAmount++;
            }
        }
        return flagAmount;
    }


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



        while (set.size() < this.boardBombs) {
            int randomXIndex = rand.nextInt(this.boardWidth);
            int randomYIndex = rand.nextInt(this.boardHeight);

            set.add(new Bomb(this, randomXIndex, randomYIndex));

        }

        for(Block bomb: set)
            blockArray[bomb.getX()][bomb.getY()] = bomb;


    }



}
