package String;

/*
 !Name: Aritra Ghorai
 !Date:31/08/2022
 ?Program Details:557. Reverse Words in a String III
 *https://leetcode.com/problems/reverse-words-in-a-string-iii/
   */
public class Q18_Remove_Word_In_String_III {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String ele : arr) {
            res.append(new StringBuilder(ele).reverse().toString() + " ");
        }
        return res.substring(0, res.length() - 1).toString();
    }

}
