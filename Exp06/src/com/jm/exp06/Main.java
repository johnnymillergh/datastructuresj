package com.jm.exp06;

import com.jm.exp06.huffmantree.HuffmanDictionary;
import com.jm.exp06.huffmantree.SequentialHuffmanTree;
import com.jm.exp06.io.HuffmanTreeHelper;
import com.jm.exp06.operation.MyEncoder;

public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        // Read file and get the frequency list of the alphabet.
        HuffmanTreeHelper helper = new HuffmanTreeHelper("E:/Semester Project/201702 Fall Semester/01. Data " +
                "Structures and Algorithms/02. Experiment/世界名著txt/Alexandre Dumas/The three musketeers - Copy.txt");
        helper.readFile();
        helper.count();

        // Create Huffman tree by using the frequency list of the alphabet.
        SequentialHuffmanTree huffmanTree = new SequentialHuffmanTree(helper.getFrequencyList());
        huffmanTree.display();
        huffmanTree.generate();
        System.out.println("======================");
        huffmanTree.display();

        // Generate huffman code.
        HuffmanDictionary dictionary = new HuffmanDictionary(huffmanTree.getNodes());
        dictionary.generate();
        dictionary.display();
        dictionary.saveDictionaryObject2File("The three musketeers - Copy.dic");

        // Encode the source file to cipher text.
        MyEncoder myEncoder = new MyEncoder(dictionary, helper);
        myEncoder.encode();
        myEncoder.saveEncodedContent2File("The three musketeers - Copy(encoded_uncompressed).cod");
        myEncoder.displayEncodedContent(0, 20);


        // Display how long the program takes.
        long endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime) * 0.000000001);
//        Byte b = new Byte((byte) 120);
//        System.out.println(bit2byte("1111111"));
//        System.out.println(byte2bits(bit2byte("1111111")));
    }

    public static byte bit2byte(String bString) {
        byte result = 0;
        for (int i = bString.length() - 1, j = 0; i >= 0; i--, j++) {
            result += (Byte.parseByte(bString.charAt(i) + "") * Math.pow(2, j));
        }
        return result;
    }

    public static String byte2bits(byte b) {

        int z = b;
        z |= 256;
        String str = Integer.toBinaryString(z);
        int len = str.length();
        return str.substring(len - 8, len);
    }
}
//        Vector<Integer> vector = new Vector<>();
//        vector.setSize(1);
//        vector.add(1);
//        vector.add(2);
//        vector.add(3);
//        vector.set(0, 10);
//        System.out.println(vector.toString());