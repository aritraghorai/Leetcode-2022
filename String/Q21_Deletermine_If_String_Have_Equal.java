package String;

/*
 !Name: Aritra Ghorai
 !Date:01/12/2022
 ?Program Details: 1704. Determine if String Halves Are Alike
 *https://leetcode.com/problems/determine-if-string-halves-are-alike/
   */
public class Q21_Deletermine_If_String_Have_Equal {
    private boolean isVoewl(char ch) {
        ch = Character.toLowerCase(ch);
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

    public boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;
        int fristHalf = 0, secondHalf = 0;
        for (int i = 0; i < mid; i++) {
            if (isVoewl(s.charAt(i))) {
                fristHalf++;
            }
        }
        for (int i = mid; i < s.length(); i++) {
            if (isVoewl(s.charAt(i))) {
                secondHalf++;
            }
        }
        return fristHalf == secondHalf;
    }

}
