package Sliding_Window;

/*
 !Name: Aritra Ghorai
 !Date:26/06/2022
 ?Program Details:1423. Maximum Points You Can Obtain from Cards
 *https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
   */
public class Q4_Maximum_Point_Can_Obtain_From_Card {
    public static void main(String[] args) {
        int[] a = { 9, 7, 7, 9, 7, 7, 9 };
        System.out.println(maxScore(a, 7));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int windowSize = cardPoints.length - k;
        int i = 0, j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int totalSum = 0;
        while (j < cardPoints.length) {
            if (j - i + 1 < windowSize) {
                sum += cardPoints[j];
                totalSum += cardPoints[j];
                j++;
            } else {
                sum += cardPoints[j];
                totalSum += cardPoints[j];
                j++;
                min = Math.min(sum, min);
                sum -= cardPoints[i];
                i++;
            }
        }

        return windowSize != 0 ? totalSum - min : totalSum;
    }
}
