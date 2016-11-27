package com.hva.assignments.advancedsorting.model;

/**
 * Created by David on 27-11-16.
 */
public class Grade {
    private double grade;

    public Grade(double grade){
        this.grade = grade;
    }

    public double getGrade(){
        return this.grade;
    }

    @Override
    public String toString() {
        return Double.toString(grade);
    }
}
