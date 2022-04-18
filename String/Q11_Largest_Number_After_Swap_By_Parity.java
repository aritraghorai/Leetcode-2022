package String;

/*
 !Name: Aritra Ghorai
 !Date:14/04/2022
 ?Program Details:2231. Largest Number After Digit Swaps by Parity
 *https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/
   */
public class Q11_Largest_Number_After_Swap_By_Parity {
    public int largestInteger(int num) {
        char[] numArray = new String(num + "").toCharArray();
        int[] freq = new int[10];
        for (char n : numArray) {
            freq[n - '0']++;
        }
        int res = 0;
        for (char c : numArray) {
            int n = c - '0';
            if (n % 2 == 0) {
                for (int i = 8; i >= 0; i -= 2) {
                    if (freq[i] != 0) {
                        res = res * 10 + i;
                        freq[i]--;
                        break;
                    }
                }
            } else {
                for (int i = 9; i > 0; i -= 2) {
                    if (freq[i] != 0) {
                        res = res * 10 + i;
                        freq[i]--;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
