package com.jm.exp06.operation;

import com.jm.exp06.huffmantree.HuffmanDictionary;
import com.jm.exp06.huffmantree.SequentialStack;
import com.jm.exp06.io.HuffmanTreeHelper;
import com.jm.exp06.io.MyFileWriter;

import java.util.HashMap;

public class MyEncoder {
    HashMap<Object, String> dictionary;
    String content;
    StringBuffer encodedContent;
    SequentialStack stack;

    public MyEncoder(HuffmanDictionary dictionary, HuffmanTreeHelper helper) {
        this.dictionary = dictionary.getDictionary();
        this.content = helper.getContent();
        stack = new SequentialStack(100);
        encodedContent = new StringBuffer();
    }

    public void encode() {
        char character;
        String code;
        for (int i = 0; i < content.length(); i++) {
            character = content.charAt(i);
            code = dictionary.get(character);
            encodedContent.append(code);
        }
    }

    public void saveEncodedContent2File(String fileName) {
        MyFileWriter writer = new MyFileWriter(fileName, encodedContent.toString());
        writer.write();
    }

    public void displayEncodedContent(int start, int end) {
        System.out.println("Encoded content length: " + encodedContent.length());
        System.out.println("Cypher text (" + start + "-" + end + "): " + encodedContent.substring(start, end));
    }

    public StringBuffer getEncodedContent() {
        return encodedContent;
    }

    public void setEncodedContent(StringBuffer encodedContent) {
        this.encodedContent = encodedContent;
    }
}
