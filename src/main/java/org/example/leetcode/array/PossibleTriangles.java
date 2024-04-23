package org.example.leetcode.array;

import java.util.Arrays;

public class PossibleTriangles {

//    Given an unsorted array of positive integers, find the number of triangles that can be formed
//    with three different array elements as three sides of triangles. For a triangle to be possible from 3 values,
//    the sum of any of the two values (or sides) must be greater than the third value (or third side).
//
//    Examples:
//
//    Input: arr= {4, 6, 3, 7}
//    Output: 3
//    Explanation: There are three triangles
//    possible {3, 4, 6}, {4, 6, 7} and {3, 6, 7}.
//    Note that {3, 4, 7} is not a possible triangle.
//
//    Input: arr= {10, 21, 22, 100, 101, 200, 300}.
//    Output: 6
//    Explanation: There can be 6 possible triangles:
//    {10, 21, 22}, {21, 100, 101}, {22, 100, 101},
//    {10, 100, 101}, {100, 101, 200} and {101, 200, 300}



    public static void main(String[] args) {
        int[] arr= {4, 6, 3, 7};
        countTriangles(arr);
    }

    static void countTriangles( int[] arr){
        int count = 0;
        Arrays.sort(arr);

        for(int i = arr.length-1; i>=1;i--){
            int j=0,k=i-1;
            while(j<k){
                if(arr[j]+arr[k] > arr[i]){
                    count += k-j;
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        System.out.println(count);
    }
}
