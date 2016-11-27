package com.hva.main;

import java.util.*;

import com.hva.assignments.advancedsorting.model.Grade;
import com.hva.assignments.advancedsorting.model.Student;
import com.hva.assignments.advancedsorting.comparators.StudentGradeComparator;
import com.hva.assignments.advancedsorting.sort.QuickSort;
import com.hva.assignments.advancedsorting.sort.v2.QuickSortV2;

public class Main {
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

        quickSort.getAnalytics();
    }

    private static void quicksortV2(){
        ArrayList<Student> students = generateStudents();

        print(students);

        QuickSortV2 quickSort = new QuickSortV2();

        quickSort.sort(students, new StudentGradeComparator());

        print(quickSort.getSortedList());

        quickSort.getAnalytics();
    }

    private static ArrayList<Student> generateStudents(){
        ArrayList<Student> students = new ArrayList<>();
        int id = 500600001;
        for (int i = 0; i < NR_OF_STUDENTS; i++) {
            Random generator = new Random();
            double number = (generator.nextInt(91) + 10) / 10.0;
            students.add(new Student(id++, new Grade(number)));
        }

        Collections.shuffle(students);
        return students;
    }
}