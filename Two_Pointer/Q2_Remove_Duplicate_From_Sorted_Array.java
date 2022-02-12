package Two_Pointer;

/*
 !Name: Aritra Ghorai
 !Date:06/02/2022
 ?Program Details:80. Remove Duplicates from Sorted Array II
 *https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/ 
   */
public class Q2_Remove_Duplicate_From_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        var n = nums.length;
        if (n < 3)
            return n;

        var i = 2;
        for (var j = i; j < n; j++)
            if (nums[j] != nums[i - 2])
                nums[i++] = nums[j];

        return i;

    }
}
