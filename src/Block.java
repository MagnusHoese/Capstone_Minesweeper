public abstract class Block {
    private int x;
    private int y;
    private int index;
    private boolean hasBomb;
    private boolean hasFlag = false;
    private Board board;

    public Block(Board board, int x, int y, int index) {
        this.board = board;
        this.x = x;
        this.y = y;
        this.index = index;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getIndex() {
        return index;
    }

    public boolean getBombStatus() {
        return hasBomb;
    }

    public Board getBoard() {
        return board;
    }


}
