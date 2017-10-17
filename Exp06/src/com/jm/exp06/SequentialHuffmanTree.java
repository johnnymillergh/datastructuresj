package com.jm.exp06;

import java.util.Vector;

public class SequentialHuffmanTree {
    private Vector<Node> nodes;

    public SequentialHuffmanTree(int size) {
        nodes = new Vector<>();
        nodes.setSize(2 * size);
    }

    public SequentialHuffmanTree(int initialCapacity, int capacityIncrement) {
        nodes = new Vector<>(initialCapacity, capacityIncrement);
    }

    public SequentialHuffmanTree(String treeString, int initialCapacity, int capacityIncrement) {
        nodes = new Vector<>(initialCapacity, capacityIncrement);
        for (int i = 0; i < treeString.length(); i++) {
            Character character = treeString.charAt(i);
            nodes.addElement(new Node(character));
        }
    }

    public void init() {
        Character dataInput;
        while (true) {
            dataInput = KeyInput.readChar();
            if (dataInput.charValue() != '#') {
                nodes.addElement(new Node(dataInput));
            } else {
                break;
            }
        }
    }

    public void display() {
        for (int i = 0; i < nodes.size(); i++) {
            System.out.print(nodes.get(i).getData() + " ");
        }
        System.out.println("<END>");
    }

    public void iterativePreorderTraverse() throws Exception {
        if (this.getRootNode() == null) {
            return;
        }
        SequentialStack stack = new SequentialStack(100);
        stack.push(this.getRootNode());
        while (!stack.isEmpty()) {
            Node currentRootNode = (Node) stack.pop();
            visit(currentRootNode);
            // Right child is pushed first so that left is processed first
            int currentIndexOfRightChild = getIndexOfRightChildOf(currentRootNode);
            int currentIndexOfLeftChild = getIndexOfLeftChildOf(currentRootNode);
            Node currentRightChild;
            Node currentLeftChild;
            if (currentIndexOfRightChild > 0) {
                currentRightChild = nodes.get(currentIndexOfRightChild);
                if (currentRightChild != null) {
                    stack.push(currentRightChild);
                }
            }
            if (currentIndexOfLeftChild > 0) {
                currentLeftChild = nodes.get(currentIndexOfLeftChild);
                if (currentLeftChild != null) {
                    stack.push(currentLeftChild);
                }
            }
        }
        System.out.println("<END>");
    }

    private void visit(Node node) {
        System.out.print(node.getData() + " ");
    }

    private int getIndexOfLeftChildOf(Node currentRootNode) {
        int indexRoot = indexOf(currentRootNode);
        int indexLeft = indexRoot * 2 + 1;
        if (indexLeft < nodes.size()) {
            return indexLeft;
        } else {
            return -1;
        }
    }

    private int getIndexOfRightChildOf(Node currentRootNode) {
        int indexRoot = indexOf(currentRootNode);
        int indexRight = indexRoot * 2 + 2;
        if (indexRight < nodes.size()) {
            return indexRight;
        } else {
            return -1;
        }
    }

    private int indexOf(Node node) {
        return nodes.indexOf(node);
    }

    public boolean isEmpty() {
        return nodes.get(0) == null;
    }

    public Node getRootNode() {
        if (!this.isEmpty()) {
            return nodes.get(0);
        } else {
            return null;
        }
    }

    public Vector<Node> getNodes() {
        return nodes;
    }

    private class Node {
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}
