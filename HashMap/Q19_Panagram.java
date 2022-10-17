package HashMap;

import java.util.HashSet;

/*
 !Name: Aritra Ghorai
 !Date:17/10/2022
?Program Details:1832. Check if the Sentence Is Pangram
*https://leetcode.com/problems/check-if-the-sentence-is-pangram/
  */
public class Q19_Panagram {
  public static void main(String[] args) {

  }

  public boolean checkIfPangram(String sentence) {
    HashSet<Character> set = new HashSet<>();
    for (char ch : sentence.toCharArray()) {
      set.add(ch);
    }
    return set.size() == 26;
  }

}
