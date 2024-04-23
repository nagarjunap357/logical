package org.example.algo;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr1 = {1,3,7,8};
        int[] arr2 = {2,4,5,6};
//        int[] result = merge(arr1, arr2);
//        System.out.println(Arrays.toString(result));

        int[] arr = {1, 3, 7, 8, 2, 4, 5, 6};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        int[] result = mergeSort(arr);
        System.out.println("After sorting: " + Arrays.toString(result));

    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) return arr;

        int midIndex = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(arr, midIndex, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int index = 0;
        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[index] = arr1[i];
                i++;
                index++;
            } else {
                result[index] = arr2[j];
                j++;
                index++;
            }
        }

        while (i < arr1.length) {
            result[index] = arr1[i];
            i++;
            index++;
        }

        while (j < arr2.length) {
            result[index] = arr2[j];
            j++;
            index++;
        }

        return result;
    }
}
