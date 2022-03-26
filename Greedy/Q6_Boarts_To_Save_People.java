package Greedy;

import java.util.Arrays;

/*
 !Name: Aritra Ghorai
 !Date:24/03/2022
 ?Program Details:881. Boats to Save People
 *https://leetcode.com/problems/boats-to-save-people/ 
   */
public class Q6_Boarts_To_Save_People {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int minNumberOfBoat = 0;
        int i = 0, j = people.length - 1;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                minNumberOfBoat += 1;
                i++;
                j--;
            } else {
                minNumberOfBoat += 1;
                j--;
            }
        }
        return minNumberOfBoat;
    }
}
