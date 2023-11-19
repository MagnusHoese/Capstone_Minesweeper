package gameObjects;

import java.util.Objects;

public abstract class Block {
    private int x;
    private int y;
    private int index;
    private boolean hasBomb;
    private boolean hasFlag = false;
    private boolean isRevealed;
    private Board board;
    private int surroundingBombs = 0;
    private String color;

    public Block(Board board, int x, int y) {
        this.board = board;
        this.x = x;
        this.y = y;
        this.isRevealed = false;
    }



    public int getSurroundingBombs() {
        return surroundingBombs;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getBombStatus() {
        return hasBomb;
    }

    public boolean isBlankRevealed() {
        return isRevealed;
    }

    public void setBlankStatus(boolean revealed) {
        isRevealed = revealed;
    }

    public Board getBoard() {
        return board;
    }

    public boolean hasFlag() {
        return hasFlag;
    }

    public void setFlag(boolean hasFlag) {
        this.hasFlag = hasFlag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return x == block.x &&
                y == block.y &&
                index == block.index &&
                hasBomb == block.hasBomb &&
                hasFlag == block.hasFlag &&
                isRevealed == block.isRevealed &&
                surroundingBombs == block.surroundingBombs &&
                Objects.equals(board, block.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, index, hasBomb, hasFlag, isRevealed, board, surroundingBombs);
    }



}
