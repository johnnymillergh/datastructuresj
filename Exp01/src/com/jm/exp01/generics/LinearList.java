package com.jm.exp01.generics;

public interface LinearList<ElementType> {
    public void clear();

    public boolean isEmpty();

    public int length();

    public ElementType get(int index) throws Exception;

    public void add(ElementType object) throws Exception;

    public void remove(int index) throws Exception;

    public int indexOf(ElementType object);

    public void display();
}
