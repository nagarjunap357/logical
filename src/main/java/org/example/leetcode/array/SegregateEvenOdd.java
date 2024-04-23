package org.example.leetcode.array;

import java.util.Arrays;

public class SegregateEvenOdd {

//    input: [7, 2, 9, 4, 6, 1, 3, 8, 5]
//    output: [2, 4, 6, 8, 9, 1, 3, 7, 5]

    public static void main(String[] args) {

        int nums[] = {7, 2, 9, 4, 6, 1, 3, 8, 5};
        System.out.println(Arrays.toString(nums));
        seggregateEvenOdd(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void seggregateEvenOdd(int[] nums) {
//		{7, 2, 9, 4, 6, 1, 3, 8, 5}

        int i = -1;

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] % 2 == 0 && i != k) {
                i++;
                swap(nums, i, k);
            }
        }
    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
