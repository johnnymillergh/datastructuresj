package com.jm.exp06.huffmantree;

import com.jm.exp06.io.MyFileWriter;

import java.util.HashMap;
import java.util.Vector;

public class HuffmanDictionary {
    HashMap<Object, String> dictionary;
    private Vector<SequentialHuffmanTree.Node> nodes;
    SequentialStack stack;
    StringBuffer codeOfSingleCharacter;

    public HuffmanDictionary(Vector<SequentialHuffmanTree.Node> nodes) {
        this.nodes = nodes;
        dictionary = new HashMap<>();
        stack = new SequentialStack(100);
        codeOfSingleCharacter = new StringBuffer();
    }

    public HuffmanDictionary(HashMap<Object, String> dictionary) {
        this.dictionary = dictionary;
    }

    @SuppressWarnings("Duplicates")
    public void generate() {
        SequentialHuffmanTree.Node tempNode;
        int childIndex;
        int parentIndex;

        for (int i = 1; i < nodes.size(); i++) {
            tempNode = nodes.get(i);
            if (tempNode.data != null) {
                childIndex = i;
                while (true) {
                    parentIndex = tempNode.getParentIndex();
                    if (parentIndex != 0) {
                        tempNode = nodes.get(parentIndex);
                        if (childIndex == tempNode.getLeftChildIndex()) {
                            try {
                                stack.push(new Integer(0));
                                childIndex = parentIndex;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else if (childIndex == tempNode.getRightChildIndex()) {
                            try {
                                stack.push(new Integer(1));
                                childIndex = parentIndex;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (parentIndex == 0) {
                        tempNode = nodes.get(nodes.size() - 1);
                        if (childIndex == tempNode.getLeftChildIndex()) try {
                            stack.push(new Integer(0));
                            childIndex = parentIndex;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        else if (childIndex == tempNode.getRightChildIndex()) {
                            try {
                                stack.push(new Integer(1));
                                childIndex = parentIndex;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    }
                }
                // Get reversed code by popping stack.
                while (true) {
                    if (!stack.isEmpty()) {
                        try {
                            codeOfSingleCharacter.append(stack.pop());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        break;
                    }
                }

                // Add to dictionary.
                dictionary.put(nodes.get(i).data, codeOfSingleCharacter.toString());
                codeOfSingleCharacter = new StringBuffer();
            } else {
                break;
            }
        }
    }

    public void save() {
        MyFileWriter writer = new MyFileWriter("The three musketeers.dic");
        writer.write(dictionary);
    }

    public void display() {
        System.out.println(dictionary.toString());
    }

    public HashMap<Object, String> getDictionary() {
        return dictionary;
    }
}
