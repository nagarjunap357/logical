package org.example.leetcode.string;


import java.util.HashMap;
import java.util.Map;

public class SubstringsWORepeatingChar {

//    Input: s = "abab"
//    Output: 7
//    Explanation: Special substrings are as follows (sorted by their start positions):
//    Special substrings of length 1: "a", "b", "a", "b"
//    Special substrings of length 2: "ab", "ba", "ab"
//    And it can be shown that there are no special substrings with a length of at least three.
//    So the answer would be 4 + 3 = 7.

    public static void main(String[] args) {
    String input = "abcabcbb";
        int output = numberOfSpecialSubstrings2(input);
        System.out.println(output);
    }

    public static int numberOfSpecialSubstrings(String s) {
        int ans = 0;
        int[] count = new int[26];

        for (int l = 0, r = 0; r < s.length(); r++) {
            int charDiff = s.charAt(r) - 'a';
            ++count[charDiff];
            while (count[charDiff] == 2) {
                --count[s.charAt(l) - 'a'];
                l++;
            }
            ans += r - l + 1;
        }

        return ans;
    }
    public static int numberOfSpecialSubstrings2(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left) {
                charMap.put(s.charAt(right), right);
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left = charMap.get(s.charAt(right)) + 1;
                charMap.put(s.charAt(right), right);
            }
        }
        return maxLength;
    }
}
