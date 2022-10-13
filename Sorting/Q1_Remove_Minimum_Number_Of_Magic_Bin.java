package Sorting;

import java.util.Arrays;

/*
 !Name: Aritra Ghorai
 !Date:26/02/2022
 ?Program Details:2171. Removing Minimum Number of Magic Beans
 *https://leetcode.com/problems/removing-minimum-number-of-magic-beans/
   */
public class Q1_Remove_Minimum_Number_Of_Magic_Bin {
	public long minimumRemoval(int[] beans) {
		long ans = Integer.MAX_VALUE, sum = 0;
		Arrays.sort(beans);
		for (int i = 0; i < beans.length; i++) {
			sum += beans[i];
			ans = Math.max(ans, (long) beans[i] * (beans.length - i));
		}
		return sum - ans;
	}
}
