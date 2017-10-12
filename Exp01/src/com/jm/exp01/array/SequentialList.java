package com.jm.exp01.array;

public class SequentialList implements LinearList<Object> {

    private Object[] elementList;
    private int currentLength;

    public SequentialList(int maxSize) {
        currentLength = 0;
        elementList = new Object[maxSize];
    }

    public void bubbleSort(){

    }

    public void insert(Object element) {

    }
    @Override
    public void clear() {
        currentLength = 0;
        elementList = null;
    }

    @Override
    public boolean isEmpty() {
        return currentLength == 0;
    }

    @Override
    public int length() {
        return currentLength;
    }

    @Override
    public Object get(int index) throws Exception {
        if (index < 0 || index > currentLength - 1) {
            throw new Exception("Element No. " + index + " doesn't exist.");
        }
        return elementList[index];
    }

    @Override
    public void add(Object element) throws Exception {
        if (currentLength == elementList.length) {
            throw new Exception("Sequential list has been full.");
        }
        elementList[currentLength] = element;
        currentLength++;
    }

    @Override
    public void remove(int index) throws Exception {
        if (index < 0 || index > currentLength - 1) {
            throw new Exception("Error (remove): Illegal operation.");
        }
        for (int i = index; i < currentLength - 1; i++) {
            elementList[index] = elementList[index + 1];
        }
        currentLength--;
    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int getMaxSize() {
        return elementList.length;
    }

    @Override
    public void display() {
        for (int i = 0; i < currentLength; i++) {
            System.out.print(elementList[i] + " ");
        }
        System.out.println();
    }

}
