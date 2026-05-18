/*
 * Name: FortressWarsClock
 * Author: Peter Cesmegi
 * Description: Class Representing the clock/timer for the game states
 */

package net.fortresswars.util;

import java.util.ArrayList;

public class FortressWarsClock {

    private final int initialTime;
    private int currentTime;
    private boolean decimal = false;

    public FortressWarsClock(int seconds) {
        this.initialTime = seconds;
        this.currentTime = seconds;
    }

    public void tick() {
        tick(-1, false);
    }

    public void tick(int tickVal, boolean decisec) {
        this.decimal = decisec;
        this.currentTime = Math.max(0, this.currentTime + tickVal);
    }

    public boolean isZero() {
        return this.currentTime <= 0;
    }

    public void reset() {
        this.currentTime = this.initialTime;
    }

    public int getCurrentTime() {
        return this.currentTime;
    }

    public void end() {
        this.currentTime = 0;
    }

    @Override
    public String toString() {
        int time;
        int tenths = 0;
        if (decimal) {
            time = currentTime / 10;
            tenths = currentTime % 10;
        } else {
            time = currentTime;
        }

        if (this.isZero()) return "00:00";

        int hours = time / 3600;
        time = time % 3600;

        int minutes = time / 60;
        time = time % 60;

        int seconds = time;

        ArrayList<String> timeARR = new ArrayList<>();
        if (hours > 0) timeARR.add(String.format("%02d", hours));
        timeARR.add(String.format("%02d", minutes));
        timeARR.add(String.format("%02d", seconds));

        String clockString = String.join(":", timeARR);
        if (decimal) {
            clockString = clockString.concat("." + tenths);
        }
        return clockString;
    }

    public int getMaxTime() {
        return initialTime;
    }

    public String timeString(int timeNum, boolean decimal) {
        int time;
        int tenths = 0;
        if (decimal) {
            time = timeNum / 10;
            tenths = timeNum % 10;
        } else {
            time = timeNum;
        }

        if (this.isZero()) return "00:00";

        int hours = time / 3600;
        time = time % 3600;

        int minutes = time / 60;
        time = time % 60;

        int seconds = time;

        ArrayList<String> timeARR = new ArrayList<>();
        if (hours > 0) timeARR.add(String.format("%02d", hours));
        timeARR.add(String.format("%02d", minutes));
        timeARR.add(String.format("%02d", seconds));

        String clockString = String.join(":", timeARR);
        if (decimal) {
            clockString = clockString.concat("." + tenths);
        }
        return clockString;
    }

    public String getLongTextDisplay() {
        int time;
        int tenths = 0;
        if (decimal) {
            time = currentTime / 10;
            tenths = currentTime % 10;
        } else {
            time = currentTime;
        }

        if (this.isZero()) return "00:00";

        int hours = time / 3600;
        time = time % 3600;

        int minutes = time / 60;
        time = time % 60;

        int seconds = time;

        ArrayList<String> timeARR = new ArrayList<>();
        if (hours > 0) timeARR.add(hours + " hours");
        if (hours > 0 || minutes > 0) timeARR.add(minutes + " minutes");
        timeARR.add(seconds + " seconds");

        String clockString = String.join(" ", timeARR);
        if (decimal) {
            clockString = clockString.concat("." + tenths);
        }
        return clockString;
    }

    public void setTime(int updatedTime) {
        currentTime = updatedTime;
    }
}
