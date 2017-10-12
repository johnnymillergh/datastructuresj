package com.jm.exp01.generics;

import java.util.ArrayList;

public class SequentialList<ElementType> implements LinearList<ElementType> {
    private ArrayList<ElementType> elementList;

    public SequentialList() {
        this.elementList = new ArrayList<ElementType>();
    }

    @Override
    public void clear() {
        elementList = null;
    }

    @Override
    public boolean isEmpty() {
        return elementList.isEmpty();
    }

    @Override
    public int length() {
        return elementList.size();
    }

    @Override
    public ElementType get(int index) throws Exception {
        return elementList.get(index);
    }

    @Override
    public void add(ElementType element) {
        elementList.add(element);
    }

    @Override
    public void remove(int index) throws Exception {
        elementList.remove(index);
    }

    @Override
    public int indexOf(ElementType object) {
        return elementList.indexOf(object);
    }

    @Override
    public void display() {
        for (int i = 0; i < elementList.size(); i++) {
            System.out.print(elementList.get(i) + " ");
        }
        System.out.println();
    }

}
