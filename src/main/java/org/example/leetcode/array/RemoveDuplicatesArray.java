package org.example.leetcode.array;

import java.util.Arrays;

public class RemoveDuplicatesArray {

//    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that
//    each unique element appears only once. The relative order of the elements should be kept the same.
//    Then return the number of unique elements in nums.
//    Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
//    Change the array nums such that the first k elements of nums contain the unique elements
//    in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
//    Return k.

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 4, 5, 6};
        System.out.println(Arrays.toString(nums));
        removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
    }
}
