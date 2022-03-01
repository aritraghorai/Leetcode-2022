package Dyanamic_Programing;

/*
 !Name: Aritra Ghorai
 !Date:01/03/2022
 ?Program Details:338. Counting Bits
 *https://leetcode.com/problems/counting-bits/
   */
public class Q4_Counting_Bits {
    public int[] countBits(int n) {
        if (n == 0) {
            return new int[] { 0 };
        }
        int[] storage = new int[n + 1];
        storage[1] = 1;
        for (int i = 2; i <= n; i++) {
            storage[i] = (i & 1) == 0 ? storage[i >> 1] + 1 : storage[i >> 1];
        }
        return storage;
    }
}
