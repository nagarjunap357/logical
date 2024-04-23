package org.example.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDuplicates {
//    Problem: Given an array of integers nums, find all the duplicates in the array using a hash table (HashMap).

//    Input: int[] nums = [4, 3, 2, 7, 2,. 8, 2, 3, 1]
//    Output: [2, 3]
//    Explanation: The numbers 2 and 3 appear more than once in the input array.

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2, 1,2, 4, 5, 4,2};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);
    }

    private static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>1){
                list.add(entry.getKey());
            }
        }

//        ArrayList<Integer> collect = map.entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toCollection(ArrayList::new));
//        System.out.println(collect);
        return list;
    }
}
