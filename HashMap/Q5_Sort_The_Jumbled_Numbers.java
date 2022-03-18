package HashMap;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:05/03/2022
 ?Program Details:5217. Sort the Jumbled Numbers 
 *https://leetcode.com/problems/sort-the-jumbled-numbers/
   */
public class Q5_Sort_The_Jumbled_Numbers {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for (int j : nums) {
            int mapValue = 0;
            String numString = j + "";
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numString.length(); i++) {
                sb.append(mapping[numString.charAt(i) - '0']);
            }
            mapValue = Integer.parseInt(sb.toString());
            // System.out.println(mapValue);
            map.put(j, mapValue);
        }
        ArrayList<pair> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new pair(i, nums[i]));
        }
        Collections.sort(list, (a, b) -> {
            return map.get(a.value) == map.get(b.value) ? a.index - b.index : map.get(a.value) - map.get(b.value);
        });
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = list.get(i).value;
        }
        return res;
    }
}

class pair {
    int index;
    int value;

    pair(int i, int v) {
        index = i;
        value = v;
    }
}
