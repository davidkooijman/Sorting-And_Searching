package com.websters.main;

import java.util.*;

import com.websters.assignments.advancedsorting.model.Student;
import com.websters.assignments.advancedsorting.model.StudentGradeComparator;

public class Main {

    private static Random r = new Random();

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        int id = 500600001;
        for (int i = 0; i < 5; i++) {
            list.add(new Student(id++, ((r.nextInt(10)+1))));
        }
        Collections.shuffle(list);

        for(Student i: list) {
            System.out.print(i.getGrade() + ", ");
        }

        list.sort(new StudentGradeComparator());

        System.out.println();

        for(Student i: list) {
            System.out.print(i.getGrade() + ", ");
        }

    }
}