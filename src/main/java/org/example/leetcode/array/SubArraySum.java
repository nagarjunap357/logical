package org.example.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

public class SubArraySum {
//    Given an array arr[] of non-negative integers and an integer sum, find a subArray that adds to a given sum.
//    Note: There may be more than one subArray with sum as the given sum, print first such subArray.

    public static void main(String[] args) {
        int[] arr = {1, 23, 6, 4, 8, 5, 10};
        int targetSum = 10;
        int[] subArray = findSubArraySum(arr, targetSum);
        System.out.println(Arrays.toString(subArray));
    }

    static int[] findSubArraySum(int[] nums, int k) {
        int[] result = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(0,1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                result[0] = map.get(sum-k)+1;
                result[1] = i;
                return result;
            }

            map.put(sum, i);
        }

        return result;
    }
}
