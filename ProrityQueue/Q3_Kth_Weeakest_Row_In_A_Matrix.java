package ProrityQueue;

import java.util.PriorityQueue;

/*
 !Name: Aritra Ghorai
 !Date:27/03/2022
 ?Program Details:1337. The K Weakest Rows in a Matrix
 *https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
   */
public class Q3_Kth_Weeakest_Row_In_A_Matrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<soldires> pq = new PriorityQueue<>();
        for (int i = 0; i < mat.length; i++) {
            int numberOfSoldiers = 0;
            for (int j : mat[i]) {
                if (j == 1) {
                    numberOfSoldiers++;
                }
            }
            pq.add(new soldires(numberOfSoldiers, i));
        }
        int[] res = new int[k];
        int i = 0;
        while (k > 0) {
            res[i++] = pq.poll().rowNo;
            k--;
        }
        return res;
    }

}

class soldires implements Comparable<soldires> {
    int numberSol;
    int rowNo;

    soldires(int n, int rn) {
        numberSol = n;
        rowNo = rn;
    }

    @Override
    public int compareTo(soldires o) {
        return this.numberSol == o.numberSol ? this.rowNo - o.rowNo : this.numberSol - o.numberSol;
    }

}
