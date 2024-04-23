package org.example.leetcode.array;

import java.lang.reflect.Array;
import java.util.*;

public class ThreeSum {
//    15. 3Sum
//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
// and j != k, and nums[i] + nums[j] + nums[k] == 0.
//   Notice that the solution set must not contain duplicate triplets.
//    Example 1:
//    Input: nums = [-1,0,1,2,-1,-4]
//    Output: [[-1,-1,2],[-1,0,1]]
//    Example 2:
//    Input: nums = [0,1,1]
//    Output: []
//    Example 3:
//    Input: nums = [0,0,0]
//    Output: [[0,0,0]]

    public static void main(String[] args) {
        int[] arr1 = {-1, 0, 1, 2, -1, -4};
        int[] arr2 = {0, 1, 1};
        int[] arr3 = {0, 0, 0};

        System.out.println(threeSum(arr1, 0));
    }

    public static List<List<Integer>> threeSum(int[] arr, int target) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {

                int sum = arr[i] + arr[j] + arr[k];
                if (sum == target) {
                    set.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
