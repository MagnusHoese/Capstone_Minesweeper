package gameLogic;

import enums.TextManipulation;
import gameObjects.Blank;
import gameObjects.Block;
import gameObjects.Board;
import input.ConsoleInput;
import renderers.TextBoardRenderer;

import java.util.List;

import static enums.TextManipulation.*;

public class GameController {

    private Board board;

    private ConsoleInput input;
    private TextBoardRenderer renderer;
    private Timer timer;
    private int boardHeight;
    private int boardWidth;
    private List<List<Block>> blockList;


    public GameController(Board board, TextBoardRenderer renderer, ConsoleInput input, Timer timer) {
        this.board = board;
        this.input = input;
        this.renderer = renderer;
        this.timer = timer;
        this.boardHeight = board.getBoardHeight();
        this.boardWidth = board.getBoardWidth();
        this.blockList = board.getBlockList();
    }

    public void startGame() {

        boolean gameRunning = true;
        
        timer.startTimer();

        renderer.draw();

        while (gameRunning) {

            getInput();

            updateBoard();

            renderer.draw();

            if(allBombsFlagged()){
                gameRunning = false;
                System.out.println(GREEN_BACKGROUND.getAnsiCode() + "All flags planted correctly! Congrats!" + RESET.getAnsiCode());

            } else if (isBombRevealed()) {
                gameRunning = false;
                System.out.println(RED_BACKGROUND.getAnsiCode() + "You hit a bomb :( - These were the bombs ↓" + RESET.getAnsiCode());
                revealAll();
                renderer.draw();

            }
        }

    }


    public void updateBoard() {
        boolean blanksRevealed = true;


        // Continue iterating until no more blanks are revealed
        while (blanksRevealed) {

            blanksRevealed = false;

            for (int y = 0; y < boardHeight; y++) {
                for (int x = 0; x < boardWidth; x++) { //TODO Fix forloop
                    if (!blockList.get(x).get(y).isBomb() && !blockList.get(x).get(y).isBlankRevealed()) {

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

    private boolean allBombsFlagged() {
        int flaggedBombs = 0;

        for (int y = 0; y < boardHeight; y++) {
            for (int x = 0; x < boardWidth; x++) { //TODO Fix forloop
                if(blockList.get(x).get(y).hasFlag() && blockList.get(x).get(y).isBomb())
                    flaggedBombs++;
            }
        }
        return flaggedBombs == board.getBoardBombs();
    }

    private boolean isBombRevealed() {

        for (int y = 0; y < boardHeight; y++) {
            for (int x = 0; x < boardWidth; x++) { //TODO Fix forloop
                if(blockList.get(x).get(y).isBlankRevealed() && blockList.get(x).get(y).isBomb()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void getInput() {
        input.setInputString();

        int inputX = input.getXInput() - 1;
        int inputY = input.getYInput() - 1;
        String statusInput = input.getStatusInput();

        handleInput(inputX, inputY, statusInput);
    }

    private void handleInput(int x, int y, String status) {
        if (board.isWithinBounds(x, y)) {
            switch (status) {
                case "r":
                    blockList.get(x).get(y).setIsRevealed(true);
                    break;
                case "f":
                    if(!blockList.get(x).get(y).isBlankRevealed()) {
                        blockList.get(x).get(y).setFlag(true);
                    } else {
                        System.out.println("Cell already revealed. Try Again!");
                        getInput();
                    }
                    break;
                default:
                    System.out.println("Invalid input. Try Again!");
                    getInput();
            }
        } else {
            System.out.println("Invalid coordinates. Try Again!");
            getInput();
        }
    }

    private void revealAll() {

        for (int y = 0; y < boardHeight; y++) { //TODO Fix forloop
            for (int x = 0; x < boardWidth; x++) {
                blockList.get(x).get(y).setFlag(false);
                blockList.get(x).get(y).setIsRevealed(true);
            }
        }

    }

}
