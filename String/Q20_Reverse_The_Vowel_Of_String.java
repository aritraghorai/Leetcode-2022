package String;

import java.util.HashSet;
import java.util.Set;

/*
 !Name: Aritra Ghorai
 !Date:04/11/2022
 ?Program Details: 345. Reverse Vowels of a String
*https://leetcode.com/problems/reverse-vowels-of-a-string/
   */
public class Q20_Reverse_The_Vowel_Of_String {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hellow"));
    }

    public static String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        char[] arr = s.toCharArray();
        int i = 0, j = s.length() - 1;
        int n = s.length();
        while (i < j) {
            for (; i < n; i++) {
                if (set.contains(arr[i])) {
                    break;
                }
            }
            for (; j >= 0; j--) {
                if (set.contains(arr[j])) {
                    break;
                }
            }
            if (i == n || j == -1 || i > j) {
                break;
            }
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);

    }
}
