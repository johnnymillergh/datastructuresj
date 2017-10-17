package com.jm.exp06;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HuffmanTreeHelper helper = new HuffmanTreeHelper("E:/Semester Project/201702 Fall Semester/01. Data " +
                "Structures and Algorithms/02. Experiment/世界名著txt/Alexandre Dumas/The three musketeers.txt");
        HashMap<Character, Integer> list = new HashMap<>();
        list.put(new Character('a'), new Integer(1));
        list.put(new Character('a'), new Integer(2));
        list.put(new Character('a'), new Integer(3));
        Character a = 'a';
        System.out.println(list.get(a));
        System.out.println(list.size());
    }
}
