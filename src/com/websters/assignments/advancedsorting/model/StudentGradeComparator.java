package com.websters.assignments.advancedsorting.model;

import java.util.Comparator;

/**
 * Created by David on 27-11-16.
 */
public class StudentGradeComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        double studentGrade1 = student1.getGrade();
        double studentGrade2 = student2.getGrade();

        //ascending order
        return Double.compare(studentGrade1, studentGrade2);

        //descending order
        //return Double.compare(studentGrade2, studentGrade1);
    }
}
