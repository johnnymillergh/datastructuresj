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
        System.out.println(helper.getFrequencyList().toString());
        SequentialHuffmanTree huffmanTree = new SequentialHuffmanTree(helper.getFrequencyList().size());
        huffmanTree.init(helper.getFrequencyList());
        huffmanTree.display();
        System.out.println("11111");
        System.out.println("\\r");
        System.out.println("00000");
        System.out.println("\\n");
    }
}
