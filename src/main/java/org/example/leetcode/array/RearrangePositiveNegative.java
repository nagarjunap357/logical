package org.example.leetcode.array;

import java.util.Arrays;

public class RearrangePositiveNegative {

//    An array contains both positive and negative numbers in random order. Rearrange the array elements so that
//    positive and negative numbers are placed alternatively. A number of positive and negative numbers need not be equal.
//    If there are more positive numbers they appear at the end of the array. If there are more negative numbers,
//    they too appear at the end of the array.
//
//    Example:
//    Input: [-1, 2, -3, 4, 5, 6, -7, 8, 9]
//    Output:[9, -7, 8, -3, 5, -1, 2, 4, 6]
//
//    Input: [-1, 3, -2, -4, 7, -5]
//    Output:[7, -2, 3, -5, -1, -4]

    public static void main(String[] args) {
        int[] arr = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        System.out.println(Arrays.toString(arr));
        rearrange(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void rearrange(int[] arr, int n) {
        // The following few lines are similar to partition
        // process of QuickSort.  The idea is to consider 0
        // as pivot and divide the array around it.
        int i = -1, temp ;
        for (int j = 0; j < n; j++) {
            if (arr[j] < 0) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int pos = i+1, neg = 0;
        System.out.println(Arrays.toString(arr));
        System.out.println("i: "+i);
        // Increment the negative index by 2 and positive index by 1, i.e.,
        // swap every alternate negative number with next positive number
        while (pos < n && neg < pos && arr[neg] < 0)
        {
            temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg += 2;
//            System.out.println(Arrays.toString(arr));
        }
    }
}
