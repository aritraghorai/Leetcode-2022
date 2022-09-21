package Greedy;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:15/09/2022
 ?Program Details:2007. Find Original Array From Doubled Array
 *https://leetcode.com/problems/find-original-array-from-doubled-array/
   */
public class Q14_Find_Original_From_Doubled_Array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOriginalArray(new int[] { 1, 3, 4, 2, 6, 8 })));
    }

    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : changed) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        var keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        int[] res = new int[changed.length / 2];
        int co = 0;
        for (int key : keys) {
            if (key == 0) {
                if (map.get(key) % 2 != 0) {
                    return new int[0];
                }
                int i = map.get(key) / 2;
                while (i > 0) {
                    res[co++] = key;
                    i--;
                }
                map.put(key, 0);
                continue;
            }
            if (map.get(key) == 0) {
                continue;
            }
            if (map.containsKey(key * 2)) {
                if (map.get(key * 2) - map.get(key) >= 0) {
                    int i = map.get(key);
                    while (i > 0) {
                        res[co++] = key;
                        i--;
                    }
                    map.put(key * 2, map.get(key * 2) - map.get(key));
                } else {
                    return new int[0];
                }
            } else {
                return new int[0];
            }
        }
        return res;

    }
}
