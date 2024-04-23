package org.example.leetcode.array;

import java.util.Arrays;
import java.util.Collections;

public class EvenPositionGreaterThanOdd {
    //Rearrange array such that even positioned are greater than odd
//    Given an array arr[] of N elements, sort the array according to the following relations:
//    arr[i] >= arr[i – 1], if i is even, ∀ 1 <= i < N
//    arr[i] <= arr[i – 1], if i is odd, ∀ 1 <= i < N
//    Examples:
//    Input: N = 4, arr[] = {1, 2, 2, 1,3}
//    Output: 2 1 2 1
//    Explanation:

    public static void main(String[] args) {
        int arr[] = {1, 3, 2};
        System.out.println(Arrays.toString(arr));
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortArray(int[] arr) {
//        Arrays.sort(arr);
        int ptr1=0,ptr2=arr.length-1;


        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            if(i%2==0 && arr[i]<arr[i-1]){
                swap(arr, i,i-1);
            }

        }

    }

    static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
