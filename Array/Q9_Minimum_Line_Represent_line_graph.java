package Array;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:26/05/2022
 ?Program Details:2280. Minimum Lines to Represent a Line Chart
 *https://leetcode.com/problems/minimum-lines-to-represent-a-line-chart/
   */
public class Q9_Minimum_Line_Represent_line_graph {
    // *This Solution Give Us Error Because of java precision issue
    public int minimumLinesE(int[][] stockPrices) {
        Arrays.sort(stockPrices, (a, b) -> {
            return a[0] - b[0];
        });
        double preDiffernt = Double.MIN_VALUE;
        int count = 1;
        for (int i = 1; i < stockPrices.length; i++) {
            double currDifferent = ((double) (stockPrices[i][0] - stockPrices[i - 1][0]))
                    / ((double) (stockPrices[i][1] - stockPrices[i - 1][1]));
            System.out.println(currDifferent);
            if (currDifferent == preDiffernt) {
                continue;
            } else {
                count++;
                preDiffernt = currDifferent;
            }
        }
        return count;
    }

    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length == 1) {
            return 0;
        }
        Arrays.sort(stockPrices, (a, b) -> {
            return a[0] - b[0];
        });
        int count = 1;
        for (int i = 2; i < stockPrices.length; i++) {
            if ((stockPrices[i][0] - stockPrices[i - 1][0])
                    * (stockPrices[i - 1][1] - stockPrices[i - 2][1]) != (stockPrices[i - 1][0] - stockPrices[i - 2][0])
                            * (stockPrices[i][1] - stockPrices[i - 1][1])) {
                count++;
            }
        }
        return count;
    }
}
