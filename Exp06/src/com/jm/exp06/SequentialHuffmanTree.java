package com.jm.exp06;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class SequentialHuffmanTree {
    private Vector<Node> nodes;

    public SequentialHuffmanTree(HashMap<Character, Integer> frequencyList) {
        nodes = new Vector<>();
//        nodes.setSize(2 * frequencyList.size());
        for (Map.Entry<Character, Integer> row : frequencyList.entrySet()) {
            nodes.add(new Node(row.getKey(), row.getValue()));
//            System.out.println("Adding: " + row.getKey() + ", " + row.getValue());
        }
    }

    public SequentialHuffmanTree(int initialCapacity, int capacityIncrement) {
        nodes = new Vector<>(initialCapacity, capacityIncrement);
    }

    public void generate() {
        int index = 1;
        int[] mins = new int[2];
        Node firstMinimumNode, secondMinimumNode;
        while (true) {
            mins = selectMinimumIndexes();
            if (mins[0] == 0) {
                break;
            }
        }
    }

    public int[] selectMinimumIndexes() {
        Node minimumNode = new Node(0, Integer.MAX_VALUE);
        int[] resultIndex = new int[2];
        int index1 = 0, index2 = 0;
        for (int i = 1; i < nodes.size(); i++) {
            Node tempRow = nodes.get(i);
            if (tempRow != null) {
                if (tempRow.weight < minimumNode.weight && tempRow.isSelected == false) {
                    minimumNode = tempRow;
                    index1 = i;
                }
            } else {
                break;
            }
        }
        minimumNode = new Node(0, Integer.MAX_VALUE);
        for (int i = 1; i < nodes.size(); i++) {
            Node tempRow = nodes.get(i);
            if (tempRow != null) {
                if (tempRow.weight < minimumNode.weight && tempRow.isSelected == false) {
                    if (i != index1) {
                        minimumNode = tempRow;
                        index2 = i;
                    }
                }
            } else {
                break;
            }
        }
        resultIndex[0] = index1;
        resultIndex[1] = index2;
        return resultIndex;
    }

    public void display() {
        // display the nodes of the huffman tree, starting from the index: 1.
        try {
            for (int i = 1; i < nodes.size(); i++) {
                Node tempRow = nodes.get(i);
                if (tempRow != null) {
                    System.out.println("Row " + i + ": Data:" + tempRow.data + ", Weight:" + tempRow.weight + ", " +
                            "Parent:" + tempRow.parentIndex + ", Left:" + tempRow.leftChildIndex + ", Right:" + tempRow
                            .rightChildIndex + ", isSelected:" + tempRow.isSelected);
                }
            }
        } catch (Exception e) {
            System.out.println("<END with exception>");
        } finally {
            System.out.println("<END>");
            System.out.println("Length: " + nodes.size());
        }
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

    public class Node {
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
