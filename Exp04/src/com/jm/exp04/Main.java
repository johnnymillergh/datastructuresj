package com.jm.exp04;

public class Main {

    public static void main(String[] args) throws Exception {
        SequentialStack sequentialStack = new SequentialStack(100);
        Character dataInput;
        while (true) {
            System.out.print("Data: ");
            dataInput = KeyInput.readChar();
            if (dataInput.charValue() != '#') {
                sequentialStack.push(dataInput);
            } else {
                break;
            }
        }
        while (true) {
            dataInput = KeyInput.readChar();
            if (dataInput.charValue() == '1') {
                System.out.println("Pop: " + sequentialStack.pop());
                sequentialStack.display();
            } else {
                break;
            }
        }
    }
}
