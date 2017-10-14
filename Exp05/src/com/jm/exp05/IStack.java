package com.jm.exp05;

public interface IStack<ElementType> {
    public void clear();

    public boolean isEmpty();

    public int length();

    public ElementType peek();

    public void push(ElementType x) throws Exception;

    public ElementType pop() throws Exception;

    public void display();
}
