package BinaryTree;

import java.util.HashMap;
import java.util.HashSet;

/*
 !Name: Aritra Ghorai
 !Date:08/03/2022
 ?Program Details:2196. Create Binary Tree From Descriptions
 *https://leetcode.com/problems/create-binary-tree-from-descriptions/ 
   */
public class Q2_Convert_Binary_Tree_From_Description {
  // *Approach Doing using HashMap
  // *Here We use hashmap because to track root node
  public TreeNode createBinaryTree(int[][] descriptions) {
    HashMap<Integer, TreeNode> map = new HashMap<>();
    HashSet<Integer> childred = new HashSet<>();
    for (int[] des : descriptions) {
      int parent = des[0], child = des[1], isLeft = des[2];
      map.putIfAbsent(parent, new TreeNode(parent));
      map.putIfAbsent(child, new TreeNode(child));
      childred.add(child);
      if (isLeft == 1) {
        map.get(parent).left = map.get(child);
      } else {
        map.get(parent).right = map.get(child);
      }
    }
    map.keySet().removeAll(childred);
    return map.get(map.keySet().iterator().next());
  }
}
