package com.hva.main;

import java.util.*;

import com.hva.assignments.advancedsorting.model.Student;
import com.hva.assignments.advancedsorting.comparators.StudentComparator;
import com.hva.assignments.advancedsorting.sort.BST;
import com.hva.assignments.advancedsorting.sort.QuickSort;
import com.hva.assignments.advancedsorting.sort.v2.QuickSortV2;

public class Main {
    private static final int NR_OF_STUDENTS = 35000;

    public static void main(String[] args) {

        System.out.println("Resultaten van studenten sorteren met een advanced sort");
        quicksortTest();

        System.out.println();
//
        System.out.println("Verbetering toevoegen aan je gekozen algoritme");
        quicksortV2Test();
//
//        System.out.println();
//
//        System.out.println("Zoeken in een BST per Grade en Rank");
//        bstTest();
    }

    private static void quicksortTest() {
        ArrayList<Student> students = generateStudentList();

        print(students);

        QuickSort quickSort = new QuickSort();

        quickSort.sort(students, new StudentComparator());

        print(quickSort.getSortedList());

        System.out.println("Size: " + NR_OF_STUDENTS);

        quickSort.getAnalytics();
    }

    private static void quicksortV2Test() {
        ArrayList<Student> students = generateStudentList();

        print(students);

        QuickSortV2 quickSort = new QuickSortV2();

        quickSort.sort(students, new StudentComparator());

        print(quickSort.getSortedList());

        System.out.println("Size: " + NR_OF_STUDENTS);

        quickSort.getAnalytics();
    }

    private static void bstTest() {
        BST<Double, Integer> bst = generateBstFromStudentList();

        for (int i = 1; i <= 10; i++) {
            System.out.println("Cijfer " + i + ": " + bst.rank((double) i));
        }
    }

    private static ArrayList<Student> generateStudentList() {
        ArrayList<Student> students = new ArrayList<>();
        int id = 500600001;
        for (int i = 0; i < NR_OF_STUDENTS; i++) {
            Random generator = new Random();
            double number = (generator.nextInt(91) + 10) / 10.0;
            students.add(new Student(id++, number));
        }

        int lastStudentNumber = 500600001 + students.size();

        students.add(new Student(++lastStudentNumber, 8.1));
        students.add(new Student(++lastStudentNumber, 8.1));
        students.add(new Student(++lastStudentNumber, 8.1));

        Collections.shuffle(students);
        return students;
    }

    private static BST<Double, Integer> generateBstFromStudentList() {
        ArrayList<Student> students = generateStudentList();

        print(students);

        BST<Double, Integer> bst = new BST<>();

        for(Student student : students){
            bst.put(student.getGrade(), student.getStudentNumber());
        }

        return bst;
    }

    private static void print(ArrayList<Student> list) {
        for (Student i : list) {
            System.out.print(i.getGrade() + ", ");
        }
        System.out.println("\n");
    }

}