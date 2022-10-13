package Sorting;

import java.util.Arrays;

/*
!Name: Aritra Ghorai
!Date:13/10/2022
?Program Details:976. Largest Perimeter Triangle
*https://leetcode.com/problems/largest-perimeter-triangle/description/
 */
public class Q4_largest_parimeter_triangle {
	public static void main(String[] args) {

	}

	public int largestPerimeter(int[] nums) {
		Arrays.sort(nums);
		int res = 0;
		for (int i = nums.length - 1; i > 1; i--) {
			if (nums[i - 1] + nums[i - 2] > nums[i]) {
				res = nums[i] + nums[i - 1] + nums[i - 2];
				break;
			}
		}
		return res;

	}
}
