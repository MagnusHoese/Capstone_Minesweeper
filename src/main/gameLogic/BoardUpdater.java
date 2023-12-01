/**
 * @author Magnus Høse, magjen22@aau.student.dk
 */

package main.gameLogic;

import main.gameObjects.Blank;
import main.gameObjects.Block;
import main.gameObjects.Board;

import java.util.List;

public class BoardUpdater {

    private Board board;
    private List<List<Block>> blockList;
    public BoardUpdater(GameController gameController) {
        this.board = gameController.getBoard();
        this.blockList = board.getBlockList();
    }

    public void update() {
        boolean blanksRevealed = true;


        // Continue iterating until no more blanks are revealed
        while (blanksRevealed) {

            blanksRevealed = false;

            for (List<Block> row : blockList) {
                for (Block block : row) {
                    if (!block.isBomb() && !block.isBlankRevealed()) {
                        Blank current = (Blank) block;
                        current.checkSurroundingBlanks();

                        // Check if the current blank has been revealed in this iteration
                        if (current.isBlankRevealed()) {
                            blanksRevealed = true;
                        }
                    }
                }
            }
        }

        board.setBlockList(blockList);
    }

}
