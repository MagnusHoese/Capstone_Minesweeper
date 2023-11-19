package gameObjects;

public class Bomb extends Block{

    boolean hasBomb = true;


    @Override
    public String getColor() {
        return "\u001B[40m";
    }

    public Bomb(Board board, int x, int y) {
        super(board, x, y);
    }

    @Override
    public boolean getBombStatus() {
        return hasBomb;
    }
}
