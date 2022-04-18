package ProrityQueue;

import java.util.PriorityQueue;

/*
 !Name: Aritra Ghorai
 !Date:16/04/2022
 ?Program Details:2233. Maximum Product After K Increments
 *https://leetcode.com/problems/maximum-product-after-k-increments/
   */
public class Q7_Maximum_product_After_K_Increment {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums)
            pq.add(num);
        while (k-- > 0) {
            pq.add(pq.poll() + 1);
        }
        long ans = 1;
        int mod = 1000000007;
        while (!pq.isEmpty()) {
            ans = (ans * pq.poll()) % mod;
        }
        return (int) ans;
    }
}
