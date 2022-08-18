package HashMap;

import java.util.Arrays;
import java.util.HashMap;

/*
 !Name: Aritra Ghorai
 !Date:09/08/2022
 ?Program Details:823. Binary Trees With Factors
 *https://leetcode.com/problems/binary-trees-with-factors/ 
   */
public class Q17_Binary_Tree_With_Factors {
    public int numFactoredBinaryTrees(int[] arr) {
        long ans = 1;
        HashMap<Integer, Long> map = new HashMap<>();
        Arrays.sort(arr);
        map.put(arr[0], (long) 1);
        for (int i = 1; i < arr.length; i++) {
            long res = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
                    res += map.get(arr[j]) * map.get(arr[i] / arr[j]);
                }
            }
            ans += res;
            map.put(arr[i], res);
        }
        return (int) (ans % (long) (1e9 + 7));
    }
}
