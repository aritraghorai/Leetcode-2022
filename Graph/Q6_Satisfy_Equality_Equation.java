package Graph;

/*
 !Name: Aritra Ghorai
 !Date:26/09/2022
 ?Program Details:990. Satisfiability of Equality Equations
*https://leetcode.com/problems/satisfiability-of-equality-equations/
   */
public class Q6_Satisfy_Equality_Equation {
    int[] parent = new int[26];
    int[] level = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String s : equations) {
            if (s.charAt(2) == '=') {
                int a = s.charAt(0) - 'a';
                int b = s.charAt(3) - 'a';
                union(a, b);
            }
        }
        for (String s : equations) {
            if (s.charAt(2) == '!') {
                int a = s.charAt(0) - 'a';
                int b = s.charAt(3) - 'a';
                if (!checkConnection(a, b)) {
                    return false;
                }
            }
        }
        return true;
    }

    int findParent(int idx) {
        if (idx == parent[idx]) {
            return idx;
        }
        return parent[idx] = findParent(parent[idx]);
    }

    void union(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);
        if (level[parentA] > level[parentB]) {
            parent[parentB] = parentA;
        } else if (level[parentA] < level[parentB]) {
            parent[parentA] = parentB;
        } else {
            parent[parentA] = parentB;
            level[parentB]++;
        }
    }

    public boolean checkConnection(int a, int b) {
        return findParent(a) == findParent(b);
    }
}
