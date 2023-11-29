package gameStates;

import gameLogic.BoardUpdater;
import gameLogic.GameController;
import input.InputInterpreter;
import gameLogic.WinLossChecker;
import input.ConsoleInput;
import renderers.BoardRenderer;


public class RunningState implements GameState {

    private BoardRenderer renderer;
    private ConsoleInput input;
    private InputInterpreter inputInterpreter;

    public RunningState(BoardRenderer renderer, InputInterpreter inputInterpreter) {
        this.renderer = renderer;
        this.input = new ConsoleInput();
        this.inputInterpreter = inputInterpreter;

    }

    @Override
    public void handle(GameController gameController) {
        System.out.println("Running");

        //Update board
        BoardUpdater boardUpdater = new BoardUpdater(gameController);
        boardUpdater.update();
        //Draw board
        renderer.draw();

        //Check win/loss
        WinLossChecker winLossChecker = new WinLossChecker(gameController);

        if(winLossChecker.allBombsFlagged()){
            //Change to end state
            gameController.setCurrentGameState(new EndState(renderer, true));


        } else if (winLossChecker.isBombRevealed()) {
            //Change to end state
            gameController.setCurrentGameState(new EndState(renderer, false));

        } else {
            //Get Input
            inputInterpreter.interpretInput(input.getInputString());

            //Change to running state
            gameController.setCurrentGameState(new RunningState(renderer, inputInterpreter));
        }

    }

}
