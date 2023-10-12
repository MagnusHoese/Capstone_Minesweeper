public class Blank extends Block{

    boolean hasBomb = false;



    public Blank(Board board, int x, int y) {
        super(board, x, y);

    }




    @Override
    public boolean getBombStatus() {
        return hasBomb;
    }

   /*public int getSurroundingBombs() {
       int numberOfBombs = 0;
       Board board = getBoard();
       int row = this.getIndex() / 8;
       int col = this.getIndex() % 8;

       int[][] directions = {
               {-1, -1}, {-1, 0}, {-1, 1},
               {0, -1},           {0, 1},
               {1, -1}, {1, 0}, {1, 1}
       };

       for (int[] dir : directions) {
           int newRow = row + dir[0];
           int newCol = col + dir[1];

           if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
               int neighborIndex = newRow * 8 + newCol;
               if (board.getBombStatusByID(neighborIndex)) {
                   numberOfBombs++;
               }
           }
       }

       return numberOfBombs;
   }*/
}
