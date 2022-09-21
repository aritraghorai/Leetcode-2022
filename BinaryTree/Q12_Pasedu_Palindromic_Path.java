package BinaryTree;

/*
 !Name: Aritra Ghorai
 !Date:14/09/2022
 ?Program Details:1457. Pseudo-Palindromic Paths in a Binary Tree
 *https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
   */
public class Q12_Pasedu_Palindromic_Path {
    private int res = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        f(root, new int[10]);
        return res;
    }

    public void f(TreeNode ro, int[] fr) {
        if (ro == null) {
            return;
        }

        fr[ro.val] += 1;
        f(ro.left, fr);
        f(ro.right, fr);
        if (ro.left == null && ro.right == null) {
            int odd = 0, i = 0;
            for (i = 0; i < 10; i++) {
                if (fr[i] % 2 != 0) {
                    odd++;
                }

            }
            if (odd <= 1) {
                res++;
            }
        }
        fr[ro.val]--;
    }
}
