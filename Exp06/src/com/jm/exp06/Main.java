package com.jm.exp06;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        HuffmanTreeHelper helper = new HuffmanTreeHelper("E:/Semester Project/201702 Fall Semester/01. Data " +
                "Structures and Algorithms/02. Experiment/世界名著txt/Alexandre Dumas/The three musketeers.txt");
        helper.readFile();
        helper.count();
        long endTime = System.nanoTime();
        System.out.println("Time： " + (endTime - startTime) + " ns");
        System.out.println(helper.frequencyList.toString());
    }
}
