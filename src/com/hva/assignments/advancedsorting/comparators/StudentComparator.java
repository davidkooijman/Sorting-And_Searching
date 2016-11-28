package com.hva.assignments.advancedsorting.comparators;

import com.hva.assignments.advancedsorting.model.Student;
import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        //Grades of the compared students
        double studentGrade1 = student1.getGrade();
        double studentGrade2 = student2.getGrade();

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
