package PrefixSum;

/*
 !Name: Aritra Ghorai
 !Date:04/12/2022
 ?Program Details:2256. Minimum Average Difference
*https://leetcode.com/problems/minimum-average-difference/description/
   */
public class Q1_Minimum_average_difference {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 1, 1 };
        System.out.println(minimumAverageDifference(arr));
    }

    public static int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] preSum = new long[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        long right = 0;
        int minIndex = -1;
        long minValue = Integer.MAX_VALUE;
        for (int j = n - 1; j >= 0; j--) {
            System.out.println((j + 1) + " " + preSum[j]);
            long leftAvg = ((preSum[j]) / (j + 1));
            long rightAvg = j == n - 1 ? 0 : ((right) / (n - j - 1));
            long mod = Math.abs(leftAvg - rightAvg);
            if (mod <= minValue) {
                minIndex = j;
                minValue = mod;
            }
            right += nums[j];
        }
        return minIndex;
    }
}
