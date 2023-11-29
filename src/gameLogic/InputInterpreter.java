package gameLogic;

import gameObjects.Block;
import gameObjects.Board;
import gui.Input;
import input.ConsoleInput;

import java.util.List;

public class InputInterpreter {

    private Board board;
    private List<List<Block>> blockList;
    private ConsoleInput consoleInput;
    public InputInterpreter (Board board, ConsoleInput consoleInput, List<List<Block>> blockList){
        this.board = board;
        this.consoleInput = consoleInput;
        this.blockList = blockList;
    }
    public void interpretInput(String[] input) {


        int inputX = Integer.parseInt(input[0]);
        int inputY  = Integer.parseInt(input[1]);
        String statusInput = input[2];


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
                        interpretInput(consoleInput.getInputString());
                    }
                    break;
                default:
                    System.out.println("Invalid input. Try Again!");
                    interpretInput(consoleInput.getInputString());
            }
        } else {
            System.out.println("Invalid coordinates. Try Again!");
            interpretInput(consoleInput.getInputString());
        }
    }
}
