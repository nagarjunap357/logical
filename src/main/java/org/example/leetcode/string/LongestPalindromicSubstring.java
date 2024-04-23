package org.example.leetcode.string;

public class LongestPalindromicSubstring {
//    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
//    Example 1:
//    Input: "babad"
//    Output: "bab"
//    Note: "aba" is also a valid answer.
//
//    Example 2:
//    Input: "cbbd"
//    Output: "bb"

    int resultStart;
    int resultLength;

    public static void main(String[] args) {
        String s = "xdbabad";

        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        for (int i = 0; i < s.length()-1; i++) {
            obj.checkPalindrome(s, i, i);
            obj.checkPalindrome(s, i, i + 1);
        }

        System.out.println("Palindrome Substring: "+s.substring(obj.resultStart, obj.resultStart+obj.resultLength));
    }

     void checkPalindrome(String s, int start, int end) {
        while(start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        if(resultLength < end-start-1){
            resultStart = start+1;
            resultLength = end-start-1;

        }
    }
}
