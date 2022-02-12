package Recursion;

/*
 !Name: Aritra Ghorai
 !Date:29/01/2022
 ?Program Details:2151. Maximum Good People Based on Statements
 *https://leetcode.com/problems/maximum-good-people-based-on-statements/ Power Set
   */
public class Q1_Maximum_Number_Of_Good_People {

    public int maximumGood(int[][] statements) {
        return helper(statements, "", 0);
    }

    public int helper(int[][] statements, String s, int index) {
        if (index == statements.length) {
            return isvalid(statements, s);
        }
        int write = helper(statements, s + "1", index + 1);
        int wrong = helper(statements, s + "0", index + 1);
        return Math.max(write, wrong);
    }

    private int isvalid(int[][] statements, String s) {
        int count = 0;
        for (int i = 0; i < statements.length; i++) {
            if (s.charAt(i) == '0')
                continue;
            count++;
            for (int j = 0; j < statements.length; j++) {
                if (statements[i][j] == 0 && s.charAt(j) == '1')
                    return 0;
                if (statements[i][j] == 1 && s.charAt(j) == '0')
                    return 0;
            }

        }
        return count;
    }

}
