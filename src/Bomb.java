public class Bomb extends Block{

    boolean hasBomb = true;

    public Bomb(Board board, int x, int y) {
        super(board, x, y);
    }

    @Override
    public boolean getBombStatus() {
        return hasBomb;
    }
}
