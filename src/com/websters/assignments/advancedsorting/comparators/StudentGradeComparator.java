package com.websters.assignments.advancedsorting.comparators;

import com.websters.assignments.advancedsorting.model.Student;

import java.util.Comparator;

/**
 * Created by David on 27-11-16.
 */
public class StudentGradeComparator implements Comparator<Student> {

    private String order;

    public StudentGradeComparator(String order) {
        if (order.toLowerCase().equals("asc") || order.toLowerCase().equals("desc")) {
            this.order = order;
        }
    }

    public StudentGradeComparator() {
        this.order = "asc";
    }

    @Override
    public int compare(Student student1, Student student2) {
        double studentGrade1 = student1.getGrade().getGrade();
        double studentGrade2 = student2.getGrade().getGrade();

        if (order.toLowerCase().equals("desc")) {
            return Double.compare(studentGrade2, studentGrade1);
        } else {
            return Double.compare(studentGrade1, studentGrade2);
        }
    }
}
