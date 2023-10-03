public class Blank extends Block{

    boolean hasBomb = false;

    public Blank(Board board, int x, int y, int index) {
        super(board, x, y, index);

    }


    @Override
    public boolean getBombStatus() {
        return hasBomb;
    }

    public int getSurroundingBombs() {
        int numberOfBombs = 0;
        Board board = getBoard();

        /*int currentX = board.getBlockXByID(this.getIndex());
        int currentY = board.getBlockYByID(this.getIndex());*/
        if ( this.getIndex() % 8 != 0) {
            if (board.getBombStatusByID(this.getIndex() - 1))
                numberOfBombs++;
        }
        if (this.getIndex() > 8) {
            if (board.getBombStatusByID(this.getIndex() - 9))
                numberOfBombs++;
            if (board.getBombStatusByID(this.getIndex() - 8))
                numberOfBombs++;
            if (board.getBombStatusByID(this.getIndex() - 7))
                numberOfBombs++;
        }
        if (this.getIndex() < 55) {
            if (board.getBombStatusByID(this.getIndex() + 7))
                numberOfBombs++;
            if (board.getBombStatusByID(this.getIndex() + 8))
                numberOfBombs++;
            if (board.getBombStatusByID(this.getIndex() + 9))
                numberOfBombs++;
        }
        if (this.getIndex() != 7 &&
                this.getIndex() != 15 &&
                this.getIndex() != 23 &&
                this.getIndex() != 31 &&
                this.getIndex() != 39 &&
                this.getIndex() != 47 &&
                this.getIndex() != 55 &&
                this.getIndex() != 63 ) {
            if (board.getBombStatusByID(this.getIndex() + 1))
                numberOfBombs++;
        }


        return numberOfBombs;
    }
}
