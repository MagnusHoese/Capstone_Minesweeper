package main.gameLogic;


import java.util.TimerTask;

public class Timer {

    private java.util.Timer timer;

    private int seconds;

    public int getSeconds() {
        return seconds;
    }

    public void startTimer() {
        timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                seconds++;
            }
        }, 1000, 1000);
    }

    public void stopTimer() {
        timer.cancel();
        timer.purge();
    }
}
