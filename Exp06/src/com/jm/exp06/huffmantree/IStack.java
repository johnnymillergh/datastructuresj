package com.jm.exp06.huffmantree;

public interface IStack<ElementType> {
    public void clear();

    public boolean isEmpty();

    public int length();

    public ElementType peek();

    public void push(ElementType x) throws Exception;

    public ElementType pop() throws Exception;

    public void display();
}
