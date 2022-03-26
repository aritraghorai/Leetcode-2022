package Greedy;

/*
 !Name: Aritra Ghorai
 !Date:20/03/2022
 ?Program Details:1007. Minimum Domino Rotations For Equal Row
 *https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/ 
   */
public class Q2_Minimum_Domino_Tomino_Training {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] topCount = new int[7];
        int[] buttomCount = new int[7];
        int[] sameCount = new int[7];
        for (int i = 0; i < tops.length; i++) {
            topCount[tops[i]]++;
            buttomCount[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                sameCount[tops[i]]++;
            }
        }
        for (int i = 1; i < 7; i++) {
            if (topCount[i] + buttomCount[i] - sameCount[i] == tops.length) {
                return Math.min(topCount[i] - sameCount[i], buttomCount[i] - sameCount[i]);
            }
        }
        return -1;

    }
}
