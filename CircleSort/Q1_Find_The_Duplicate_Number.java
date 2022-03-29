package CircleSort;

import java.util.Arrays;

/*
 !Name: Aritra Ghorai
 !Date:29/03/2022
 ?Program Details:287. Find the Duplicate Number
 *https://leetcode.com/problems/find-the-duplicate-number/ 
   */
public class Q1_Find_The_Duplicate_Number {
    // *Using cycle sort
    // *Modified the array
    public int findDuplicate_CS(int[] nums) {
        // *circle sort for sort the array
        // *array element is from 1-n
        int i = 0;
        while (i < nums.length) {
            // *If The Element is in correct location then don't do anything
            if (nums[i] - 1 == i) {
                i++;
            } else if (nums[i] == nums[nums[i] - 1]) {
                return nums[i];
            } else {
                // *Then swap
                int tem = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tem - 1] = tem;
            }
        }
        System.out.println(Arrays.toString(nums));
        return 0;
    }

    // *Floyd Cycle Detection
    // *Not modified the array
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

}
