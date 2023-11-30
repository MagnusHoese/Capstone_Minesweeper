package main.gameStates;

import main.gameLogic.GameController;

public interface GameState {
    public void handle(GameController gameController);
}
