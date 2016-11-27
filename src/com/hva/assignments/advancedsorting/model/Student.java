package com.hva.assignments.advancedsorting.model;

import java.util.Comparator;

public class Student {
    private int studentNumber;
    private Grade grade;

    public Student(int studentNumber, Grade grade) {
        this.studentNumber = studentNumber;
        this.grade = grade;
    }


    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "{" + studentNumber + ", " + grade + "}";
    }
}
