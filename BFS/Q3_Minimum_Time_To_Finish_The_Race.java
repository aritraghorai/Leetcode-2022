package BFS;

/*
 !Name: Aritra Ghorai
 !Date:27/02/2022
 ?Program Details: 
   */
public class Q3_Minimum_Time_To_Finish_The_Race {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        return helper(tires, changeTime, numLaps, 0, 1);
    }

    public int helper(int[][] tires, int changeTime, int numLaps, int index, int indexLap) {
        if (numLaps == 0) {
            return 0;
        }
        if (tires.length == index) {
            return 10000;
        }
        int res = Integer.MAX_VALUE;
        res = Math.min(res, helper(tires, changeTime, numLaps - 1, index, indexLap + 1)
                + tires[index][0] * (int) Math.pow(tires[index][1], indexLap - 1));
        res = Math.min(res, helper(tires, changeTime, numLaps - 1, index, 2) + changeTime
                + tires[index][0]);
        res = Math.min(res, helper(tires, changeTime, numLaps, index + 1, indexLap));
        return res;
    }
}
