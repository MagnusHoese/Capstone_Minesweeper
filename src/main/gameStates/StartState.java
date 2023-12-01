package main.gameStates;

import main.gameLogic.GameController;
import main.input.InputInterpreter;
import main.gameLogic.Timer;
import main.input.ConsoleInput;
import main.renderers.BoardRenderer;

public class StartState implements GameState{

    private Timer timer;
    private BoardRenderer renderer;
    private ConsoleInput input;
    private InputInterpreter inputInterpreter;

    public StartState(Timer timer, BoardRenderer renderer, InputInterpreter inputInterpreter) {
        this.timer = timer;
        this.renderer = renderer;
        this.input = new ConsoleInput();
        this.inputInterpreter = inputInterpreter;

    }
    @Override
    public void handle(GameController gameController) {
        timer.startTimer();
        renderer.draw();

        inputInterpreter.interpretInput(input.getInputString());

        gameController.setCurrentGameState(new RunningState(timer, renderer, inputInterpreter));
    }

}
