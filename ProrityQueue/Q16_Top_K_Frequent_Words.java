package ProrityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/*
 !Name: Aritra Ghorai
 !Date:19/10/2022
?Program Details:692. Top K Frequent Words
*https://leetcode.com/problems/top-k-frequent-words/
  */
public class Q16_Top_K_Frequent_Words {
  public List<String> topKFrequent(String[] words, int k) {
    var map = new HashMap<String, Integer>();
    for (String word : words)
      map.put(word, map.getOrDefault(word, 0) + 1);
    var pq = new PriorityQueue<String>(
        (a, b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b));
    var set = new HashSet<String>();
    for (var word : words) {
      if (set.add(word))
        pq.add(word);
      if (pq.size() > k)
        pq.remove();
    }
    var res = new ArrayList<String>();
    while (!pq.isEmpty())
      res.add(0, pq.remove());
    return res;
  }
}
