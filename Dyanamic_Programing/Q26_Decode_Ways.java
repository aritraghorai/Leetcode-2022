package Dyanamic_Programing;

/*
 !Name: Aritra Ghorai
 !Date:01/10/2022
 ?Program Details:91. Decode Ways
*https://leetcode.com/problems/decode-ways/
   */
public class Q26_Decode_Ways {
    public int numDecodings(String s) {
        // return f(s, 0);
        int[] dp = new int[s.length() + 1];
        dp[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        dp[s.length()] = 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            } else {
                // *For one character */
                dp[i] += dp[i + 1];
                // *For two chracter */
                if (Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    public int f(String s, int idx) {
        if (idx == s.length()) {
            return 1;
        }
        if (s.charAt(idx) == '0') {
            return 0;
        }
        int res = 0;
        // *For One Chracter coise */
        res += f(s, idx + 1);
        // *For Two Character coise */
        if (idx != s.length() - 1 && Integer.parseInt(s.substring(idx, idx + 2)) <= 26) {
            res += f(s, idx + 2);
        }
        return res;
    }

}
