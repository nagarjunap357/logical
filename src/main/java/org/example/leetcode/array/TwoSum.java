package org.example.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

//    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//    You may assume that each input would have exactly one solution, and you may not use the same element twice.
//            Example:
//    Given nums = [2, 7, 11, 15], target = 9,
//    Because nums[0] + nums[1] = 2 + 7 = 9,
//            return [0, 1].

    public static void main(String[] args) {

        int[] inputArr = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(inputArr,target)));
    }

    public static int[] twoSum(int[] inputArr, int target){

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;;i++){
            int x = inputArr[i];
            int y = target-x;
            if(map.containsKey(y)){
                return new int[] {map.get(y),i};
            }
            map.put(x,i);
        }
    }
}
