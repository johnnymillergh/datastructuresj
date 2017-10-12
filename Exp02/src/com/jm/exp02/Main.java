package com.jm.exp02;

public class Main {

    public static void main(String[] args) throws Exception {
        LinkedList linkedList = new LinkedList();
        System.out.print("Length of linked list: ");
        int length = KeyInput.readInt();
        Integer integer;
        for (int i = 0; i < length; i++) {
            System.out.print("Node No. " + (i + 1) + ": ");
            integer = KeyInput.readInt();
            linkedList.insertForward(new LinkedListNode(integer));
        }
        System.out.print("Linked list: ");
        linkedList.display();
    }
}
