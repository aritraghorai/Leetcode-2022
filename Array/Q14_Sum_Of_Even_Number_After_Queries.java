package Array;

/*
 !Name: Aritra Ghorai
 !Date:21/09/2022
 ?Program Details:985. Sum of Even Numbers After Queries
*https://leetcode.com/problems/sum-of-even-numbers-after-queries/
   */
public class Q14_Sum_Of_Even_Number_After_Queries {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        int sumOfEven = 0;
        for (int i : nums) {
            if (i % 2 == 0) {
                sumOfEven += i;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int[] qu = queries[i];
            if (nums[qu[1]] % 2 == 0) {
                sumOfEven -= nums[qu[1]];
            }
            nums[qu[1]] += qu[0];
            if (nums[qu[1]] % 2 == 0) {
                sumOfEven += nums[qu[1]];
            }
            res[i] = sumOfEven;
        }
        return res;
    }
}
