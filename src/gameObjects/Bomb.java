package gameObjects;

import enums.BlockType;

public class Bomb extends Block{


    @Override
    public String getColor() {
        return "\u001B[41m";
    }

    public Bomb(Board board, int x, int y) {
        super(board, x, y, BlockType.BOMB);
    }

    @Override
    public boolean isBomb() {
        return true;
    }
}
