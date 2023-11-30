package main.gameObjects;

import main.enums.BlockColors;
import main.enums.BlockType;

public class Blank extends Block{

    private boolean hasBomb = false;
    private int surroundingBombs;



    public Blank(Board board, int x, int y) {
        super(board, x, y, BlockType.BLANK);
    }

    @Override
    public boolean isBomb() {
        return hasBomb;
    }

    @Override
    public boolean hasFlag() {
        return super.hasFlag();
    }

    @Override
    public void setFlag(boolean hasFlag) {
        super.setFlag(hasFlag);
    }

    public int getSurroundingBombs() {
        return surroundingBombs;
    }

    public void setSurroundingBombs() {
        int numberOfBombs = 0;
        int blankX = this.getX();
        int blankY = this.getY();
        Board board = getBoard();

        int[][] directions = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 },             { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        for (int[] direction : directions) {
            int dx = direction[0];
            int dy = direction[1];
            int neighborX = blankX + dx;
            int neighborY = blankY + dy;

            if (board.isWithinBounds(neighborX, neighborY) && board.getBombStatus(neighborX, neighborY)) {
                numberOfBombs++;
            }
        }

        this.setColor(BlockColors.getColorByIndex(numberOfBombs));
        surroundingBombs = numberOfBombs;
    }

    public void checkSurroundingBlanks() {
        if(!this.isBlankRevealed()) {
            int blankX = this.getX();
            int blankY = this.getY();
            Board board = getBoard();

            int[][] directions = {
                    { -1, -1 }, { -1, 0 }, { -1, 1 },
                    { 0, -1 },             { 0, 1 },
                    { 1, -1 }, { 1, 0 }, { 1, 1 }
            };

            for (int[] direction : directions) {
                int dx = direction[0];
                int dy = direction[1];
                int neighborX = blankX + dx;
                int neighborY = blankY + dy;

                if (board.isWithinBounds(neighborX, neighborY) &&
                        board.isBlankRevealed(neighborX, neighborY) &&
                        board.getBlockObject(neighborX,neighborY).getSurroundingBombs() == 0) {

                    this.setIsRevealed(true);

                }
            }
        }
    }
}
