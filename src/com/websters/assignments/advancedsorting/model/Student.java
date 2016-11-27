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

    public static Comparator<Student> StudentGradeComparator
            = (student1, student2) -> {

                double studentGrade1 = student1.getGrade();
                double studentGrade2 = student2.getGrade();

                //ascending order
                return Double.compare(studentGrade1, studentGrade2);

                //descending order
                //return Double.compare(studentGrade2, studentGrade1);
            };
}
