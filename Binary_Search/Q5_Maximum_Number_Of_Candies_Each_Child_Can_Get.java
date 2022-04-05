package Binary_Search;

/*
 !Name: Aritra Ghorai
 !Date:03/04/2022
 ?Program Details:5219. Maximum Candies Allocated to K Children
 *https://leetcode.com/contest/weekly-contest-287/problems/maximum-candies-allocated-to-k-children/
 *https://leetcode.com/problems/maximum-candies-allocated-to-k-children/
   */
public class Q5_Maximum_Number_Of_Candies_Each_Child_Can_Get {
    public static void main(String[] args) {
        int[] candies = { 1, 2, 3, 4, 10 };
        System.out.println(maximumCandies(candies, 5));
    }

    public static int maximumCandies(int[] candies, long k) {
        long low = 1;
        long high = Integer.MIN_VALUE;
        for (int i : candies) {
            high = Math.max(high, i);
        }
        long ans = 0;
        while (low <= high) {
            long mid = low + ((high - low) >> 1);
            if (canWeDistributeTheseCandies(candies, mid, k)) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return (int) ans;
    }

    private static boolean canWeDistributeTheseCandies(int[] candies, long mid, long k) {

        long count = 0;
        for (int i : candies) {
            count += (((long) i) / mid);
            if (count >= k) {
                return true;
            }
        }
        return count >= k;
    }

}
