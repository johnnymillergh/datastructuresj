package com.jm.exp02;

public interface LinearList<LinkedListNodeType> {
    public void clear();

    public boolean isEmpty();

    public int length();

    public LinkedListNodeType get(int index) throws Exception;

    public void insertForward(LinkedListNodeType node);

    public void insertBack(LinkedListNodeType node);

    public void remove(int index) throws Exception;

    public int indexOf(Object object);

    public void display();
}
