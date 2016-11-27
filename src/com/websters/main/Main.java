package com.websters.main;

import java.util.*;

import com.websters.assignments.advancedsorting.model.Student;
import com.websters.assignments.advancedsorting.comparators.StudentGradeComparator;
import com.websters.assignments.advancedsorting.sort.QuickSort;

public class Main {

    private static Random r = new Random();

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        int id = 500600001;
        for (int i = 0; i < 40; i++) {
            list.add(new Student(id++, ((r.nextInt(10)+1))));
        }

        print(list);

        QuickSort quickSort = new QuickSort();

        quickSort.sort(list, new StudentGradeComparator());

        print(quickSort.students);
    }

    private static void print(ArrayList<Student> list){
        for(Student i: list){
            System.out.print(i.getGrade() + ", ");
        }
        System.out.println();
    }
}