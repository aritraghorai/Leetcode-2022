package Sliding_Window;

import java.util.HashMap;

/*
 !Name: Aritra Ghorai
 !Date:08/05/2022
 ?Program Details:6056. Largest 3-Same-Digit Number in String
 *https://leetcode.com/problems/largest-3-same-digit-number-in-string/
   */
public class Q1_Largest_3_Digit_Same_Number {
    public static void main(String[] args) {
        String num = "2300019";
        System.out.println(largestGoodInteger(num));
    }

    public static String largestGoodInteger(String num) {
        int i = 0, j = 0;
        String res = "";
        char[] numArray = num.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        while (i < num.length() && j < num.length()) {
            if ((j - i + 1) < 3) {
                map.put(numArray[j], map.getOrDefault(numArray[j], 0) + 1);
                j++;
            } else {
                map.put(numArray[j], map.getOrDefault(numArray[j], 0) + 1);
                j++;
                if (map.size() == 1) {
                    String newNum = num.substring(i, j);
                    if (res == "") {
                        res = newNum;
                    } else {
                        if (Integer.parseInt(res) < Integer.parseInt(newNum)) {
                            res = newNum;
                        }
                    }
                }
                map.put(numArray[i], map.get(numArray[i]) - 1);
                if (map.get(numArray[i]) == 0) {
                    map.remove(numArray[i]);
                }
                i++;
            }
        }
        return res;
    }
}
