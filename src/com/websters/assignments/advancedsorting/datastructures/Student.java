package com.websters.assignments.advancedsorting.datastructures;

public class Student {
    int studentNumber;
    double grade;

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
