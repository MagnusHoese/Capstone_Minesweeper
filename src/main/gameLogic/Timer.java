package main.gameLogic;

import java.util.TimerTask;

public class Timer {

    private int seconds;

    public int getSeconds() {
        return seconds;
    }

    public void startTimer() {
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                seconds++;
            }
        }, 1000, 1000);
    }
}
