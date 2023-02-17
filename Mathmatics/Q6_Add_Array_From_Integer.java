package Mathmatics;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:15/02/2023
 ?Program Details:989. Add to Array-Form of Integer
 *https://leetcode.com/problems/add-to-array-form-of-integer/
   */
public class Q6_Add_Array_From_Integer {
    public static void main(String[] args) {
        int[] num = { 2, 7, 4 };
        System.out.println(addToArrayForm(num, 181));
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int n = k;
        int j = num.length - 1;
        int extra = 0;
        while (j >= 0 && n > 0) {
            int temp = n % 10;
            n /= 10;
            int digit = num[j] + temp;
            j--;
            if (extra == 1) {
                digit += 1;
                extra = 0;
            }
            if (digit > 9) {
                extra = 1;
                res.add(0, digit % 10);
            } else {
                res.add(0, digit);
            }
        }
        while (n > 0) {
            int temp = n % 10;
            n /= 10;
            if (extra == 1) {
                temp += 1;
                extra = 0;
            }
            if (temp > 9) {
                extra = 1;
                res.add(0, temp % 10);
            } else {
                res.add(0, temp);
            }
        }
        while (j >= 0) {
            int temp = num[j];
            if (extra == 1) {
                temp += 1;
                extra = 0;
            }
            if (temp > 9) {
                extra = 1;
                res.add(0, temp % 10);
            } else {
                res.add(0, temp);
            }
            j--;
        }
        if (extra == 1) {
            res.add(0, 1);
        }
        return res;
    }
}
