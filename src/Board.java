import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Board {

    private Block[] blockArray;

    public Board() {

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
        //Init blockArray
        blockArray = new Block[64];
        //Generate board
        generateBoard();

    }

    public void generateBoard() {
        int index = 0;
        for(int i = 0; i< 8; i++) {
            for(int j = 0; j < 8; j++) {

                //First load all black spaces
                blockArray[index] = new Blank(this, i, j, index);
                index++;
            }
        }

        //Generate the list of indexes where a bomb should be placed
        int numberOfBombs = 10; //Skal muligvis placeres et andet sted når spillet bliver mere customizable
        int numberOfBlocks = 64; //Samme som før

        Integer[] bombIndex = new Integer[numberOfBombs]; //We use Integer instead of int, in order to convert the set to the array bombIndex
        Random rand = new Random();
        Set<Integer> set = new LinkedHashSet<Integer>(); //To avoid dublicates i use a Linked Hash Set

        while (set.size() < numberOfBombs) {
            set.add(rand.nextInt(numberOfBlocks));
        }
        set.toArray(bombIndex);


        for (int j : bombIndex) {
            blockArray[j] = new Bomb(this, getBlockXByID(j), getBlockYByID(j), j);
        }

    }

    public Block[] getBlockArray() {
        return blockArray;
    }
}
