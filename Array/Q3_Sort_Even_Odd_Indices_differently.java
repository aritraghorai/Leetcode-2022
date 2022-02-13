package Array;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:12/02/2022
 ?Program Details:2164. Sort Even and Odd Indices Independently
 *https://leetcode.com/problems/sort-even-and-odd-indices-independently/
   */
public class Q3_Sort_Even_Odd_Indices_differently {
    public int[] sortEvenOdd(int[] nums) {
        var odd = new ArrayList<Integer>();
        var even = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }
        Collections.sort(odd);
        Collections.sort(even);
        int a = odd.size() - 1;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = even.get(b++);
            } else {
                nums[i] = odd.get(a--);
            }
        }
        return nums;

    }

}
