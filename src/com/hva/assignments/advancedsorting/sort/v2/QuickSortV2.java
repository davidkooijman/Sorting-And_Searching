package com.hva.assignments.advancedsorting.sort.v2;


import com.hva.analytics.Timer;
import com.hva.assignments.advancedsorting.model.Student;
import com.hva.analytics.Counter;

import java.util.ArrayList;
import java.util.Comparator;

public class QuickSortV2 {
    private static final int CUTOFF = 8;

    private ArrayList<Student> students;
    private Comparator<Student> comparator;

    private static Timer timer;
    private static Counter counter;

    private int partition(int low, int high) {
        int i = low;
        int j = high + 1;
        Student student = students.get(low);

        while (true) {

            //vind de student bij low om te swappen
            while (less(students.get(++i), student))
                if (i == high) break;

            //vind de student bij high om te swappen
            while (less(student, students.get(--j)))
                if (j == low) break;

            //Kijk of de indexen over elkaar heen gaan
            if (i >= j) break;

            exchange(i, j);
        }

        exchange(low, j);

        return j;
    }

    public void sort(ArrayList<Student> students, Comparator<Student> comparer) {

        if (students == null || students.size() == 0) {
            return;
        }

        timer = new Timer();
        counter = new Counter();

        timer.startTimer();

        this.students = students;
        this.comparator = comparer;
        sort(0, students.size() - 1);

        timer.endTimer();
    }

    private void sort(int low, int high) {
        int n = high - low + 1;

        if (n <= CUTOFF) {
            insertionSort(low, high);
            // show(a, lo, -1, -1, hi);
            return;
        }

        int median = median(low, low + n / 2, high);
        exchange(median, low);

        int j = partition(low, high);
        sort(low, j - 1);
        sort(j+1, high);
    }

    private void insertionSort(int low, int high) {
        for (int i = low; i <= high; i++)
            for (int j = i; j > low && less(students.get(j), students.get(j-1)); j--)
                exchange(j, j-1);
    }

    // return the index of the median element among students.get(low), students.get(mid), and students.get(high)
    private int median(int i, int j, int k) {
        return (less(students.get(i), students.get(j)) ?
                (less(students.get(j), students.get(k)) ? j : less(students.get(i), students.get(k)) ? k : i) :
                (less(students.get(k), students.get(j)) ? j : less(students.get(k), students.get(i)) ? k : i));
    }

    //Vergelijking tussen twee studenten.
    private boolean less(Student a, Student b) {
        counter.addCompare();
        int compare = comparator.compare(a, b);

        // Geef een boolean terug adhv de vergelijking met de compare, -1 in de compare betekend a < b
        return compare == -1;
    }

    private void exchange(int i, int j) {
        Student temp = students.get(i);
        students.set(i, students.get(j));
        students.set(j, temp);
        counter.addMergeCall();
    }

    public ArrayList<Student> getSortedList() {
        return this.students;
    }

    public void getAnalytics() {
        System.out.println(counter.getCounts());
        System.out.println(timer.getRunTime());
    }
}