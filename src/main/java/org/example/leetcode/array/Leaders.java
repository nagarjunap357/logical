package org.example.leetcode.array;

public class Leaders {
//    Write a program to print all the LEADERS in the array.
//    An element is a leader if it is greater than all the elements to its right side.
//    And the rightmost element is always a leader.
//
//    For example:
//    Input: arr[] = {16, 17, 4, 3, 5, 2},
//    Output: 17, 5, 2
//
//    Input: arr[] = {1, 2, 3, 4, 5, 2},
//    Output: 5, 2

    public static void main(String[] args) {
        int[] arr1 = {16, 17, 4, 3, 5, 2};
        int[] arr2 = {1, 2, 3, 4, 5, 2};
        findLeaders(arr2);
    }

   static void findLeaders(int[] arr){
        int n = arr.length;

        for(int i = 0;i<n;i++){
            int count = 0;

            for (int j=i+1;j<n;j++){
                if(arr[i]<arr[j]){
                    count++;
                    break;
                }
            }
             if(count==0){
                 System.out.println(arr[i]);
             }

        }

    }
}
