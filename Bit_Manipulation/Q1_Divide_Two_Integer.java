package Bit_Manipulation;

/*
 !Name: Aritra Ghorai
 !Date:30/05/2022
 ?Program Details:29. Divide Two Integers
 *https://leetcode.com/problems/divide-two-integers/
   */
public class Q1_Divide_Two_Integer {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = (dividend < 0) != (divisor < 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int res = 0;
        while ((dividend - divisor) >= 0) {
            int count = 0;
            while (dividend - (divisor << 1 << count) >= 0) {
                count++;
            }
            res += (1 << count);
            dividend -= (divisor << count);
        }
        return sign ? -res : res;	
    }
}
