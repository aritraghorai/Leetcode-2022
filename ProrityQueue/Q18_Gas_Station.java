package ProrityQueue;

/*
 !Name: Aritra Ghorai
 !Date:07/01/2023
 ?Program Details:134. Gas Station
*https://leetcode.com/problems/gas-station/description/
   */
public class Q18_Gas_Station {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4 };
        int[] arr2 = { 4, 3, 4 };
        System.out.println(canCompleteCircuit(arr, arr2));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int netCom = 0, curr = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            netCom += gas[i] - cost[i];
            curr += gas[i] - cost[i];
            if (curr < 0) {
                curr = 0;
                start = i + 1;
            }
        }
        if (netCom < 0)
            return -1;
        return start;
    }
}
