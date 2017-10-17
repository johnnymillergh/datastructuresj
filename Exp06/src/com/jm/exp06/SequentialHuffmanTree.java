package com.jm.exp06;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class SequentialHuffmanTree {
    private Vector<Node> nodes;

    public SequentialHuffmanTree(int sizeOfFrequencyList) {
        nodes = new Vector<>();
        nodes.setSize(2 * sizeOfFrequencyList);
        System.out.println(nodes.size());
    }

    public SequentialHuffmanTree(int initialCapacity, int capacityIncrement) {
        nodes = new Vector<>(initialCapacity, capacityIncrement);
    }

    public void init(HashMap<Character, Integer> frequencyList) {
        int index = 1;
        nodes.add(0, new Node());
        for (Map.Entry<Character, Integer> row : frequencyList.entrySet()) {
            nodes.add(index, new Node(row.getKey(), row.getValue()));
            index++;
        }
        for (int i = nodes.size() / 2; i < nodes.size(); i++) {
            Node firstMinNode = select(), secondMinNode = select();

        }

    }

    private Node select() {
        Node min = nodes.get(1);
        for (int i = 1; i < nodes.size(); i++) {
            if (nodes.get(i) == null) {
                break;
            }
            if (nodes.get(i).weight < min.weight && nodes.get(i).isSelected != true) {
                min = nodes.get(i);
            }
        }
        min.isSelected = true;
        return min;
    }

    public void display() {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) == null) {
                break;
            }
            System.out.println("Row " + i + ": Data:" + nodes.get(i).data + ", Weight:" + nodes.get(i).weight + ", "
                    + "Parent:" + nodes.get(i).parentIndex + ", Left:" + nodes.get(i).leftChildIndex + ", Right:" +
                    nodes.get(i).rightChildIndex);
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
        System.out.print(node.data + " ");
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
        Object data;
        int weight;
        int parentIndex;
        int leftChildIndex;
        int rightChildIndex;
        boolean isSelected;

        public Node() {

        }

        public Node(Object data) {
            this.data = data;
        }

        public Node(Object data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        public Node(int weight, int parentIndex, int leftChildIndex, int rightChildIndex) {
            this.weight = weight;
            this.parentIndex = parentIndex;
            this.leftChildIndex = leftChildIndex;
            this.rightChildIndex = rightChildIndex;
        }
    }
}
