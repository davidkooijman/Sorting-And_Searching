package com.hva.assignments.advancedsorting.sort.v2;


import com.hva.analytics.RunTimer;
import com.hva.assignments.advancedsorting.model.Student;
import com.hva.analytics.Counter;

import java.util.ArrayList;
import java.util.Comparator;

public class QuickSortV2 {

    private ArrayList<Student> students;
    private Comparator<Student> comparator;

    private static RunTimer runTimer;
    private static Counter counter;

    public void sort(ArrayList<Student> students, Comparator<Student> comparer) {

        if (students ==null || students.size()==0){
            return;
        }

        runTimer = new RunTimer();
        counter = new Counter();

        runTimer.startTimer();

        this.students = students;
        this.comparator = comparer;
        int number = students.size();
        quicksort(0, number - 1);

        runTimer.endTimer();
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        Student pivot = median(low, high);

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

    public Student median(int left, int right) {
        int center = (left + right) / 2;

        // order left & center
        if (comparator.compare(students.get(left), students.get(center)) > 0)
            exchange(left, center);
        // order left & right
        if (comparator.compare(students.get(left), students.get(right)) > 0)
            exchange(left, right);
        // order center & right
        if (comparator.compare(students.get(center), students.get(right)) > 0)
            exchange(center, right);

        exchange(center, right - 1);
        return students.get(right - 1);
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
        System.out.println(runTimer.getRunTime());
    }
}