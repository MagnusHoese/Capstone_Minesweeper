public class Bomb extends Block{

    boolean hasBomb = true;

    public Bomb(Board board, int x, int y, int index) {
        super(board, x, y, index);
    }


    @Override
    public boolean getBombStatus() {
        return hasBomb;
    }
}
