package Dyanamic_Programing;

import java.util.Arrays;

/*
 !Name: Aritra Ghorai
 !Date:11/05/2022
 ?Program Details:1641. Count Sorted Vowel Strings
*https://leetcode.com/problems/count-sorted-vowel-strings/
   */
public class Q12_Count_Sorted_Vowel_String {
    public static void main(String[] args) {
        System.out.println(countVowelStrings(5));
    }

    public static int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][5];
        helper(n, 0, 0, dp);
        for (int[] temp : dp) {
            System.out.println(Arrays.toString(temp));
        }
        int[] dpOneD = new int[6];
        dpOneD[4] = 1;
        while (n >= 0) {
            System.out.println(Arrays.toString(dpOneD));
            for (int i = 4; i >= 0; i--) {
                dpOneD[i] = dpOneD[i] + dpOneD[i + 1];
            }

            n--;
        }
        return dpOneD[0];
    }

    public static int helper(int n, int numberOfWords, int pre, int[][] dp) {
        if (numberOfWords == n) {
            return 1;
        }
        if (pre == 5) {
            return 0;
        }
        if (dp[n][numberOfWords] != 0) {
            return dp[n][numberOfWords];
        }
        int res = 0;

        res += helper(n, numberOfWords + 1, pre, dp);
        res += helper(n, numberOfWords, pre + 1, dp);
        return dp[numberOfWords][pre] = res;

    }
}
