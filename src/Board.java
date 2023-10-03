public class Board {

    private Block[] blockArray;

    public Board() {
        blockArray = new Block[64];
        initBoard();
    }

    public int getBlockXByID(int index) {
        return blockArray[index].getX();
    }

    public int getBlockYByID(int index) {
        return blockArray[index].getY();
    }

    public boolean getBombStatusByID(int index) {
        return blockArray[index].getBombStatus();
    }

    public void initBoard() {
        int index = 0;
        for(int i = 0; i< 8; i++) {
            for(int j = 0; j < 8; j++) {
                if (i == 0 && j == 0) {
                    blockArray[index] = new Bomb(this, i, j, index);
                } else if(i + j == 6) {
                    blockArray[index] = new Bomb(this, i, j, index);
                } else {
                    blockArray[index] = new Blank(this, i, j, index);
                }

                index++;
            }
        }
    }

    public Block[] getBlockArray() {
        return blockArray;
    }
}
