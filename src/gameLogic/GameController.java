package gameLogic;

import gameObjects.Block;
import gameObjects.Board;
import gameStates.GameState;
import gameStates.StartState;
import input.ConsoleInput;
import input.InputInterpreter;
import renderers.BoardRenderer;

import java.util.List;


public class GameController {

    private Board board;

    private List<List<Block>> blockList;
    private InputInterpreter inputInterpreter;

    private GameState currentGameState;


    public GameController(Board board, BoardRenderer renderer, ConsoleInput input, Timer timer) {
        this.board = board;
        this.blockList = board.getBlockList();
        this.inputInterpreter = new InputInterpreter(board, input, blockList);
        setCurrentGameState(new StartState(timer, renderer, inputInterpreter));
    }

    public void setCurrentGameState(GameState state){
        currentGameState = state;
        executeState();
    }
    private void executeState() {
        currentGameState.handle(this);
    }

    public Board getBoard() {
        return board;
    }

}
