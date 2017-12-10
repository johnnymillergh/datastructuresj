package com.jm.exp09;

public class MergeSort {
    private int[] data;
    int[] workArray;

    public MergeSort(int[] data) {
        this.data = data;
        workArray = new int[data.length];
    }

    public void sort() {
        int iBegin = 0, iEnd = data.length;
        topDownMergeSort(data, workArray, iBegin, iEnd);
    }

    private void topDownMergeSort(int[] sourceArray, int[] workArray, int iBegin, int iEnd) {
        copyArray(sourceArray, iBegin, iEnd, workArray);
        topDownSplitMerge(workArray, iBegin, iEnd, sourceArray);
    }

    private void topDownSplitMerge(int[] workArray, int iBegin, int iEnd, int[] sourceArray) {
        if (iEnd - iBegin < 2) {
            return;
        }
        int iMiddle = (int) Math.floor((iBegin + iEnd) / 2);
        topDownSplitMerge(sourceArray, iBegin, iMiddle, workArray);
        topDownSplitMerge(sourceArray, iMiddle, iEnd, workArray);
        topDownMerge(workArray, iBegin, iMiddle, iEnd, sourceArray);
    }

    private void topDownMerge(int[] sourceArray, int iBegin, int iMiddle, int iEnd, int[] workArray) {
        int i = iBegin, j = iMiddle;
        for (int k = iBegin; k < iEnd; k++) {
            if (i < iMiddle && (j >= iEnd || sourceArray[i] <= sourceArray[j])) {
                workArray[k] = sourceArray[i];
                i++;
            } else {
                workArray[k] = sourceArray[j];
                j++;
            }
        }
    }

    private void copyArray(int[] sourceArray, int iBegin, int iEnd, int[] workArray) {
        for (int i = iBegin; i < iEnd; i++) {
            workArray[i] = sourceArray[i];
        }
    }

    public void display() {
        System.out.print("Data: ");
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
