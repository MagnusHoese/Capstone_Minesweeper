package main.gameObjects;

import main.enums.BlockType;

import java.util.Objects;

public abstract class Block {
    private final int x;
    private final int y;
    private boolean isBomb;
    private boolean hasFlag;
    private boolean isRevealed;
    private final Board board;
    private int surroundingBombs;
    private String color;

    private BlockType blockType;

    public Block(Board board, int x, int y, BlockType blockType) {
        this.board = board;
        this.x = x;
        this.y = y;
        this.blockType = blockType;
        this.hasFlag = false;
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

    public boolean isBomb() {
        return isBomb;
    }

    public boolean isBlankRevealed() {
        return isRevealed;
    }

    public void setIsRevealed(boolean revealed) {
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
    public BlockType getBlockType() {
        return blockType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return x == block.x &&
                y == block.y &&
                isBomb == block.isBomb &&
                hasFlag == block.hasFlag &&
                isRevealed == block.isRevealed &&
                surroundingBombs == block.surroundingBombs &&
                Objects.equals(board, block.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, isBomb, hasFlag, isRevealed, board, surroundingBombs);
    }



}
