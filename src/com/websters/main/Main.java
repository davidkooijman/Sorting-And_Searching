package com.websters.main;

import java.util.*;

import com.websters.assignments.advancedsorting.model.Grade;
import com.websters.assignments.advancedsorting.model.Student;
import com.websters.assignments.advancedsorting.comparators.StudentGradeComparator;
import com.websters.assignments.advancedsorting.sort.QuickSort;
import com.websters.assignments.advancedsorting.sort.v2.QuickSortV2;

public class Main {

    private static Random r = new Random();
    private static final int NR_OF_STUDENTS = 10000;

    public static void main(String[] args) {

        System.out.println("Resultaten van studenten sorteren met een advanced sort");
        quicksort();

        System.out.println();

        System.out.println("Verbetering toevoegen aan je gekozen algoritme");
        quicksortV2();
    }

    private static void print(ArrayList<Student> list){
        for(Student i: list){
            System.out.print(i.getGrade() + ", ");
        }
        System.out.println();
    }

    private static void quicksort(){
        ArrayList<Student> students = generateStudents();

        print(students);

        QuickSort quickSort = new QuickSort();

        quickSort.sort(students, new StudentGradeComparator());

        print(quickSort.getSortedList());

        quickSort.getCounts();
    }

    private static void quicksortV2(){
        ArrayList<Student> students = generateStudents();

        print(students);

        QuickSortV2 quickSort = new QuickSortV2();

        quickSort.sort(students, new StudentGradeComparator());

        print(quickSort.getSortedList());

        quickSort.getCounts();
    }

    private static ArrayList<Student> generateStudents(){
        ArrayList<Student> students = new ArrayList<>();
        int id = 500600001;
        for (int i = 0; i < NR_OF_STUDENTS; i++) {
            students.add(new Student(id++, new Grade((r.nextInt(10)+1))));
        }

        Collections.shuffle(students);
        return students;
    }
}