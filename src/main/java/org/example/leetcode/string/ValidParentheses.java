package org.example.leetcode.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {

//    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//    An input string is valid if:
//     - Open brackets must be closed by the same type of brackets.
//     - Open brackets must be closed in the correct order.
//     - Every close bracket has a corresponding open bracket of the same type.
//
//    Example 1:
//    Input: s = "()"
//    Output: true
//
//    Example 2:
//    Input: s = "()[]{}"
//    Output: true
//
//    Example 3:
//    Input: s = "(]"
//    Output: false

    public static void main(String[] args) {
        System.out.println(isValid("{}[()]"));
    }

    static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek();
                if ((c == '}' && top == '{') || (c == ']' && top == '[') || (c == ')' && top == '(')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {

        List<Character> list = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                list.add(c);
            } else {

                if (list.isEmpty()) {
                    return false;
                } else if ((c == '}' && list.get(list.size() - 1) == '{')
                        || (c == ']' && list.get(list.size() - 1) == '[')
                        || (c == ')' && list.get(list.size() - 1) == '(')) {
                    list.remove(list.size() - 1);
                } else {
                    return false;
                }
            }
        }
        return list.isEmpty();
    }
}
