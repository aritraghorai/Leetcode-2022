package String;

/*
 !Name: Aritra Ghorai
 !Date:07/05/2022
 ?Program Details:2259. Remove Digit From Number to Maximize Result
 *https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/
   */
public class Q14_Remove_DIgit_For_Maximize_Result {
    public String removeDigit(String number, char digit) {
        char[] numArray = number.toCharArray();
        int position = -1;
        StringBuilder sb = new StringBuilder(number);
        for (int i = 0; i < numArray.length - 1; i++) {
            if (numArray[i] == digit && numArray[i] < numArray[i + 1]) {
                position = i;
                break;
            }
        }
        if (position == -1) {
            return sb.deleteCharAt(number.lastIndexOf(digit)).toString();
        }
        return sb.deleteCharAt(position).toString();
    }
}
