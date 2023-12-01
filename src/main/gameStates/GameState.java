/**
 * @author Magnus Høse, magjen22@aau.student.dk
 */

package main.gameStates;

import main.gameLogic.GameController;

public interface GameState {
    void handle(GameController gameController);
}
