package com.jm.exp05;

import sun.reflect.generics.tree.Tree;

import java.util.Vector;

public class SequentialBinaryTree {
    private Vector<TreeNode> treeNodes;

    public SequentialBinaryTree(int initialCapacity, int capacityIncrement) {
        treeNodes = new Vector<>(initialCapacity, capacityIncrement);
    }

    public SequentialBinaryTree(String treeString, int initialCapacity, int capacityIncrement) {
        treeNodes = new Vector<>(initialCapacity, capacityIncrement);
        for (int i = 0; i < treeString.length(); i++) {
            Character character = treeString.charAt(i);
            treeNodes.addElement(new TreeNode(character));
        }
    }

    public void init() {
        Character dataInput;
        while (true) {
            dataInput = KeyInput.readChar();
            if (dataInput.charValue() != '#') {
                treeNodes.addElement(new TreeNode(dataInput));
            } else {
                break;
            }
        }
    }

    public void display() {
        for (int i = 0; i < treeNodes.size(); i++) {
            System.out.print(treeNodes.get(i).getData() + " ");
        }
        System.out.println("<END>");
    }

    public void iterativePreorderTraverse() throws Exception {
        if (this.getRootNode() == null) {
            return;
        }
        SequentialStack stack = new SequentialStack(100);
        stack.push(this.getRootNode());
        int indexRoot = 0;
        while (!stack.isEmpty()) {
            TreeNode currentRootNode = (TreeNode) stack.pop();
            visit(currentRootNode);
            // Right child is pushed first so that left is processed first
            int currentIndexOfRightChild = getIndexOfRightChildOf(currentRootNode);
            int currentIndexOfLeftChild = getIndexOfLeftChildOf(currentRootNode);
            TreeNode currentRightChild;
            TreeNode currentLeftChild;
            if (currentIndexOfRightChild > 0) {
                currentRightChild = treeNodes.get(currentIndexOfRightChild);
                if (currentRightChild != null) {
                    stack.push(currentRightChild);
                }
            }
            if (currentIndexOfLeftChild > 0) {
                currentLeftChild = treeNodes.get(currentIndexOfLeftChild);
                if (currentLeftChild != null) {
                    stack.push(currentLeftChild);
                }
            }
        }
        System.out.println("<END>");
    }

    private void visit(TreeNode node) {
        System.out.print(node.getData() + " ");
    }

    private int getIndexOfLeftChildOf(TreeNode currentRootNode) {
        int indexRoot = indexOf(currentRootNode);
        int indexLeft = indexRoot * 2 + 1;
        if (indexLeft < treeNodes.size()) {
            return indexLeft;
        } else {
            return -1;
        }
    }

    private int getIndexOfRightChildOf(TreeNode currentRootNode) {
        int indexRoot = indexOf(currentRootNode);
        int indexRight = indexRoot * 2 + 2;
        if (indexRight < treeNodes.size()) {
            return indexRight;
        } else {
            return -1;
        }
    }

    private int indexOf(TreeNode node) {
        return treeNodes.indexOf(node);
    }

    public boolean isEmpty() {
        return treeNodes.get(0) == null;
    }

    public TreeNode getRootNode() {
        if (!this.isEmpty()) {
            return treeNodes.get(0);
        } else {
            return null;
        }
    }

    public Vector<TreeNode> getTreeNodes() {
        return treeNodes;
    }

    private class TreeNode {
        private Object data;

        public TreeNode(Object data) {
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
