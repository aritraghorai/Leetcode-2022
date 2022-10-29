package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 !Name: Aritra Ghorai
 !Date:28/10/2022
 ?Program Details:49. Group Anagrams
 *https://leetcode.com/problems/group-anagrams/ 
   */
public class Q22_GroupAnagram {

  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
      char[] arr = s.toCharArray();
      Arrays.sort(arr);
      String key = new String(arr);
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(s);
    }
    List<List<String>> res = new ArrayList<>();
    for (String a : map.keySet()) {
      res.add(map.get(a));
    }
    return res;
  }

}
