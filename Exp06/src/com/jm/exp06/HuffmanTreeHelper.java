package com.jm.exp06;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class HuffmanTreeHelper {

    public static String readFile(String fileName) {
        String content = null;
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
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
        return content;
    }

}
