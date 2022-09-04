package Bfs;

import java.util.Arrays;
import java.util.LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:03/09/2022
 ?Program Details:967. Numbers With Same Consecutive Differences
 *https://leetcode.com/problems/numbers-with-same-consecutive-differences/
   */
public class Q5_Number_With_Same_Consecutive_Different {
    public static void main(String[] args) {
        var res = numsSameConsecDiff(3, 7);
        System.out.println(Arrays.toString(res));
    }

    public static int[] numsSameConsecDiff(int n, int k) {
        int temp = 0;

        LinkedList<Integer> qu = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            qu.offer(i);
        }
        temp++;
        while (n > temp) {
            int si = qu.size();
            for (int i = 1; i <= si; i++) {
                int rn = qu.poll();
                int ld = rn % 10;
                if (ld - k >= 0) {
                    int nn = rn * 10 + (ld - k);
                    qu.offer(nn);
                }
                if (ld + k <= 9) {
                    int nn = rn * 10 + (ld + k);
                    qu.offer(nn);
                }
            }
            temp++;
        }
        int size = qu.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = qu.poll();
        }
        return res;
    }
}
