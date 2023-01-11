package HashMap;

import java.util.HashMap;

/*
 !Name: Aritra Ghorai
 !Date:08/01/2023
 ?Program Details:149. Max Points on a Line
*https://leetcode.com/problems/max-points-on-a-line/
   */
public class Q28_Max_Point_One_line {
    public int maxPoints(int[][] points) {
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            int overlap = 0, vertical = 0, lMax = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    overlap++;
                } else if (points[i][0] == points[j][0]) {
                    vertical++;
                } else {
                    int x = points[j][0] - points[i][0];
                    int y = points[j][1] - points[i][1];
                    String slope = x + " " + y;
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                    lMax = Math.max(lMax, map.get(slope));
                }
                lMax = Math.max(lMax, vertical + 1);
            }
            max = Math.max(max, lMax + overlap + 1);
            map.clear();
        }
        return max;
    }
}
