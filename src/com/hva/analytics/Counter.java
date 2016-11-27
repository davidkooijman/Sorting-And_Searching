package com.hva.analytics;

public class Counter {
    private static int mergeCalls;
    private static int compares;

    public Counter(){
        mergeCalls = 0;
        compares = 0;
    }

    public void addMergeCall(){
        mergeCalls++;
    }

    public void addCompare(){
        compares++;
    }

    public String getCounts(){
        return "Swaps: " + mergeCalls + "\nCompares: " + compares;
    }
}
