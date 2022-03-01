package String;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:28/02/2022
 ?Program Details:228. Summary Ranges
 *https://leetcode.com/problems/summary-ranges/ 
   */
public class Q5_Summery_Ranges {
    public List<String> summaryRanges(int[] nums) {
        int i = 0;
        List<String> ans = new ArrayList<>();
        while (i < nums.length) {

            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]);
            boolean isVisit = false;
            while (i < nums.length - 1 && nums[i + 1] - nums[i] == 1) {
                i++;
                isVisit = true;
            }
            if (isVisit)
                sb.append("->" + nums[i]);
            i++;
            ans.add(sb.toString());
        }
        return ans;
    }
}
