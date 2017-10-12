package com.jm.exp02;

public class LinkedList implements LinearList<LinkedListNode> {
    private LinkedListNode head;

    public LinkedList() {
        head = new LinkedListNode();
    }

    @Override
    public void clear() {
        head.setNext(null);
    }

    @Override
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    @Override
    public int length() {
        int count = 0;
        LinkedListNode iterator = head.getNext();
        while (iterator != null) {
            iterator = iterator.getNext();
            count++;
        }
        return count;
    }

    @Override
    public LinkedListNode get(int index) throws Exception {
        LinkedListNode iterator = head;
        for (int i = 0; i <= index; i++) {
            iterator = iterator.getNext();
        }
        return iterator;
    }

    @Override
    public void insertForward(LinkedListNode node) {
        node.setNext(head.getNext());
        head.setNext(node);
    }

    @Override
    public void insertBack(LinkedListNode node) {

    }

    @Override
    public void remove(int index) throws Exception {
        if (index < 0 || index > length() - 1) {
            throw new Exception("Error (remove): Illegal operation.");
        }
        LinkedListNode nodeToBeDeleted = get(index);
        LinkedListNode nodeBefore = findBefore(nodeToBeDeleted);
        nodeBefore.setNext(nodeToBeDeleted.getNext());
    }

    public LinkedListNode findBefore(LinkedListNode node) {
        LinkedListNode iterator = head;
        while (iterator.getNext() != node) {
            iterator = iterator.getNext();
        }
        return iterator;
    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public void display() {
        LinkedListNode iterator = head.getNext();
        while (iterator != null) {
            System.out.print(iterator.getData() + " ");
            iterator = iterator.getNext();
        }
        System.out.println("<END>");
    }

    public LinkedListNode getHead() {
        return head;
    }

    public void setHead(LinkedListNode head) {
        this.head = head;
    }
}
