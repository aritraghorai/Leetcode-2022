package Greedy;

import java.util.Arrays;

/*
 !Name: Aritra Ghorai
 !Date:01/07/2022
 ?Program Details:1710. Maximum Units on a Truck
 *https://leetcode.com/problems/maximum-units-on-a-truck/
   */
public class Q10_Manimum_Unit_On_The_Track {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> {
            return b[1] - a[1];
        });
        int item = 0;
        for (int[] box : boxTypes) {
            if (truckSize >= box[0]) {
                item += box[0] * box[1];
                truckSize -= box[0];
            } else {
                if (truckSize == 0) {
                    break;
                }
                item += truckSize * box[1];
                truckSize = 0;
            }
        }
        return item;
    }
}
