package Array;

import java.util.ArrayList;
import java.util.Collections;

/*
 !Name: Aritra Ghorai
 !Date:02/05/2022
 ?Program Details: 905. Sort Array By Parity
*https://leetcode.com/problems/sort-array-by-parity/
   */
public class Q8_Sort_Array_Parity {
    public int[] sortArrayByParity(int[] nums) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }
        Collections.sort(odd);
        Collections.sort(even);
        int j = 0, k = 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (j != even.size()) {
                res[i] = even.get(j++);
            } else {
                res[i] = odd.get(k++);
            }
        }
        return res;
    }

}
