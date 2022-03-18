package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 !Name: Aritra Ghorai
 !Date:13/03/2022
 ?Program Details:6031. Find All K-Distant Indices in an Array
 *https://leetcode.com/contest/weekly-contest-284/problems/find-all-k-distant-indices-in-an-array/ 
   */
public class Q2_All_K_Indices_In_An_Array {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                map.put(i, key);
            }
        }
        var res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (int j : map.keySet()) {
                if (Math.abs(i - j) <= k) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}
