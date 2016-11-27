package com.hva.analytics;

public class RunTimer {
    private static long startTime;
    private static long endTime;

    public void startTimer(){
        startTime = System.currentTimeMillis();
    }

    public void endTimer(){
        endTime = System.currentTimeMillis();
    }

    public String getRunTime(){
        return "Runtime: " + (endTime - startTime) + " ms";
    }
}
