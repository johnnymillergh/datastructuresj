package com.jm.exp02;

public class LinkedListNode {
    private Object data;
    private LinkedListNode next;

    public LinkedListNode() {
    }

    public LinkedListNode(Object data) {
        this.data = data;
    }

    public LinkedListNode(Object data, LinkedListNode next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}
