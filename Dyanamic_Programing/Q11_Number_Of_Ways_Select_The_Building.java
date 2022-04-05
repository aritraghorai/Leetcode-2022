package Dyanamic_Programing;

/*
 !Name: Aritra Ghorai
 !Date:02/04/2022
 ?Program Details:6035. Number of Ways to Select Buildings
 *https://leetcode.com/contest/biweekly-contest-75/problems/number-of-ways-to-select-buildings/
 *https://leetcode.com/problems/number-of-ways-to-select-buildings/
   */
public class Q11_Number_Of_Ways_Select_The_Building {
    public static void main(String[] args) {
        String s = "11100";
        System.out.println(numberOfWays(s));
    }

    public static long numberOfWays(String s) {
        // return helper(s.toCharArray(), 0, 2, 0, new Long[s.length() + 1][3][4]);
        int zero = 0; // Individual zeroes count
        long zeroOne = 0; // Number of combinations of 01s
        int one = 0; // Individual ones count
        long oneZero = 0; // Number of combinations of 10s
        long tot = 0; // Final answer
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                zero++;
                if (one > 0)
                    oneZero += one; // Each of the previously found 1s can pair up with the current 0 to form 10
                if (zeroOne > 0)
                    tot += zeroOne; // Each of the previously formed 01 can form a triplet with the current 0 to
                                    // form 010
            } else {
                one++;
                if (zero > 0)
                    zeroOne += zero; // Each of the previously found 0s can pair to form 01
                if (oneZero > 0)
                    tot += oneZero; // Each of the previously formed 10 can form 101
            }
        }
        return tot;
    }

    public static long helper(char[] s, int index, int previous, int numberOfSelect, Long[][][] dp) {
        if (numberOfSelect == 3)
            return 1;
        if (s.length == index) {
            return 0;
        }
        if (dp[index][previous][numberOfSelect] != null) {
            return dp[index][previous][numberOfSelect];
        }
        long res = 0;
        res += helper(s, index + 1, previous, numberOfSelect, dp);
        if (previous == 2) {
            res += helper(s, index + 1, s[index] == '0' ? 0 : 1, numberOfSelect + 1, dp);
        } else {
            if (s[index] == '0' && previous != 0) {
                res += helper(s, index + 1, 0, numberOfSelect + 1, dp);
            } else if (s[index] == '1' && previous != 1) {
                res += helper(s, index + 1, 1, numberOfSelect + 1, dp);
            }
        }

        return dp[index][previous][numberOfSelect] = res;
    }

}
