package Trile;

/*
 !Name: Aritra Ghorai
 !Date:28/01/2022
 ?Program Details:208. Implement Trie (Prefix Tree)
 *https://leetcode.com/problems/implement-trie-prefix-tree/
   */
public class Q2_Prefix_Tree_Tries {

}

class Trie {
    class Node {
        boolean end;
        Node[] words = new Node[26];

        public boolean contains(char ch) {
            return this.words[ch - 'a'] != null;
        }

        public void put(char ch, Node node) {
            this.words[ch - 'a'] = node;
        }

        public Node get(char ch) {
            return this.words[ch - 'a'];
        }

        public void setEnd() {
            this.end = true;
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (!curr.contains(ch)) {
                curr.put(ch, new Node());
            }
            curr = curr.get(ch);
        }
        curr.setEnd();
    }

    public boolean search(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (!curr.contains(ch))
                return false;
            curr = curr.get(ch);
        }
        return curr.end;
    }

    public int startsWith(String prefix) {
        int res = -1;
        Node curr = root;
        for (char ch : prefix.toCharArray()) {
            if (!curr.contains(ch))
                return res;
            curr = curr.get(ch);
            res++;
        }
        return res;
    }

}
