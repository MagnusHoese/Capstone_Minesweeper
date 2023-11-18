import java.awt.*;

public class Blank extends Block{

    private boolean hasBomb = false;

    private final Color BLACK = new Color(0, 0, 0);
    private final Color BLUE = new Color(0, 0, 255);
    private final Color GREEN = new Color(0, 200, 0);
    private final Color RED = new Color(255, 0, 0);
    private final Color DARKBLUE = new Color(0, 0, 155);
    private final Color BORDEAUX = new Color(155, 0, 0);
    private final Color CYAN = new Color(0, 200, 200);
    private final Color PURPLE = new Color(200, 0, 200);
    private final Color GREY =  new Color(155, 155, 155);



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

        switch (numberOfBombs){
            case 0:
                this.setColor("\u001B[30m"); // black
                break;
            case 1:
                this.setColor("\u001B[34m"); // blue
                break;
            case 2:
                this.setColor("\u001B[32m"); // green
                break;
            case 3:
                this.setColor("\u001B[31m"); // red
                break;
            case 4:
                this.setColor("\u001B[34;1m"); //Dark blue / blue bold
                break;
            case 5:
                this.setColor("\u001B[31;1m"); //Dark red / red bold
                break;
            case 6:
                this.setColor("\u001B[36m"); // Cyan
                break;
            case 7:
                this.setColor("\u001B[30;1m"); //Black bold
                break;
            case 8:
                this.setColor("\u001B[37m"); // Grey
                break;

        }

        return numberOfBombs;
    }

    public void checkSurroundingBlanks() {
        if(!this.isBlankRevealed()) {
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

                if (board.isWithinBounds(neighborX, neighborY) &&
                        board.isBlankRevealed(neighborX, neighborY) &&
                        board.getBlockObject(neighborX,neighborY).getSurroundingBombs() == 0) {

                    this.setBlankStatus(true);

                }
            }
        }
    }
}
