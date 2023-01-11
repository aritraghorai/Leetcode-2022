package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 !Name: Aritra Ghorai
 !Date:22/12/2022
 ?Program Details:834. Sum of Distances in Tree
 *https://leetcode.com/problems/sum-of-distances-in-tree/
   */
/**
 * InnerQ15_Sum_Of_Distances
 */
/**
 * Q15_Sum_Of_Distances
 */
public class Q15_Sum_Of_Distances {
    public static void main(String[] args) {
        um_Of_Distances d = new um_Of_Distances();
        int[][] arr = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 }, { 2, 5 } };
        System.out.println(d.sumOfDistancesInTree(6, arr));
    }
}

class um_Of_Distances {
    List<List<Integer>> tree = new ArrayList<>();
    int[] countArr;
    int[] res;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        countArr = new int[n];
        res = new int[n];

        // *Create the tree */
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        // *Use src as zero */
        int src = 0;
        // *Calculate child count */
        calculateCount(src, new boolean[n]);
        // *Calculate the distance for src*/
        bfs(src, new boolean[n]);
        // *Calculate Result */
        calculateResult(src, n);
        return res;

    }

    void calculateResult(int src, int n) {
        LinkedList<Integer> qu = new LinkedList<>();
        qu.offer(src);
        boolean[] isVisit = new boolean[n];
        while (!qu.isEmpty()) {
            int si = qu.size();
            for (int i = 0; i < si; i++) {
                int rn = qu.poll();
                isVisit[rn] = true;
                for (int child : tree.get(rn)) {
                    if (!isVisit[child]) {
                        this.res[child] = this.res[rn] - this.countArr[child] + (n - this.countArr[child]);
                        qu.offer(child);
                    }
                }
            }
        }

    }

    void bfs(int src, boolean[] isVisit) {
        LinkedList<Integer> qu = new LinkedList<>();
        qu.offer(src);
        int level = 0;
        while (!qu.isEmpty()) {
            int si = qu.size();
            for (int i = 0; i < si; i++) {
                int rn = qu.poll();
                isVisit[rn] = true;
                this.res[src] += level;
                for (int child : tree.get(rn)) {
                    if (!isVisit[child])
                        qu.offer(child);
                }
            }
            level++;
        }
    }

    int calculateCount(int src, boolean[] isVisit) {
        isVisit[src] = true;
        for (int child : tree.get(src)) {
            if (!isVisit[child])
                countArr[src] += calculateCount(child, isVisit);
        }
        countArr[src] += 1;
        return countArr[src];
    }

}
