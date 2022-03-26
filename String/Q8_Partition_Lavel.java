package String;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:21/03/2022
 ?Program Details:763. Partition Labels
 *https://leetcode.com/problems/partition-labels/ 
   */
public class Q8_Partition_Lavel {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    public static List<Integer> partitionLabels(String s) {
        int[] lastOcuurance = new int[26];
        // *Calculate the each character last occuence
        for (int i = 0; i < s.length(); i++) {
            lastOcuurance[s.charAt(i) - 'a'] = i;
        }
        // *Create A Integer ArrayList To Save All The Results
        ArrayList<Integer> res = new ArrayList<>();
        // ?Now The main logic come
        int max = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(lastOcuurance[s.charAt(i) - 'a'], max);
            // * i last of the ith character it mean it only ocuur in one part
            if (i == max) {
                int previous_part = res.size() == 0 ? 0 : res.get(res.size() - 1);
                sum += previous_part;
                res.add(i - sum + 1);
                max = i + 1;
            }
        }
        return res;

    }
}
