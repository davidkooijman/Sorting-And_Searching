package com.websters.assignments.advancedsorting.sort;

import com.websters.assignments.advancedsorting.model.Student;

import java.util.ArrayList;

@Deprecated
public class QuickSort {

    public static void qsort(ArrayList<Student> arr, int a, int b) {
        if (a < b) {
            int i = a, j = b;

            System.out.println(i + j / 2);

            double x = arr.get(i + j / 2).getGrade();

            do {
                while (Double.compare(arr.get(i).getGrade(), x) < 0) i++;

                while (Double.compare(x, arr.get(j).getGrade()) < 0) j--;

                if (i <= j) {
                    Student tmp = arr.get(i);

                    arr.set(i, arr.get(j));
                    arr.set(j, tmp);
                    i++;
                    j--;
                }

            } while (i <= j);

            qsort(arr, a, j);
            qsort(arr, i, b);
        }
    }
}