package com.hva.assignments.advancedsorting.sort.v2;


import com.hva.analytics.Timer;
import com.hva.assignments.advancedsorting.model.Student;
import com.hva.analytics.Counter;

import java.util.ArrayList;
import java.util.Comparator;

public class QuickSortV2 {

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
        int n = high - low + 1;
        int mid = low + n/2;
        Student pivot = median(low, mid, high);

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

    // return the index of the median element among students.get(low), students.get(mid), and students.get(high)
    private Student median(int i, int j, int k) {
        return (less(students.get(i), students.get(j)) ?
                (less(students.get(j), students.get(k)) ? students.get(j) : less(students.get(i), students.get(k)) ? students.get(k) : students.get(i)) :
                (less(students.get(k), students.get(j)) ? students.get(j) : less(students.get(k), students.get(i)) ? students.get(k) : students.get(i)));
    }

    //Vergelijking tussen twee studenten.
    private boolean less(Student a, Student b){
        int compare = comparator.compare(a, b);

        // Geef een boolean terug adhv de vergelijking met de compare, -1 in de compare betekend a < b
        return compare == -1;
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