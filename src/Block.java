import java.util.Arrays;

public abstract class Block {
    private int x;
    private int y;
    private int index;
    private boolean hasBomb;
    private boolean hasFlag = false;
    private boolean isRevealed;
    private Board board;
    private int surroundingBombs = 0;

    public Block(Board board, int x, int y) {
        this.board = board;
        this.x = x;
        this.y = y;
        this.index = index;
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

    /*public int getIndex() {
        return index;
    }*/

    public boolean getBombStatus() {
        return hasBomb;
    }

    public boolean getBlankStatus() {
        return isRevealed;
    }

    public void setBlankStatus(boolean revealed) {
        isRevealed = revealed;
    }

    public Board getBoard() {
        return board;
    }

    /*public int[] getSurroundingBlanks() {
        int[] surroundingBlankIndex = new int[8];
        Board board = getBoard();
        int row = this.getIndex() / 8;
        int col = this.getIndex() % 8;

        System.out.println(row);

        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };
        System.out.println(Arrays.toString(directions));

        int index = 0;
        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                int neighborIndex = newRow * 8 + newCol;
                if (board.getBlankStatusByID(neighborIndex)) {
                    surroundingBlankIndex[index] = neighborIndex;
                }
            }
            index++;
        }

        return surroundingBlankIndex;
    }*/
}
