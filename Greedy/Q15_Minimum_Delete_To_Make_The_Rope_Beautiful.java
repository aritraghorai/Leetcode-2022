package Greedy;

/*
 !Name: Aritra Ghorai
 !Date:03/10/2022
 ?Program Details:1578. Minimum Time to Make Rope Colorful
*https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/ 
   */
public class Q15_Minimum_Delete_To_Make_The_Rope_Beautiful {
    public int minCost(String colors, int[] neededTime) {
        char[] arr = colors.toCharArray();
        char preChar = '*';
        int preCost = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (preChar == arr[i]) {
                if (preCost < neededTime[i]) {
                    res += preCost;
                    preCost = neededTime[i];
                    preChar = arr[i];
                } else {
                    res += neededTime[i];
                }
            } else {
                preChar = arr[i];
                preCost = neededTime[i];
            }
        }
        return res;
    }
}
