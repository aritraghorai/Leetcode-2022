package HashMap;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 !Name: Aritra Ghorai
 !Date:02/11/2022
 ?Program Details:433. Minimum Genetic Mutation
*https://leetcode.com/problems/minimum-genetic-mutation/
   */
public class Q23_Minimum_gene_mutation {
    public static void main(String[] args) {

        String[] s = { "AACCGATT", "AACCGATA", "AAACGATA", "AAACGGTA" };
        System.out.println(minMutation("AACCGGTT", "AAACGGTA", s));

    }

    static char[] arr = { 'A', 'C', 'G', 'T' };

    public static int minMutation(String start, String end, String[] bank) {
        Queue<String> qu = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        for (String s : bank) {
            set.add(s);
        }
        if (!set.contains(end)) {
            return -1;
        }
        qu.offer(start);
        int step = 0;
        while (!qu.isEmpty()) {
            int si = qu.size();
            for (int i = 0; i < si; i++) {
                String rm = qu.poll();
                if (rm.equals(end)) {
                    return step;
                }
                for (int j = 0; j < 8; j++) {
                    for (char ch : arr) {
                        if (ch == rm.charAt(j))
                            continue;
                        String newString = rm.substring(0, j) + ch + rm.substring(j + 1);
                        if (set.contains(newString)) {
                            qu.offer(newString);
                        }
                    }

                }
            }

            step++;
        }
        return -1;
    }
}
