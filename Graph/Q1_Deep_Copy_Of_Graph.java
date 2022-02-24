package Graph;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:23/02/2022
 ?Program Details:133. Clone Graph
 *https://leetcode.com/problems/clone-graph/
   */
public class Q1_Deep_Copy_Of_Graph {
    public Node cloneGraph(Node node) {
        Node nn = new Node(node.val);
        var qu = new LinkedList<Node>();
        var map = new HashMap<Integer, Node>();
        map.put(node.val, nn);
        qu.offer(node);
        while (!qu.isEmpty()) {
            var rn = qu.poll();
            for (Node nb : rn.neighbors) {
                if (!map.containsKey(nb.val)) {
                    map.put(nb.val, new Node(nb.val));
                    qu.add(nb);
                }
                System.out.println(rn.val + "->" + nb.val);
                map.get(rn.val).neighbors.add(map.get(nb.val));
            }

        }
        return nn;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
