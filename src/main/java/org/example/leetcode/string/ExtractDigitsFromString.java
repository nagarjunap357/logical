package org.example.leetcode.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExtractDigitsFromString {
    public static void main(String[] args) {

        String[] arr = new String[]{"as1d", "3de", "", "fr4", "2"};
        int sum = Arrays.stream(arr)
                .map(s -> s.replaceAll("\\D", ""))
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .sum();


        System.out.println(Arrays.toString(arr));
        System.out.println(sum);
    }
}
