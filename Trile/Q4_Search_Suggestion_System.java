package Trile;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:19/06/2022
 ?Program Details:1268. Search Suggestions System
 *https://leetcode.com/problems/search-suggestions-system/
   */
public class Q4_Search_Suggestion_System {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trile_Search_Suggestion tr = new Trile_Search_Suggestion();
        for (String s : products) {
            tr.Insert(s);
        }
        return tr.search(searchWord);
    }
}

class Trile_Search_Suggestion {
    private class Node {
        Node[] child = new Node[26];
        PriorityQueue<String> pq = new PriorityQueue<>();

        public Node() {

        }

        public Node get(char ch) {
            return this.child[ch - 'a'];
        }

        public void put(char ch, Node nn) {
            this.child[ch - 'a'] = nn;
        }

        public void addString(String s) {
            this.pq.add(s);
        }

    }

    private Node root = new Node();

    public void Insert(String s) {
        Node temp = root;
        for (char ch : s.toCharArray()) {
            if (temp.get(ch) == null) {
                temp.put(ch, new Node());
            }
            temp = temp.get(ch);
            temp.addString(s);
        }
    }

    public List<List<String>> search(String s) {
        List<List<String>> res = new ArrayList<>();
        Node temp = this.root;
        int i = 0;
        for (i = 0; i < s.length(); i++) {
            List<String> tempArr = new ArrayList<>();
            if (temp.get(s.charAt(i)) == null) {
                break;
            }
            temp = temp.get(s.charAt(i));
            while (temp.pq.size() != 0 && tempArr.size() != 3) {
                tempArr.add(temp.pq.poll());
            }
            res.add(tempArr);
        }
        for (; i < s.length(); i++) {
            res.add(new ArrayList<String>());
        }
        return res;
    }
}
