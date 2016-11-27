package com.websters.assignments.advancedsorting.datastructures;

import java.util.Comparator;

public class Student{
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

    public static Comparator<Student> StudentGradeComparator
            = new Comparator<Student>() {

        public int compare(Student student1, Student student2) {

            double studentGrade1 = student1.getGrade();
            double studentGrade2 = student2.getGrade();

            //ascending order
            return Double.compare(studentGrade1, studentGrade2);

            //descending order
            //return fruitName2.compareTo(fruitName1);
        }

    };
}
