package Sliding_Window;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:07/02/2023
 ?Program Details:904. Fruit Into Baskets
 *https://leetcode.com/problems/fruit-into-baskets/

   */
public class Q9_Fruts_Into_Busckets {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> set = new HashMap<>();
        int i = 0;
        int max = 0;
        for (int j = 0; j < fruits.length; j++) {
            set.put(fruits[j], set.getOrDefault(fruits[j], 0) + 1);
            if (set.size() <= 2) {
                max = Math.max(j - i + 1, max);
            } else {
                while (set.size() > 2) {
                    set.put(fruits[i], set.getOrDefault(fruits[i], 0) - 1);
                    if (set.get(fruits[i]) == 0) {
                        set.remove(fruits[i]);
                    }
                    i++;
                }
            }

        }
        if (set.size() <= 2) {
            max = Math.max(fruits.length - 1 - i + 1, max);
        }
        return max;

    }

}
