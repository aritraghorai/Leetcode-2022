package Mathmatics;

/*
 !Name: Aritra Ghorai
 !Date:22/02/2022
 ?Program Details:171. Excel Sheet Column Number
 *https://leetcode.com/problems/excel-sheet-column-number/ 
   */
public class Q3_Excel_Sheet_Colm_Num {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        int n = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            ans += ((columnTitle.charAt(i) - 'A') + 1) * n;
            n *= 26;
        }
        return ans;
    }
}
