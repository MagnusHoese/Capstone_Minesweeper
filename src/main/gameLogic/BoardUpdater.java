package main.gameLogic;

import main.gameObjects.Blank;
import main.gameObjects.Block;
import main.gameObjects.Board;

import java.util.List;

public class BoardUpdater {

    private GameController gameController;
    private Board board;
    private int boardHeight;
    private int boardWidth;
    private List<List<Block>> blockList;
    public BoardUpdater(GameController gameController) {
        this.gameController = gameController;
        this.board = gameController.getBoard();
        this.boardWidth = board.getBoardWidth();
        this.boardHeight = board.getBoardHeight();
        this.blockList = board.getBlockList();
    }

    public void update() {
        boolean blanksRevealed = true;


        // Continue iterating until no more blanks are revealed
        while (blanksRevealed) {

            blanksRevealed = false;

            for (int y = 0; y < boardHeight; y++) {
                for (int x = 0; x < boardWidth; x++) { //TODO Fix forloop
                    if (!board.getBombStatus(x, y) && !blockList.get(x).get(y).isBlankRevealed()) {

                        Blank current = (Blank) blockList.get(x).get(y);
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
