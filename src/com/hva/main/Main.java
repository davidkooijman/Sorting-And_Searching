package com.hva.main;

import java.util.*;

import com.hva.assignments.advancedsorting.model.Grade;
import com.hva.assignments.advancedsorting.model.Student;
import com.hva.assignments.advancedsorting.comparators.StudentGradeComparator;
import com.hva.assignments.advancedsorting.sort.BST;
import com.hva.assignments.advancedsorting.sort.QuickSort;
import com.hva.assignments.advancedsorting.sort.v2.QuickSortV2;

public class Main {
    private static final int NR_OF_STUDENTS = 20000;

    public static void main(String[] args) {

        System.out.println("Resultaten van studenten sorteren met een advanced sort");
        quicksort("asc");

        System.out.println();

        System.out.println("Verbetering toevoegen aan je gekozen algoritme");
        quicksortV2("desc");

        System.out.println();

        System.out.println("Zoeken in een BST per Grade en Rank");
        binarySearchTree();
    }

    private static void print(ArrayList<Student> list) {
        for (Student i : list) {
            System.out.print(i.getGrade() + ", ");
        }
        System.out.println();
    }

    private static void quicksort(String order) {
        ArrayList<Student> students = generateStudents();

        print(students);

        QuickSort quickSort = new QuickSort();

        quickSort.sort(students, new StudentGradeComparator(order));

        print(quickSort.getSortedList());

        System.out.println("Size: " + NR_OF_STUDENTS);

        quickSort.getAnalytics();
    }

    private static void quicksortV2(String order) {
        ArrayList<Student> students = generateStudents();

        print(students);

        QuickSortV2 quickSort = new QuickSortV2();

        quickSort.sort(students, new StudentGradeComparator(order));

        print(quickSort.getSortedList());

        System.out.println("Size: " + NR_OF_STUDENTS);

        quickSort.getAnalytics();
    }

    private static void binarySearchTree() {
        BST<Double, Integer> bst = generateBSTStudents();

        // Dubbele cijfers ophalen
        List studentsWithGrade = bst.get(4.6);
        System.out.println(studentsWithGrade.size() + " studenten van de " + NR_OF_STUDENTS + " hebben een 4.6");

        studentsWithGrade = bst.get(6.2);
        System.out.println(studentsWithGrade.size()+" studenten van de " + NR_OF_STUDENTS + " hebben een 6.2");

        studentsWithGrade = bst.get(8.2);
        System.out.println(studentsWithGrade.size()+" studenten van de " + NR_OF_STUDENTS + " hebben een 8.2");

        studentsWithGrade = bst.get(10.0);
        System.out.println(studentsWithGrade.size()+" studenten van de " + NR_OF_STUDENTS + " hebben een 10.0");

        // Rank testen

        System.out.println();

        System.out.println("Lager dan 3.2: " + bst.rank(3.2) + " cijfers");
        System.out.println("Lager dan 5.5: " + bst.rank(5.5) + " cijfers");
        System.out.println("Lager dan 8.1: " + bst.rank(8.1) + " cijfers");
        System.out.println("Lager dan 10.0: " + bst.rank(10.0) + " cijfers");
    }

    private static ArrayList<Student> generateStudents() {
        ArrayList<Student> students = new ArrayList<>();
        int id = 500600001;
        for (int i = 0; i < NR_OF_STUDENTS; i++) {
            Random generator = new Random();
            double number = (generator.nextInt(91) + 10) / 10.0;
            students.add(new Student(id++, new Grade(number)));
        }

        //add duplicate values for studentnumber order
        students.add(new Student(500600006, new Grade(8.1)));
        students.add(new Student(500600014, new Grade(8.1)));
        students.add(new Student(500600023, new Grade(8.1)));

        Collections.shuffle(students);
        return students;
    }

    private static BST<Double, Integer> generateBSTStudents() {
        ArrayList<Student> students = generateStudents();

        BST<Double, Integer> bst = new BST<>();

        for(Student student : students){
            bst.put(student.getGrade().getGrade(), student.getStudentNumber());
        }

        return bst;
    }
}