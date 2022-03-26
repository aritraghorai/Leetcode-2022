package Greedy;

/*
 !Name: Aritra Ghorai
 !Date:23/03/2022
 ?Program Details:991. Broken Calculator
 *https://leetcode.com/problems/broken-calculator/
   */
public class Q4_Broken_Calculator {
    public static void main(String[] args) {
        System.out.println(brokenCalc(1, 1000000000));
    }

    public static int brokenCalc(int startValue, int target) {
        int steps = 0;
        // *Intusion We are going to start from target
        // *If Target is odd then add 1
        // *if target is even then divide by two
        while (target > startValue) {
            steps += 1;
            if (target % 2 == 0) {
                target /= 2;
            } else {
                target += 1;
            }
        }
        return steps + (startValue - target);
    }

}
