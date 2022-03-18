package Stack;

import java.util.LinkedList;
import java.util.Scanner;

/*
 !Name: Aritra Ghorai
 !Date:18/03/2022
 ?Program Details:316. Remove Duplicate Letters
 *https://leetcode.com/problems/remove-duplicate-letters/
   */
public class Q5_Remove_Duplicate_From_Latters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(removeDuplicateLetters(s));
        sc.close();
    }

    public static String removeDuplicateLetters(String s) {
        // *To Store The last Index of every character
        int[] lastIndex = new int[26];
        char[] words = s.toCharArray();
        // *To Track Wether the word is already in the stack
        boolean[] isPut = new boolean[26];
        var stack = new LinkedList<Integer>();
        // *Calculating the last index of the word
        for (int i = 0; i < words.length; i++) {
            lastIndex[words[i] - 'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            while (!stack.isEmpty() && words[stack.peek()] >= words[i] && lastIndex[words[stack.peek()] - 'a'] > i
                    && !isPut[words[i] - 'a']) {
                isPut[words[stack.pop()] - 'a'] = false;
            }
            if (!isPut[words[i] - 'a']) {
                stack.push(i);
                isPut[words[i] - 'a'] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(words[stack.pop()]);
        }
        return sb.reverse().toString();
    }
}
