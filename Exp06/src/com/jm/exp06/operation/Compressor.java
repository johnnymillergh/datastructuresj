package com.jm.exp06.operation;

public class Compressor {
    static final String[] hexStr = {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"
    };

    public static String binStringToHexadeimal(String binary) {
        // 这里还可以做些判断，比如传进来的数字是否都是0和1
//        System.out.println(binary);
        int length = binary.length();
        int temp = length % 4;
        // 每四位2进制数字对应一位16进制数字
        // 补足4位
        if (temp != 0) {
            for (int i = 0; i < 4 - temp; i++) {
                binary = "0" + binary;
            }
        }
        // 重新计算长度
        length = binary.length();
        StringBuilder sb = new StringBuilder();
        // 每4个二进制数为一组进行计算
        for (int i = 0; i < length / 4; i++) {
            int num = 0;
            // 将4个二进制数转成整数
            for (int j = i * 4; j < i * 4 + 4; j++) {
                num <<= 1;// 左移
                num |= (binary.charAt(j) - '0');// 或运算
            }
            // 直接找到该整数对应的16进制，这里不用switch来做
            sb.append(hexStr[num]);
            // 这里如果要用switch case来做，大概是这个样子
            // switch(num){
            // case 0:
            // sb.append('0');
            // break;
            // case 1:
            // ...
            // case 15:
            // sb.append('F');
            // break;
            // }
        }
        return sb.toString();
    }
}
