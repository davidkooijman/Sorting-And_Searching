package com.websters.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import com.websters.assignments.advancedsorting.Student;

public class Main {

    private static Random r = new Random();

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        int id = 500600001;
        for (int i = 0; i < 10000; i++) {
            list.add(new Student(id++, ((r.nextInt(10)+1))));
        }
        Collections.shuffle(list);
        print(list);
    }

    private static void print(ArrayList list){
        for (Object s : list) {
            System.out.println(s);
        }
    }
}
