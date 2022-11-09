package Greedy;

/*
 !Name: Aritra Ghorai
 !Date:07/11/2022
 ?Program Details:1323. Maximum 69 Number
 *https://leetcode.com/problems/maximum-69-number/
   */
public class Q16_Maximum_69_Number {
    public int maximum69Number(int num) {
        String numString = new String(num + "");
        for (int i = 0; i < numString.length(); i++) {
            if (numString.charAt(i) == '6') {
                return Integer.parseInt(numString.substring(0, i) + "9" + numString.substring(i + 1));
            }
        }
        return num;
    }
}
