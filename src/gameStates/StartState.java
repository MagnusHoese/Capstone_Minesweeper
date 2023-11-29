package gameStates;

import gameLogic.Timer;
import renderers.TextBoardRenderer;

public class StartState implements GameState{

    private Timer timer;
    private TextBoardRenderer renderer;
    public StartState(Timer timer, TextBoardRenderer renderer) {
        this.timer = timer;
        this.renderer = renderer;

    }
    @Override
    public void handle() {
        timer.startTimer();
        renderer.draw();

        //og så få et input
        //den skal evt returne en state til en funktion i GameController som hedder ExecuteCurrentState

    }

    @Override
    public void nextState() {

    }
}
