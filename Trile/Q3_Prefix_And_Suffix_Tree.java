package Trile;

import java.util.ArrayList;
import java.util.Objects;

/*
 !Name: Aritra Ghorai 
 !Date:18/06/2022
 ?Program Details:745. Prefix and Suffix Search
 *https://leetcode.com/problems/prefix-and-suffix-search/
   */
public class Q3_Prefix_And_Suffix_Tree {
}

class WordFilter {
    Trile2 pre = new Trile2();
    Trile2 suf = new Trile2();

    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            pre.insert(words[i], i);
            suf.insert(new StringBuilder(words[i]).reverse().toString(), i);
        }
    }

    public int f(String prefix, String suffix) {
        var preList = pre.startsWith(prefix);
        var suffList = suf.startsWith(new StringBuilder(suffix).reverse().toString());
        int i = preList.size() - 1;
        int j = suffList.size() - 1;
        while (i >= 0 && j >= 0) {
            if (Objects.equals(preList.get(i), suffList.get(j))) {
                return preList.get(i);
            } else if (preList.get(i) > suffList.get(j)) {
                i--;
            } else {
                j--;
            }
        }
        return -1;
    }
}

class Trile2 {
    Trile2[] root;
    ArrayList<Integer> indexs;

    public Trile2() {
        root = new Trile2[26];
        indexs = new ArrayList<>();
    }

    public void insert(String s, int in) {
        Trile2 temp = this;
        for (char ch : s.toCharArray()) {
            if (temp.root[ch - 'a'] == null) {
                temp.root[ch - 'a'] = new Trile2();
            }
            temp = temp.root[ch - 'a'];
            temp.indexs.add(in);
        }
    }

    public ArrayList<Integer> startsWith(String s) {
        Trile2 temp = this;
        for (char ch : s.toCharArray()) {
            if (temp.root[ch - 'a'] == null) {
                return new ArrayList<>();
            }
            temp = temp.root[ch - 'a'];
        }
        return temp.indexs;
    }

}
