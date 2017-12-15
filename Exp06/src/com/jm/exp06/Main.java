package com.jm.exp06;

import com.jm.exp06.huffmantree.SequentialHuffmanTree;
import com.jm.exp06.io.HuffmanTreeHelper;
import com.jm.exp06.io.MyFileWriter;
import com.jm.exp06.operation.Encoder;

public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        // Read file and get the frequency list of the alphabet.
        HuffmanTreeHelper helper = new HuffmanTreeHelper("E:/Semester Project/201702 Fall Semester/01. Data " +
                "Structures and Algorithms/02. Experiment/世界名著txt/Alexandre Dumas/The three musketeers.txt");
        helper.readFile();
        helper.count();

        // Create Huffman tree by using the frequency list of the alphabet.
        SequentialHuffmanTree huffmanTree = new SequentialHuffmanTree(helper.getFrequencyList());
        huffmanTree.display();
        huffmanTree.generateTree();
        System.out.println("======================");
        huffmanTree.display();

        // Generate huffman code.
        Encoder encoder = new Encoder(huffmanTree, helper);
        encoder.encode();
        encoder.displayEncodedContent();

        // Write uncompressed huffman code to file.
        MyFileWriter writer = new MyFileWriter("The three musketeers (encoded_uncompressed).cod", encoder
                .getEncodedContent());
        writer.write();

        // Display how long the program takes.
        long endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime) * 0.000000001);
    }
}
//        Vector<Integer> vector = new Vector<>();
//        vector.setSize(1);
//        vector.add(1);
//        vector.add(2);
//        vector.add(3);
//        vector.set(0, 10);
//        System.out.println(vector.toString());