package com.jm.exp09;

import java.util.HashMap;
import java.util.Map;

public class MultiplicityMode {
    private int[] data;
    private HashMap<Integer, Integer> resultSet;
    private int largest;

    public MultiplicityMode(int[] data) {
        this.data = data;
        resultSet = new HashMap<>();
    }

    public void calculateMultiplicity() {
        sort(data);
        recursiveMultiplicity(data, 0, data.length - 1);
    }

    private void recursiveMultiplicity(int[] data, int leftIndex, int rightIndex) {
        int median, middleIndex, lIndex, rIndex, currentLargest;
        if (rightIndex - leftIndex + 1 >= largest) {
            middleIndex = (int) Math.floor((leftIndex + rightIndex) / 2);
            median = data[middleIndex];
            lIndex = rIndex = middleIndex;
            while (true) {
                if ((lIndex - 1) >= 0 && median == data[lIndex - 1]) {
                    lIndex--;
                } else {
                    break;
                }
            }
            while (true) {
                if ((rIndex + 1) < data.length && median == data[rIndex + 1]) {
                    rIndex++;
                } else {
                    break;
                }
            }
            currentLargest = rIndex - lIndex + 1;
            if (currentLargest > largest) {
                largest = currentLargest;
                if (resultSet.isEmpty()) {
                    resultSet.put(median, largest);
                } else {
                    for (Map.Entry<Integer, Integer> i : resultSet.entrySet()) {
                        if (i.getValue() < largest) {
                            resultSet.clear();
                            resultSet.put(median, largest);
                            break;
                        }
                    }
                }
            }
            recursiveMultiplicity(data, leftIndex, lIndex - 1);
            recursiveMultiplicity(data, rIndex + 1, rightIndex);
        }

    }

    private void sort(int[] data) {
        MergeSort mergeSort = new MergeSort(data);
        mergeSort.sort();
    }

    public void calculateMode() {

    }

    public void displayResultSet() {
        System.out.println(resultSet.toString());
    }
}
