package BFS;

import java.util.HashSet;
import java.util.LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:21/05/2022
 ?Program Details:322. Coin Change
 *https://leetcode.com/problems/coin-change/
   */
public class Q4_Coin_Change {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        System.out.println(coinChange(coins, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        var queue = new LinkedList<Integer>();
        queue.add(amount);
        int st = 0;
        HashSet<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            int si = queue.size();
            st++;
            while (si-- > 0) {
                int rA = queue.poll();
                for (int coin : coins) {
                    int amountR = rA - coin;
                    if (amountR == 0) {
                        return st;
                    }
                    if (amountR > 0 && !set.contains(amountR)) {
                        queue.offer(amountR);
                        set.add(amountR);
                    }
                }
            }
        }
        return -1;
    }
}
