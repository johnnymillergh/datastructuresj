package com.jm.exp09;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("<Exp09-01>");
        int[] data = {49, 38, 65, 97, 76, 13, 27, 30, 31};
        MergeSort mergeSort = new MergeSort(data);
        mergeSort.display();
        mergeSort.sort();
        mergeSort.display();
    }
}
