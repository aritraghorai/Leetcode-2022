package Greedy;

import java.util.Arrays;

/*
 !Name: Aritra Ghorai
 !Date:04/07/2022
 ?Program Details:135. Candy
 *https://leetcode.com/problems/candy/
   */
public class Q12_Distribute_Candy {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < left.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int j = right.length - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1]) {
                right[j] = right[j + 1] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < ratings.length; i++) {
            res += Math.max(left[i], right[i]);
        }
        return res;
    }
}
