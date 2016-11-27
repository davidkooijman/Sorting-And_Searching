package com.websters.assignments.advancedsorting.model;

import java.util.Comparator;

/**
 *  @author David Kooijman
 *  @author Ruben Koopman
 *  @see Comparator
 */
public class Student{
    private int studentNumber;
    private double grade;

    /**
     * Add a new student with a studentnumber and grade
     *
     * @param studentNumber id of the student
     * @param grade grade/ degree of the student in double format
     */
    public Student(int studentNumber, double grade) {
        this.studentNumber = studentNumber;
        this.grade = grade;
    }


    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return studentNumber + ", " + grade;
    }
}
