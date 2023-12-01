package main.gameStates;

import main.gameLogic.GameController;
import main.gameLogic.Timer;
import main.renderers.BoardRenderer;

import static main.enums.TextManipulation.*;

public class EndState implements GameState{

    private Timer timer;
    private BoardRenderer renderer;
    private boolean hasWon;

    public EndState(Timer timer, BoardRenderer renderer, boolean hasWon) {
        this.timer = timer;
        this.renderer = renderer;
        this.hasWon = hasWon;
    }
    @Override
    public void handle(GameController gameController) {
        timer.stopTimer();
        if(hasWon) {
            System.out.println(GREEN_BACKGROUND.getAnsiCode() + "All flags planted correctly! Congrats!" + RESET.getAnsiCode());
            renderer.draw();
        } else {
            gameController.getBoard().revealBoard();
            System.out.println(RED_BACKGROUND.getAnsiCode() + "You hit a bomb :( - These were the bombs ↓" + RESET.getAnsiCode());
            renderer.draw();
        }
    }

}
