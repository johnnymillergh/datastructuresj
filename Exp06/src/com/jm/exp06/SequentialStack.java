package com.jm.exp06;

public class SequentialStack implements IStack<Object> {
    private Object[] stackElement;
    private int top;

    public SequentialStack(int maxSize) {
        stackElement = new Object[maxSize];
        top = 0;
    }

    @Override
    public void clear() {
        top = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int length() {
        return top;
    }

    @Override
    public Object peek() {
        return stackElement[top - 1];
    }

    @Override
    public void push(Object element) throws Exception {
        if (length() != stackElement.length) {
            stackElement[top] = element;
            top++;
        } else {
            throw new Exception("Error(push): Stack is full.");
        }
    }

    @Override
    public Object pop() throws Exception {
        if (!isEmpty()) {
            top--;
            return stackElement[top];
        } else {
            throw new Exception("Warning(pop): Stack is empty.");
        }
    }

    @Override
    public void display() {
        if (stackElement != null) {
            for (int i = top - 1; i >= 0; i--) {
                System.out.print(stackElement[i] + " ");
            }
            System.out.println("|");
        }
    }
}
