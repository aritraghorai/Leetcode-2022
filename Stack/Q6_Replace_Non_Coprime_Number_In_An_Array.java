package Stack;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:18/03/2022
 ?Program Details:2197. Replace Non-Coprime Numbers in Array
 *https://leetcode.com/problems/replace-non-coprime-numbers-in-array/
   */
public class Q6_Replace_Non_Coprime_Number_In_An_Array {

  public List<Integer> replaceNonCoprimes(int[] nums) {
    var res = new ArrayList<Integer>();
    for (int a : nums) {
      while (true) {
        int b = res.size() == 0 ? 1 : res.get(res.size() - 1);
        int gcd = gcd(a, b);
        if (gcd == 1)
          break;
        res.remove(res.size() - 1);
        a *= b / gcd;
      }
      res.add(a);
    }
    return res;
  }

  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
