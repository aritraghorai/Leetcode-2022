package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 !Name: Aritra Ghorai
 !Date:14/11/2022
 ?Program Details:947. Most Stones Removed with Same Row or Column
 *https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
   */
public class Q8_Most_Stone_Remove_With_Same_Row_Colm {
    public static void main(String[] args) {
        int[][] stones = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
        System.out.println(removeStones(stones));
    }

    public static int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(stone[1], maxCol);
        }
        DS ds = new DS(maxRow + maxCol + 2);
        HashSet<Integer> set = new HashSet<>();
        for (var stone : stones) {
            int nodeRow = stone[0];
            int nodeCol = stone[1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            set.add(nodeCol);
            set.add(nodeRow);
        }
        int count = 0;
        for (int i : set) {
            if (ds.findUltimateParent(i) == i) {
                count++;
            }
        }
        return n - count;
    }
}

// *Union By Ranks */
class DisjointSet {
    List<Integer> ranks = new ArrayList<>();
    List<Integer> parents = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            ranks.add(0);
            parents.add(i);
        }
    }

    public int findUltimateParent(int node) {
        if (node == parents.get(node)) {
            return node;
        }
        int ultimate_parent = findUltimateParent(this.parents.get(node));
        this.parents.set(node, ultimate_parent);
        return ultimate_parent;
    }

    public void unionByRank(int u, int v) {
        int ultimate_parent_of_u = findUltimateParent(u);
        int ultimate_parent_of_v = findUltimateParent(v);
        if (ultimate_parent_of_u == ultimate_parent_of_v) {
            return;
        }
        int rank_of_parent_u = this.ranks.get(ultimate_parent_of_u);
        int rank_of_parent_v = this.ranks.get(ultimate_parent_of_v);
        // *Rank of u is grater than rank of v* /
        if (rank_of_parent_u > rank_of_parent_v) {
            this.parents.set(ultimate_parent_of_v, ultimate_parent_of_u);
        } else if (rank_of_parent_v > rank_of_parent_u) {
            this.parents.set(ultimate_parent_of_u, ultimate_parent_of_v);
        } else {
            this.parents.set(ultimate_parent_of_u, ultimate_parent_of_v);
            this.ranks.set(ultimate_parent_of_v, rank_of_parent_v + 1);
        }
    }
}

// *Union By size */
class DS {
    List<Integer> sizes = new ArrayList<>();
    List<Integer> parents = new ArrayList<>();

    public DS(int n) {
        for (int i = 0; i < n; i++) {
            sizes.add(1);
            parents.add(i);
        }
    }

    public int findUltimateParent(int node) {
        if (node == parents.get(node)) {
            return node;
        }
        int ultimate_parent = findUltimateParent(this.parents.get(node));
        this.parents.set(node, ultimate_parent);
        return ultimate_parent;
    }

    public void unionBySize(int u, int v) {
        int ultimate_parent_of_u = findUltimateParent(u);
        int ultimate_parent_of_v = findUltimateParent(v);
        if (ultimate_parent_of_u == ultimate_parent_of_v) {
            return;
        }
        int size_of_parent_u = this.sizes.get(ultimate_parent_of_u);
        int size_of_parent_v = this.sizes.get(ultimate_parent_of_v);
        // *Rank of u is grater than rank of v* /
        if (size_of_parent_u > size_of_parent_v) {
            this.parents.set(ultimate_parent_of_v, ultimate_parent_of_u);
            this.sizes.set(ultimate_parent_of_u, size_of_parent_u + size_of_parent_v);
        } else {
            this.parents.set(ultimate_parent_of_u, ultimate_parent_of_v);
            this.sizes.set(ultimate_parent_of_v, size_of_parent_u + size_of_parent_v);
        }
    }
}
