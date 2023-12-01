/**
 * @author Magnus Høse, magjen22@aau.student.dk
 */

package main.gameStates;

import main.gameLogic.BoardUpdater;
import main.gameLogic.GameController;
import main.gameLogic.Timer;
import main.input.InputInterpreter;
import main.gameLogic.WinLossChecker;
import main.input.ConsoleInput;
import main.renderers.BoardRenderer;


public class RunningState implements GameState {

    private Timer timer;
    private BoardRenderer renderer;
    private ConsoleInput input;
    private InputInterpreter inputInterpreter;

    public RunningState(Timer timer, BoardRenderer renderer, InputInterpreter inputInterpreter) {
        this.timer = timer;
        this.renderer = renderer;
        this.input = new ConsoleInput();
        this.inputInterpreter = inputInterpreter;

    }

    @Override
    public void handle(GameController gameController) {

        //Update board
        BoardUpdater boardUpdater = new BoardUpdater(gameController);
        boardUpdater.update();
        //Draw board
        renderer.draw();

        //Check win/loss
        WinLossChecker winLossChecker = new WinLossChecker(gameController);

        if(winLossChecker.allBombsFlagged()){
            //Change to end state
            gameController.setCurrentGameState(new EndState(timer, renderer, true));


        } else if (winLossChecker.isBombRevealed()) {
            //Change to end state
            gameController.setCurrentGameState(new EndState(timer, renderer, false));

        } else {
            //Get Input
            inputInterpreter.interpretInput(input.getInputString());

            //Change to running state
            gameController.setCurrentGameState(new RunningState(timer, renderer, inputInterpreter));
        }

    }

}
