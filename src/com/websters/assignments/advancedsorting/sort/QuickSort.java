package com.websters.assignments.advancedsorting.sort;

import com.websters.assignments.advancedsorting.model.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class QuickSort {

    public ArrayList<Student> students;
    private Comparator<Student> comparator;



    public void sort(ArrayList<Student> students, Comparator<Student> comparator) {

        if (students == null || students.size() == 0) {
            return;
        }

        this.comparator = comparator;
        this.students = students;
//
        int length = students.size();

        System.out.println("test");
        quickSort(0, length - 1);
    }

    private void quickSort(int low, int high) {
        int i = low;
        int j = high;

        // pivot is middle index
        Student pivot = students.get(low + (high - low) / 2);
        while(i <= j){
            while(comparator.compare(students.get(j), pivot) < 0){
                i++;
            }
            while(comparator.compare(students.get(i), pivot) > 1){
                j--;
            }

            if(i <= j){
                swap(i,j);
            }
        }

        if(low < j){
            quickSort(low, j);
        }

        if(i < high){
            quickSort(i, high);
        }

    }

    private void swap(int i, int j){
        Student temp = students.get(i);
        students.set(i, students.get(j));
        students.set(j, temp);
    }
}