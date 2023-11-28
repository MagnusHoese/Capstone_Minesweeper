package gameObjects;

public class Bomb extends Block{


    @Override
    public String getColor() {
        return "\u001B[41m";
    }

    public Bomb(Board board, int x, int y) {
        super(board, x, y);
    }

    @Override
    public boolean isBomb() {
        return true;
    }
}
