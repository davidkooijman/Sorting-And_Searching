package com.hva.assignments.advancedsorting.sort;


import com.hva.analytics.Counter;
import com.hva.assignments.advancedsorting.model.Student;
import com.hva.analytics.Timer;

import java.util.ArrayList;
import java.util.Comparator;

public class QuickSort {

    private ArrayList<Student> students;
    private Comparator<Student> comparator;

    private static Timer timer;
    private static Counter counter;

    public void sort(ArrayList<Student> students, Comparator<Student> comparer) {

        if (students ==null || students.size()==0){
            return;
        }

        timer = new Timer();
        counter = new Counter();

        timer.startTimer();

        this.students = students;
        this.comparator = comparer;
        int number = students.size();
        quicksort(0, number - 1);

        timer.endTimer();
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        Student pivot = students.get(low + (high-low)/2);

        while (i <= j) {
            while (comparator.compare(students.get(i), pivot) < 0) {
                i++;
                counter.addCompare();
            }
            while (comparator.compare(students.get(j), pivot) > 0) {
                j--;
                counter.addCompare();
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }

        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        Student temp = students.get(i);
        students.set(i, students.get(j));
        students.set(j,  temp);
        counter.addMergeCall();
    }

    public ArrayList<Student> getSortedList(){
        return this.students;
    }

    public void getAnalytics(){
        System.out.println(counter.getCounts());
        System.out.println(timer.getRunTime());
    }
}