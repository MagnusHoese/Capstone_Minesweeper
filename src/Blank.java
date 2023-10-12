public class Blank extends Block{

    boolean hasBomb = false;



    public Blank(Board board, int x, int y) {
        super(board, x, y);

    }

    @Override
    public boolean getBombStatus() {
        return hasBomb;
    }


    public int getSurroundingBombs() {
        int numberOfBombs = 0;
        int blankX = this.getX();
        int blankY = this.getY();
        Board board = getBoard();

        int[][] directions = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 },             { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        for (int[] direction : directions) {
            int dx = direction[0];
            int dy = direction[1];
            int neighborX = blankX + dx;
            int neighborY = blankY + dy;

            if (board.isWithinBounds(neighborX, neighborY) && board.getBombStatus(neighborX, neighborY)) {
                numberOfBombs++;
            }
        }

        return numberOfBombs;
    }

    public void checkSurroundingBlanks() {
        if(!this.getBlankStatus() && this.getSurroundingBombs() == 0) {
            int blankX = this.getX();
            int blankY = this.getY();
            Board board = getBoard();

            int[][] directions = {
                    { -1, -1 }, { -1, 0 }, { -1, 1 },
                    { 0, -1 },             { 0, 1 },
                    { 1, -1 }, { 1, 0 }, { 1, 1 }
            };

            for (int[] direction : directions) {
                int dx = direction[0];
                int dy = direction[1];
                int neighborX = blankX + dx;
                int neighborY = blankY + dy;

                if (board.isWithinBounds(neighborX, neighborY) && board.getBlankStatus(neighborX, neighborY)) {

                    this.setBlankStatus(true);
                    //System.out.println(this.getBlankStatus());
                }
            }

        }
    }
}
