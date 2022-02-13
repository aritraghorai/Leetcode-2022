package String;

/*
 !Name: Aritra Ghorai
 !Date:12/02/2022
 ?Program Details:2165. Smallest Value of the Rearranged Number
*https://leetcode.com/problems/smallest-value-of-the-rearranged-number/ 
   */
public class Q2_Smallest_Value_By_rearrange_vlaue {

    public long smallestNumber(long num) {
        int[] digits = new int[10];
        long temp = Math.abs(num);
        while (temp != 0) {
            digits[(int) (temp % 10)]++;
            temp /= 10;
        }
        // *If Number is negetive
        if (num < 0) {
            for (int i = 9; i >= 0; i++) {
                temp = addNum(digits, temp, i);
            }
            return -temp;
        }
        temp = findFrist1(digits);
        if (temp == 0)
            return 0;
        digits[(int) temp]--;
        for (int i = 0; i <= 9; i++) {
            temp = addNum(digits, temp, i);
        }
        return temp;

    }

    private int findFrist1(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] != 0)
                return i;
        }
        return 0;
    }

    private long addNum(int[] digits, long temp, int i) {
        while (digits[i] != 0) {
            temp = temp * 10 + i;
            digits[i]--;
        }
        return temp;
    }
}
