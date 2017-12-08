package com.jm.exp06;

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
        System.out.println(huffmanTree.selectMinimumIndex());
        huffmanTree.display();
        huffmanTree.generate();
//        SequentialHuffmanTree.Node node = huffmanTree.getNodes().get(2);
//        node.isSelected = true;
        huffmanTree.display();
    }
}
