package com.jm.exp06;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {
//        long startTime = System.nanoTime();
//        long endTime = System.nanoTime();

        // Read file and get the frequency list of the alphabet.
        HuffmanTreeHelper helper = new HuffmanTreeHelper("E:/Semester Project/201702 Fall Semester/01. Data " +
                "Structures and Algorithms/02. Experiment/世界名著txt/Alexandre Dumas/The three musketeers.txt");
        helper.readFile();
        helper.count();

        // Create Huffman tree by using the frequency list of the alphabet.
        SequentialHuffmanTree huffmanTree = new SequentialHuffmanTree(helper.getFrequencyList());
        huffmanTree.display();
        huffmanTree.generate();
        System.out.println("======================");
        huffmanTree.display();
//        Vector<Integer> vector = new Vector<>();
//        vector.setSize(1);
//        vector.add(1);
//        vector.add(2);
//        vector.add(3);
//        vector.set(0, 10);
//        System.out.println(vector.toString());
    }
}
