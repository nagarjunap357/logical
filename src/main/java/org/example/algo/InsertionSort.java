package org.example.algo;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 1, 3};
        System.out.println("Before sorting: " + Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j > -1 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}
