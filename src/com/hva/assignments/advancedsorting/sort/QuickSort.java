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

    // De quicksort heeft een start- en eindpunt nodig. Dit is het begin en einde van de lijst. In de constructor is de
    // comparator aangemaakt om zo de lijst met studenten te gaan sorteren.
    private void quicksort(int low, int high) {
        // Low voor de linkerkant, high voor de rechterkant van de ArrayList
        int i = low, j = high;

        // Kenmerkend voor de quicksort. element midden in de low en high als pivot
        Student pivot = students.get(low + (high-low)/2);

        while (i <= j) {
            // is het linker object van de pivot kleiner dan de pivot, ga dan naar het volgende element in de linker
            // lijst
            while (comparator.compare(students.get(i), pivot) < 0) {
                i++;

                // tel 1 op bij aantal compares voor het berekenen van de Big-O
                counter.addCompare();
            }
            // is het rechter object van de pivot kleiner dan de pivot, ga dan naar het volgende element in de rechter
            // lijst
            while (comparator.compare(students.get(j), pivot) > 0) {
                j--;

                // tel 1 op bij aantal compares voor het berekenen van de Big-O
                counter.addCompare();
            }

            // is er een element gevonden in de linkerlijst die groter dan de pivot is en een element in de rechterlijst
            // die kleiner dan de pivot is, dan wissel (exchange) je deze waardes met elkaar.

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }

        // herhaal links
        if (low < j)
            quicksort(low, j);
        // herhaal rechts
        if (i < high)
            quicksort(i, high);
    }

    //De exchange wisselt de elementen op de indexen i en j
    private void exchange(int i, int j) {
        // sla de student op index i op in een tmp
        Student temp = students.get(i);

        // wissel student op index i om met j. Student i bestaat nu niet meer,  maar hebben we opgeslagen in de temp om
        // nu te verwisselen
        students.set(i, students.get(j));

        // wissel student op index j om met student i in temp
        students.set(j,  temp);

        // Voeg een wissel toe aan de counter voor berekeken van de Big-O
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