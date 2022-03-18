package Dyanamic_Programing;

import java.util.Scanner;

/*
 !Name: Aritra Ghorai
 !Date:05/03/2022
 ?Program Details:740. Delete and Earn
 *https://leetcode.com/problems/delete-and-earn/ 
   */
public class Q7_Delete_And_Earn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(deleteAndEarn(nums));
        sc.close();
    }

    public static int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        int inc = 0, exc = 0;
        for (int val : nums)
            count[val]++;
        for (int i = 0; i <= 10000; i++) {
            int ni = exc + count[i] * i;
            int ne = Math.max(inc, exc);
            inc = ni;
            exc = ne;
        }
        return Math.max(inc, exc);
    }

}
