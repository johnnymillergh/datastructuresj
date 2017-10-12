package com.jm.exp01.generics;

import com.jm.exp01.KeyInput;

public class Main {
    public static void main(String[] args) {
        SequentialList<Integer> sequentialList = new SequentialList();
        System.out.print("Length of sequential list: ");
        int length = KeyInput.readInt();
        Integer tempInteger;
        for (int i = 0; i < length; i++) {
            System.out.print("Element No. " + (i + 1) + ": ");
            tempInteger = KeyInput.readInt();
            sequentialList.add(tempInteger);
        }
        sequentialList.display();
    }
}
