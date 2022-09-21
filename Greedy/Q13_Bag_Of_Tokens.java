package Greedy;

import java.util.Arrays;

/*
 !Name: Aritra Ghorai
 !Date:12/09/2022
 ?Program Details:948. Bag of Tokens
 *https://leetcode.com/problems/bag-of-tokens/
   */
public class Q13_Bag_Of_Tokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0, j = tokens.length - 1;
        int po = 0;
        int max = 0;
        while (i <= j) {
            if (po == 0 && power >= tokens[i]) {
                power -= tokens[i];
                i++;
                po += 1;
            } else {
                if (i < j) {
                    if (power >= tokens[i]) {
                        power -= tokens[i];
                        i++;
                        po += 1;
                    } else if (po > 0) {
                        power += tokens[j];
                        j--;
                        po -= 1;
                    } else {
                        i++;
                    }
                } else {
                    if (power >= tokens[i]) {
                        po += 1;
                        i++;
                        j--;
                    }
                }
            }
            max = Math.max(max, po);
        }
        return max;
    }
}
