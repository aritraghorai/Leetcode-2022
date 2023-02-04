package Dyanamic_Programing;

/*
 !Name: Aritra Ghorai
 !Date:17/01/2023
 ?Program Details:926. Flip String to Monotone Increasing
*https://leetcode.com/problems/flip-string-to-monotone-increasing/
   */
public class Q31_Flip_String_Monotone_Incresing {

    public int minFlipsMonoIncr(String s) {
        char[] arr = s.toCharArray();
        int ans = 0, one = 0;
        for (char ch : arr) {
            if (ch == '1') {
                one++;
            } else {
                ans = Math.min(ans + 1, one);
            }
        }
        return ans;
    }

}
