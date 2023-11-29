package gameLogic;


import gameObjects.Block;
import gameObjects.Board;

import java.util.List;

public class WinLossChecker {

    private Board board;
    private int boardHeight;
    private int boardWidth;
    private List<List<Block>> blockList;

    public WinLossChecker(GameController gameController) {
        this.board = gameController.getBoard();
        this.boardWidth = board.getBoardWidth();
        this.boardHeight = board.getBoardHeight();
        this.blockList = board.getBlockList();
    }
    public boolean allBombsFlagged() {
        int flaggedBombs = 0;


        for (int y = 0; y < boardHeight; y++) {
            for (int x = 0; x < boardWidth; x++) { //TODO Fix forloop
                if(blockList.get(x).get(y).hasFlag() && board.getBombStatus(x, y))
                    flaggedBombs++;
            }
        }
        return flaggedBombs == board.getBoardBombs();
    }

    public boolean isBombRevealed() {

        for (int y = 0; y < boardHeight; y++) {
            for (int x = 0; x < boardWidth; x++) { //TODO Fix forloop
                if(blockList.get(x).get(y).isBlankRevealed() && board.getBombStatus(x, y)) {
                    return true;
                }
            }
        }
        return false;
    }
}
