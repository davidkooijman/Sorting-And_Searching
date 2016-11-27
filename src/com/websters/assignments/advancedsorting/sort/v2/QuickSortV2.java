package com.websters.assignments.advancedsorting.sort.v2;


import com.websters.assignments.advancedsorting.model.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class QuickSortV2 {

    private ArrayList<Student> students;
    private Comparator<Student> comparer;

    private static int mergeCalls = 0;
    private static int compares = 0;

    public void sort(ArrayList<Student> students, Comparator<Student> comparer) {
        // check for empty or null array
        if (students ==null || students.size()==0){
            return;
        }
        this.students = students;
        this.comparer = comparer;
        int number = students.size();
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        Student pivot = median(low, high);

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (comparer.compare(students.get(i), pivot) < 0) {
                i++;
                compares++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (comparer.compare(students.get(j), pivot) > 0) {
                j--;
                compares++;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    public Student median(int left, int right) {
        int center = (left + right) / 2;
        // order left & center
        if (comparer.compare(students.get(left), students.get(center)) > 0)
            exchange(left, center);
        // order left & right
        if (comparer.compare(students.get(left), students.get(right)) > 0)
            exchange(left, right);
        // order center & right
        if (comparer.compare(students.get(center), students.get(right)) > 0)
            exchange(center, right);

        exchange(center, right - 1); // put pivot on right
        return students.get(right - 1); // return median value
    }

    private void exchange(int i, int j) {
        Student temp = students.get(i);
        students.set(i, students.get(j));
        students.set(j,  temp);
        mergeCalls++;
    }

    public ArrayList<Student> getSortedList(){
        return this.students;
    }

    public void getCounts(){
        System.out.println("MergeCalls: " + mergeCalls + " and Compares: " + compares);
    }
}