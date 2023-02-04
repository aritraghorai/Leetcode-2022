package HashMap;

/*
 !Name: Aritra Ghorai
 !Date:02/02/2023
 ?Program Details:953. Verifying an Alien Dictionary
 *https://leetcode.com/problems/verifying-an-alien-dictionary/
   */
public class Q29_Verifify_Alien_Discnary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] freq = new int[26];
        int seq = 0;
        for (char ch : order.toCharArray()) {
            freq[ch - 'a'] = seq++;
        }
        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            int min = Math.min(curr.length(), next.length());
            if (min != curr.length() && curr.startsWith(next)) {
                return false;
            }
            for (int j = 0; j < min; j++) {
                if (freq[curr.charAt(j) - 'a'] > freq[next.charAt(j) - 'a']) {
                    return false;
                }
                if (freq[curr.charAt(j) - 'a'] < freq[next.charAt(j) - 'a']) {
                    break;
                }
            }
        }
        return true;
    }
}
