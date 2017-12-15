package com.jm.exp06.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class MyFileReader {
    String fineName;

    public MyFileReader(String fineName) {
        this.fineName = fineName;
    }

    public Object readDictionaryFile2Object() {
        FileInputStream fileInputStream;
        Object o;
        try {
            fileInputStream = new FileInputStream("C:/Users/Johnny/Desktop/" + fineName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            o = objectInputStream.readObject();
            return o;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
