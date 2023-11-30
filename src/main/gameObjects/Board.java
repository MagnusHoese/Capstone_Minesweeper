package main.gameObjects;

import main.enums.BlockType;

import java.util.*;

public class Board {

    private int boardWidth;
    private int boardHeight;
    private int boardSize;
    private int boardBombs;

    private List<List<Block>> blockList;


    public Board(int boardWidth, int boardHeight, int boardBombs) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;

        this.boardSize = this.boardWidth * this.boardHeight;

        this.boardBombs = Math.min(boardBombs, this.boardSize);

        this.blockList = new ArrayList<>();

        //Generate board
        generateBoard();

    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public int getBoardBombs() {
        return boardBombs;
    }

    public void setBlockList(List<List<Block>> blockList) {
        this.blockList = blockList;
    }

    public List<List<Block>> getBlockList() {
        return blockList;
    }

    public boolean getBombStatus(int x, int y) {
        return blockList.get(x).get(y).getBlockType() == BlockType.BOMB;
    }

    public boolean isBlankRevealed(int x, int y) {
        return blockList.get(x).get(y).isBlankRevealed();
    }

    public Block getBlockObject(int x, int y) {
        return blockList.get(x).get(y);
    }

    public boolean isWithinBounds(int x, int y) {
        return (x >= 0 && x < boardWidth) &&
                (y >= 0 && y < boardHeight);

    }

    public int getFlagCount() {
        int flagAmount = 0;

        for(List<Block> row : this.blockList) {
            for(Block block : row) {
                if(block.hasFlag())
                    flagAmount++;
            }
        }

        return flagAmount;
    }

    public void revealBoard() {

        for (int y = 0; y < boardHeight; y++) { //TODO Fix forloop
            for (int x = 0; x < boardWidth; x++) {
                blockList.get(x).get(y).setFlag(false);
                blockList.get(x).get(y).setIsRevealed(true);
            }
        }
    }


    public void generateBoard() {
        generateBlankSpaces();  //Generate the Board with blank spaces
        placeBombs(); //Generate the list of indexes where a bomb should be placed
        setSurroundingBombs(); //Lastly generate how many bombs there is around the blanks
    }

    private void generateBlankSpaces() {
        for (int x = 0; x < boardWidth; x++) {
            List<Block> row = new ArrayList<>();
            for (int y = 0; y < boardHeight; y++) {
                // Load all blank spaces
                row.add(new Blank(this, x, y));
            }
            this.blockList.add(row);
        }
    }

    public void placeBombs() { //Made public for the test
        Random rand = new Random();
        Set<Block> bombSet = new HashSet<>();

        while (bombSet.size() < this.boardBombs) {
            int randomXIndex = rand.nextInt(this.boardWidth);
            int randomYIndex = rand.nextInt(this.boardHeight);

            bombSet.add(new Bomb(this, randomXIndex, randomYIndex));
        }
        System.out.println(bombSet.size());

        for (Block bomb : bombSet) {
            blockList.get(bomb.getX()).set(bomb.getY(), bomb);
        }
    }

    public void setSurroundingBombs() { //Made public for the test
        for (List<Block> row : blockList) {
            for (Block block : row) {
                if (block.getBlockType() == BlockType.BLANK) {
                    ((Blank) block).setSurroundingBombs();
                }
            }
        }
    }
}

