package org.example.leetcode.array;

import java.util.HashMap;

public class CommonElement {

//    Write a function itemInCommon(array1, array2) that takes two arrays as input and returns true
//            if there is at least one common item between the two lists, false otherwise.

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,5,8};
        int[] arr2 = {0,6,7,5};
        boolean result = itemInCommon(arr1, arr2);
        System.out.println(result);
    }

    private static boolean itemInCommon(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i : array1) {
            map.put(i, true);
        }
        for (int i : array2) {
            if (map.get(i) != null) {
                return true;
            }
        }

        return false;
    }
}
