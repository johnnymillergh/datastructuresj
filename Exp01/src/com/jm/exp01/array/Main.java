package com.jm.exp01.array;

import com.jm.exp01.KeyInput;

public class Main {
    public static void main(String[] args) throws Exception {
        SequentialList sequentialList = new SequentialList(100);
        System.out.print("Length of sequential list: ");
        int length = KeyInput.readInt();
        Character integer;
        for (int i = 0; i < length; i++) {
            System.out.print("Element No. " + (i + 1) + ": ");
            integer = KeyInput.readChar();
            sequentialList.add(integer);
        }
        System.out.print("Sequential list: ");
        sequentialList.display();
    }
}
