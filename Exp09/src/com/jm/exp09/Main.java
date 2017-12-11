package com.jm.exp09;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("<Exp09-01>");
        int[] data1 = {49, 38, 65, 97, 76, 13, 27, 30, 31};
        MergeSort mergeSort = new MergeSort(data1);
        mergeSort.display();
        mergeSort.sort();
        mergeSort.display();

        System.out.println("<Exp09-02>");
        System.out.println("e.g. {Mode=Multiplicity}");
        int[] data2 = {1, 2, 2, 7, 2, 7, 5};
        MultiplicityMode multiplicityMode = new MultiplicityMode(data2);
        multiplicityMode.calculateMultiplicity();
        System.out.print("Result: ");
        multiplicityMode.displayResultSet();
    }
}
