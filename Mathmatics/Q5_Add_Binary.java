package Mathmatics;

/*
 !Name: Aritra Ghorai
 !Date:14/02/2023
 ?Program Details:67. Add Binary
 * https://leetcode.com/problems/add-binary/
   */
public class Q5_Add_Binary {
    public static void main(String[] args) {
        System.out.println(addBinary("1111", "1111"));
    }

    public static String addBinary(String a, String b) {
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        int i = arr1.length - 1, j = arr2.length - 1;
        int extra = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int tempResult = 0;
            if (arr1[i] == '1' && arr2[j] == '1') {
                if (extra == 1) {
                    tempResult = 1;
                    extra = 1;
                } else {
                    tempResult = 0;
                    extra = 1;
                }

            } else if (arr1[i] == '1' || arr2[j] == '1') {
                if (extra == 1) {
                    extra = 1;
                    tempResult = 0;
                } else {
                    extra = 0;
                    tempResult = 1;
                }
            } else {
                if (extra == 1) {
                    extra = 0;
                    tempResult = 1;
                }
            }
            i--;
            j--;
            res.append(tempResult);
        }
        while (i >= 0) {
            int tempResult = 0;
            if (extra == 1) {
                if (arr1[i] == '1') {
                    tempResult = 0;
                    extra = 1;
                } else {
                    tempResult = 1;
                    extra = 0;
                }
            } else {
                if (arr1[i] == '1') {
                    tempResult = 1;
                }
            }
            i--;
            res.append(tempResult);
        }
        while (j >= 0) {
            int tempResult = 0;
            if (extra == 1) {
                if (arr2[j] == '1') {
                    tempResult = 0;
                    extra = 1;
                } else {
                    tempResult = 1;
                    extra = 0;
                }
            } else {
                if (arr2[j] == '1') {
                    tempResult = 1;
                }
            }
            j--;
            res.append(tempResult);
        }
        if (extra == 1) {
            res.append(1);
        }
        return res.reverse().toString();

    }
}
