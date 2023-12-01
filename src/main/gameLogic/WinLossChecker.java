/**
 * @author Magnus Høse, magjen22@aau.student.dk
 */

package main.gameLogic;

import main.gameObjects.Block;
import main.gameObjects.Board;

import java.util.List;

public class WinLossChecker {

    private Board board;
    private List<List<Block>> blockList;

    public WinLossChecker(GameController gameController) {
        this.board = gameController.getBoard();
        this.blockList = board.getBlockList();
    }
    public boolean allBombsFlagged() {
        int flaggedBombs = 0;


        for (List<Block> row : blockList) {
            for (Block block : row) {
                if(block.hasFlag() && block.isBomb())
                    flaggedBombs++;
            }
        }
        return flaggedBombs == board.getBoardBombs();
    }

    public boolean isBombRevealed() {

        for (List<Block> row : blockList) {
            for (Block block : row) {
                if(block.isBlankRevealed() && block.isBomb()) {
                    return true;
                }
            }
        }
        return false;
    }
}
