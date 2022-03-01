package String;

/*
 !Name: Aritra Ghorai
 !Date:25/02/2022
 ?Program Details:165. Compare Version Numbers
 *https://leetcode.com/problems/compare-version-numbers/
   */
public class Q4_Compare_2_Version {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        while (i < version1.length() && j < version2.length()) {
            int num1 = 0, num2 = 0;
            while (i < version1.length() && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }
            while (j < version2.length() && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }
            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }
            i++;
            j++;
        }
        return 0;
    }
}
