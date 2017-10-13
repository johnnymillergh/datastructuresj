package com.jm.exp04;

public class Main {

    public static void main(String[] args) {
        SequentialStack sequentialStack = new SequentialStack(100);
        Character dataInput;
        while (true) {
            System.out.print("Data: ");
            dataInput = KeyInput.readChar();
            if (dataInput.charValue() != '#') {
                try {
                    sequentialStack.push(dataInput);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }
        while (true) {
            dataInput = KeyInput.readChar();
            if (dataInput.charValue() == '1') {
                try {
                    System.out.println("Pop: " + sequentialStack.pop());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sequentialStack.display();
            } else {
                break;
            }
        }
    }
}
