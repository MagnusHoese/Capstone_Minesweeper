package main.gameStates;

import main.gameLogic.GameController;
import main.renderers.BoardRenderer;

import static main.enums.TextManipulation.*;

public class EndState implements GameState{

    private BoardRenderer renderer;
    private boolean hasWon;

    public EndState(BoardRenderer renderer, boolean hasWon) {
        this.renderer = renderer;
        this.hasWon = hasWon;
    }
    @Override
    public void handle(GameController gameController) {
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
