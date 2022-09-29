package Two_Pointer;

/*
 !Name: Aritra Ghorai
 !Date:27/09/2022
 ?Program Details:838. Push Dominoes
*https://leetcode.com/problems/push-dominoes/ 
   */
public class Q3_PushDomios {
    public static void main(String[] args) {
        System.out.println(pushDominoes("R.R.L"));
    }

    public static String pushDominoes(String dominoes) {
        char[] res = dominoes.toCharArray();
        int left = 0;
        for (int right = 0; right < dominoes.length(); right++) {
            if (res[right] == '.') {
                // * continue */
                continue;
            } else if (res[right] == res[left] || (res[left] == '.' && res[right] == 'L')) {
                /*
                 * For Cases like
                 * R..R->RRRR or L..L->LLLL
                 * ....L->LLLL
                 */
                for (int k = left; k < right; k++) {
                    res[k] = res[right];
                }
            } else if (res[left] == 'R' && res[right] == 'L') {
                /*
                 * For Cases like
                 * R....L
                 * R...L
                 */
                int m = right - left - 1;
                m /= 2;
                for (int i = 1; i <= m; i++) {
                    res[left + i] = res[left];
                    res[right - i] = res[right];
                }
            }
            left = right;
        }
        // *R..... */
        if (res[left] == 'R') {
            for (int i = left; i < dominoes.length(); i++) {
                res[i] = 'R';
            }
        }
        return new String(res);
    }
}
