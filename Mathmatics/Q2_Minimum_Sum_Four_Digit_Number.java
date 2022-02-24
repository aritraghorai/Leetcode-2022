package Mathmatics;

import java.util.Arrays;

/*
 !Name: Aritra Ghorai
 !Date:18/02/2022
 ?Program Details:2160. Minimum Sum of Four Digit Number After Splitting Digits
 *https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/ 
   */
public class Q2_Minimum_Sum_Four_Digit_Number {
    public int minimumSum(int num) {
        char[] arr = new String("" + num).toCharArray();
        Arrays.sort(arr);
        return Integer.parseInt("" + arr[0] + arr[2]) + Integer.parseInt("" + arr[1] + arr[3]);
    }
}
