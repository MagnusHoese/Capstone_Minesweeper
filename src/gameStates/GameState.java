package gameStates;

import gameLogic.GameController;

public interface GameState {
    public void handle(GameController gameController);
}
