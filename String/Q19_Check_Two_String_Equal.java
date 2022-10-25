package String;

/*
 !Name: Aritra Ghorai
 !Date:25/10/2022 
 ?Program Details:1662. Check If Two String Arrays are Equivalent 
 *https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
   */
public class Q19_Check_Two_String_Equal {
    public static void main(String[] args) {

    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0;
        int a = 0, b = 0;
        while (a < word1.length && b < word2.length) {
            if (word1[a].charAt(i) != word2[b].charAt(j)) {
                return false;
            }
            i++;
            j++;
            if (i == word1[a].length()) {
                i = 0;
                a++;
            }
            if (j == word2[b].length()) {
                j = 0;
                b++;
            }
        }
        if (a != word1.length || b != word2.length) {
            return false;
        }
        return true;
    }
}
