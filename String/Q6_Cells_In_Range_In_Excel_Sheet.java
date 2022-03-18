package String;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:06/03/2022
 ?Program Details:6016. Cells in a Range on an Excel Sheet 
 *https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/
   */
public class Q6_Cells_In_Range_In_Excel_Sheet {
    public static void main(String[] args) {
        System.out.println(cellsInRange("A1:F1"));
    }

    public static List<String> cellsInRange(String s) {
        var res = new ArrayList<String>();
        int range1 = s.charAt(1) - '0';
        int range2 = s.charAt(4) - '0';
        for (char c = s.charAt(0); c <= s.charAt(3); c++) {
            for (int i = range1; i <= range2; i++) {
                res.add(new String(c + "" + i + ""));
            }
        }
        return res;
    }
}
