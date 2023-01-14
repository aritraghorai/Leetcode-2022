package Graph;

/*
 !Name: Aritra Ghorai
 !Date:14/01/2023
 ?Program Details:1061. Lexicographically Smallest Equivalent String
*https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
   */
public class Q11_Lexilogical_equivalent_string {
    private int[] parent;

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // *Set Initial rank and parent */
        parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        // Now calculta result
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            int parent = findParent(baseStr.charAt(i) - 'a');
            sb.append((char) (parent + 'a'));
        }
        return sb.toString();

    }

    private int findParent(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = findParent(parent[i]);
    }

    private void union(int nodeA, int nodeB) {
        int parentA = findParent(nodeA);
        int parentB = findParent(nodeB);
        if (parentA == parentB) {
            return;
        }
        int minParent = Math.min(parentA, parentB);
        int maxPrent = Math.max(parentA, parentB);
        parent[maxPrent] = minParent;
    }
}
