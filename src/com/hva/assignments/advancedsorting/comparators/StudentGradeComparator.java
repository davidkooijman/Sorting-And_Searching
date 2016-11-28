package com.hva.assignments.advancedsorting.comparators;

import com.hva.assignments.advancedsorting.model.Student;

import java.security.InvalidParameterException;
import java.util.Comparator;

public class StudentGradeComparator implements Comparator<Student> {

    private String order;

    public StudentGradeComparator(String order) {
        if (order.toLowerCase().equals("asc") || order.toLowerCase().equals("desc")) {
            this.order = order;
        }else{
            throw new InvalidParameterException("Use \"asc\" or \"desc\" as ordering");
        }
    }

    public StudentGradeComparator() {
        this.order = "asc";
    }

    @Override
    public int compare(Student student1, Student student2) {
        if (order.toLowerCase().equals("desc")) {
            return compareCriteria(student1, student2);
        } else {
            return compareCriteria(student2, student1);
        }
    }

    private int compareCriteria(Student student1, Student student2) {

        //Grades of the compared students
        double studentGrade1 = student1.getGrade().getGrade();
        double studentGrade2 = student2.getGrade().getGrade();

        //Studentnumbers of the compared students
        int studentNumber1 = student1.getStudentNumber();
        int studentNumber2 = student2.getStudentNumber();

        int num = Double.compare(studentGrade2, studentGrade1);
        if (num != 0) {
            return num;
        } else {
            return Integer.compare(studentNumber2, studentNumber1);

        }
    }
}
