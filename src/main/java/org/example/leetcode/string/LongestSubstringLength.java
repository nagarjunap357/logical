package org.example.leetcode.string;

import java.util.HashMap;

public class LongestSubstringLength {
    //    Given a string, find the length of the longest substring without repeating characters.
//
//    Example 1:
//    Input: "abcabcbb"
//    Output: 3
//    Explanation: The answer is "abc", with the length of 3.
//
//    Example 2:
//    Input: "bbbbb"
//    Output: 1
//    Explanation: The answer is "b", with the length of 1.

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(findLengthOfLongestSubString(str));
    }
    static int findLengthOfLongestSubString(String str) {
        int length = 0;
        String longestSubString = "";
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0, left = 0; right < str.length(); right++) {

            char rightChar = str.charAt(right);

            if (map.containsKey(rightChar) && map.get(rightChar) >= left) {
                left = map.get(rightChar) + 1;
            }

            if(length < (right-left+1)){
                longestSubString = str.substring(left,right+1);
            }
            length = Math.max(length, right - left + 1);
            map.put(str.charAt(right), right);

        }
        System.out.println(longestSubString);
        return length;
    }
}



