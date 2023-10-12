public class Bomb extends Block{

    boolean hasBomb = true;

    public Bomb(Board board, int x, int y) {

        super(board, x, y);
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Block)) {
            return false;
        }

        Block c = (Block) obj;

        return Integer.compare(this.getX(), c.getX()) == 0
                && Integer.compare(this.getY(), c.getY()) == 0;
    }

    @Override
    public boolean getBombStatus() {
        return hasBomb;
    }
}
