package Greedy;

/*
 !Name: Aritra Ghorai
 !Date:05/04/2022
 ?Program Details:11. Container With Most Water
 *https://leetcode.com/problems/container-with-most-water/ 
   */
public class Q8_Container_With_Most_Amount_Of_Water {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxAreaValue = 0;
        while (i < j) {
            maxAreaValue = Math.max(maxAreaValue, Math.max(height[i], height[j]) * (j - i));
            if (height[i] >= height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxAreaValue;
    }
}
