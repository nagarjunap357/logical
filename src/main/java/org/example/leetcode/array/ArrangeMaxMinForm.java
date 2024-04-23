package org.example.leetcode.array;

import java.util.Arrays;

public class ArrangeMaxMinForm {
//    Given a sorted array of positive integers, rearrange the array alternately
//    i.e; first element should be a maximum value, at second position minimum value,
//    at third position second max, at fourth position second min, and so on.
//
//    Examples:
//    Input: arr[] = {1, 2, 3, 4, 5, 6, 7}
//    Output: arr[] = {7, 1, 6, 2, 5, 3, 4}
//
//    Input: arr[] = {1, 2, 3, 4, 5, 6}
//    Output: arr[] = {6, 1, 5, 2, 4, 3}



    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6,7};
//        rearrangeArray(arr);
        rearrange(arr, arr.length);
    }


    // using extra space
    static void rearrangeArray(int[] arr){
        int[] result = new int[arr.length];

        int i = 0;
        int j=arr.length-1;
        for(int k = 0;i<j;k += 2){
            result[k] = arr[j];
            result[k+1] = arr[i];
            j--;
            i++;
        }
        if(i==j){
            result[result.length-1] = arr[i];
        }
        System.out.println(Arrays.toString(result));
    }


    // No extra space
    public static void rearrange(int arr[], int n)
    {
        // initialize index of first minimum and first
        // maximum element
        int max_idx = n - 1, min_idx = 0;

        // store maximum element of array
        int max_elem = arr[n - 1] + 1;

        // traverse array elements
        for (int i = 0; i < n; i++) {
            // at even index : we have to put
            // maximum element
            if (i % 2 == 0) {
                arr[i] += (arr[max_idx] % max_elem) * max_elem;
                max_idx--;
            }

            // at odd index : we have to put minimum element
            else {
                arr[i] += (arr[min_idx] % max_elem) * max_elem;
                min_idx++;
            }
        }

        // array elements back to it's original form
        for (int i = 0; i < n; i++){
            arr[i] = arr[i] / max_elem;
        }
        System.out.println(Arrays.toString(arr));
    }
}
