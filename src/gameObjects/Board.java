package gameObjects;

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
        for (int x = 0; x < boardWidth; x++) {
            List<Block> row = new ArrayList<>();
            for (int y = 0; y < boardHeight; y++) {
                // First load all black spaces
                row.add(new Blank(this, x, y));
            }
            this.blockList.add(row);
        }
        //Generate board
        generateBoard();

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

    public void setBlockList(List<List<Block>> blockList) {
        this.blockList = blockList;
    }

    public List<List<Block>> getBlockList() {
        return blockList;
    }

    public boolean getBombStatus(int x, int y) {
        return blockList.get(x).get(y).isBomb();
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

    public int getFlagCount() { //TODO Fjern inputparameter
        int flagAmount = 0;

        for(List<Block> row : this.blockList) {
            for(Block block : row) {
                if(block.hasFlag())
                    flagAmount++;
            }
        }

        return flagAmount;
    }


    public void initBoard() {


    }

    public void generateBoard() {


        //Generate the list of indexes where a bomb should be placed
        Random rand = new Random();

        Set<Block> bombSet = new LinkedHashSet<>();



        while (bombSet.size() < this.boardBombs) {
            int randomXIndex = rand.nextInt(this.boardWidth);
            int randomYIndex = rand.nextInt(this.boardHeight);

            bombSet.add(new Bomb(this, randomXIndex, randomYIndex));

        }

        for(Block bomb: bombSet)
            blockList.get(bomb.getX()).set(bomb.getY(), bomb);


    }
}
