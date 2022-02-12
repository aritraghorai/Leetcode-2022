package Trile;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:28/01/2022
 ?Program Details: 
   */
public class Q1_Word_Discnary {
  public static void main(String[] args) {
    WordDictionary wd = new WordDictionary();
    wd.addWord("a");
    wd.addWord("ab");
    System.out.println(wd.search(".b"));
  }
}

class WordDictionary {

  private Trile tr;

  public WordDictionary() {
    tr = new Trile();
  }

  public void addWord(String word) {
    tr.put(word);
  }

  public boolean search(String word) {
    return tr.search(word);
  }
}

class Trile {
  class Node {
    boolean isEnd = false;
    HashMap<Character, Node> wordsMap = new HashMap<>();

    Node() {

    }

    boolean hasWord(char ch) {
      return this.wordsMap.containsKey(ch);
    }

    void put(char ch, Node nn) {
      this.wordsMap.put(ch, nn);
    }

    Node get(char ch) {
      return this.wordsMap.get(ch);
    }

    List<Node> getAllNode() {
      ArrayList<Node> res = new ArrayList<>();
      for (char c : this.wordsMap.keySet()) {
        res.add(this.wordsMap.get(c));
      }
      return res;
    }

    void setEnd() {
      isEnd = true;
    }

    boolean isEnd() {
      return this.isEnd;
    }
  }

  Node root;

  Trile() {
    root = new Node();
  }

  public void put(String s) {
    Node curr = root;
    for (char ch : s.toCharArray()) {
      if (!curr.hasWord(ch)) {
        curr.put(ch, new Node());
      }
      curr = curr.get(ch);
    }
    curr.setEnd();
  }

  public boolean search(String s) {
    return search(s, 0, this.root);
  }

  private boolean search(String s, int index, Node curr) {
    if (index == s.length())
      return curr.isEnd();
    char ch = s.charAt(index);
    boolean res = false;
    if (ch == '.') {
      for (Node n : curr.getAllNode()) {
        res |= search(s, index + 1, n);
      }
    } else {
      if (!curr.hasWord(ch))
        return false;
      res |= search(s, index + 1, curr.get(ch));
    }
    return res;
  }

}
