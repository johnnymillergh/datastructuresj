package com.jm.exp06.operation;

import com.jm.exp06.huffmantree.HuffmanDictionary;
import com.jm.exp06.huffmantree.SequentialStack;
import com.jm.exp06.io.HuffmanTreeHelper;

import java.util.HashMap;
import java.util.Map;

public class MyDecoder {
    HashMap<Object, String> dictionary;
    String encodedContent;
    StringBuffer content;
    SequentialStack stack;

    public MyDecoder(HuffmanDictionary dictionary, HuffmanTreeHelper helper) {
        this.dictionary = dictionary.getDictionary();
        this.encodedContent = helper.getContent();
        content = new StringBuffer();
        stack = new SequentialStack(100);
    }

    public void decode() {
        StringBuffer encodedCharacters = new StringBuffer();
        String huffmanCodeOfSingleCharacter;
        for (int i = 0; i < encodedContent.length(); i++) {
            encodedCharacters.append(encodedContent.charAt(i));
            if (dictionary.containsValue(encodedCharacters.toString()) == true) {
                for (Map.Entry<Object, String> entry : dictionary.entrySet()) {
                    huffmanCodeOfSingleCharacter = entry.getValue();
                    if (huffmanCodeOfSingleCharacter.compareTo(encodedCharacters.toString()) == 0) {
                        content.append(entry.getKey());
                        encodedCharacters = new StringBuffer();
                    }
                }
            }
        }
    }

    public void displayDecodedContent(int start, int end) {
        System.out.println("Decoded content length: " + content.length());
        System.out.println("Plain text (" + start + "-" + end + "): " + content.substring(start, end));
    }
}
