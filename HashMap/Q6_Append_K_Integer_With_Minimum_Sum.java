package HashMap;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:06/03/2022
 ?Program Details:6017. Append K Integers With Minimal Sum
*https://leetcode.com/problems/append-k-integers-with-minimal-sum/submissions/
   */
public class Q6_Append_K_Integer_With_Minimum_Sum {
   public long minimalKSumTLE(int[] nums, int k) {
      var set = new HashSet<>();
      int max = 0;
      for (int i : nums) {
         set.add(i);
         max = Math.max(max, i);
      }
      long ans = 0;
      for (int i = 1; i <= max && k > 0; i++) {
         if (set.contains(i)) {
            continue;
         } else {
            ans += i;
            k--;
         }
      }
      for (int i = max + 1; k > 0; i++) {
         ans += i;
         k--;
      }
      return ans;

   }

   public long minimalKSum(int[] nums, int k) {
      Arrays.sort(nums);
      Set<Integer> set = new HashSet<>();
      long sum = 0;

      for (int num : nums) {
         if (!set.contains(num) && num <= k) {
            k++;
            sum += num;
         }
         set.add(num);
      }

      long res = (long) (1 + k) * k / 2 - sum;
      return res;

   }
}
