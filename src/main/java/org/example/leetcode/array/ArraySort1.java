package org.example.leetcode.array;

import java.util.Arrays;

public class ArraySort1 {

//    Sort an array which contain 1 to n values

    public static void main(String[] args) {
        int[] nums = {10, 7, 9, 2, 8, 3, 5, 4, 6, 1};
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));

    }
    static void sort(int[] nums){

        for(int i=0;i<nums.length;){
            int temp = nums[i]-1;
            if(nums[temp] != nums[i]){
                swap(nums, temp, i);
            }
            else{
                i++;
            }
        }
    }

    static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
