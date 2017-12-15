package com.jm.exp06.io;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.HashMap;

public class HuffmanTreeHelper {
    private String filePath;
    private String content;
    private HashMap<Character, Integer> frequencyList;

    public HuffmanTreeHelper(String filePath) {
        if (filePath != null) {
            this.filePath = filePath;
            frequencyList = new HashMap<>();
        }
    }

    public void readFile() {
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            byte[] bytes = new byte[1024];
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
            while (inputStream.read(bytes) != -1) {
                arrayOutputStream.write(bytes, 0, bytes.length);
            }
            inputStream.close();
            arrayOutputStream.close();
            content = new String(arrayOutputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void count() {
        Character tempCharacter;
        System.out.println("Text file has " + content.length() + " characters.");
        for (int i = 0; i < content.length(); i++) {
            tempCharacter = content.charAt(i);
            if (frequencyList.get(tempCharacter) == null) {
                frequencyList.put(tempCharacter, new Integer(1));
            } else {
                Integer frequency = frequencyList.remove(tempCharacter);
                frequency++;
                frequencyList.put(tempCharacter, frequency);
            }
        }
    }

    public HashMap<Character, Integer> getFrequencyList() {
        return frequencyList;
    }

    public String getContent() {
        return content;
    }
}
