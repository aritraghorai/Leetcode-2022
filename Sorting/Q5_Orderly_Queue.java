package Sorting;

import java.util.Arrays;

/*
 !Name: Aritra Ghorai
 !Date:06/11/2022
 ?Program Details: 899. Orderly Queue
*https://leetcode.com/problems/orderly-queue/description/
   */
public class Q5_Orderly_Queue {
    public String orderlyQueue(String s, int k) {
        if (k == 0)
            return s;
        char[] arr = s.toCharArray();
        String res = s;
        if (k == 1) {
            // *We have replace whole part we can't replace the partial part*/
            for (int i = 0; i < arr.length; i++) {
                String neeString = s.substring(i) + s.substring(0, i);
                if (neeString.compareTo(res) < 0) {
                    res = neeString;
                }
            }
            return s;
        } else {
            Arrays.sort(arr);
        }
        return new String(arr);
    }
}
