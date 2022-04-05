package String;

/*
 !Name: Aritra Ghorai
 !Date:03/04/2022
 ?Program Details:6055. Minimum Number of Operations to Convert Time
 *https://leetcode.com/contest/weekly-contest-287/problems/minimum-number-of-operations-to-convert-time/
 *https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/
   */
public class Q10_Minimum_Number_Of_Operation_Two_Convert_Time {
    public int convertTime(String current, String correct) {
        int currHour = Integer.parseInt(current.substring(0, 2));
        int currMinite = Integer.parseInt(current.substring(3));
        int correctHour = Integer.parseInt(correct.substring(0, 2));
        int correctMinite = Integer.parseInt(correct.substring(3));

        int hourDifferent = correctHour - currHour;
        int miniteDifferent = correctMinite - currMinite;
        if (miniteDifferent < 0) {
            hourDifferent -= 1;
            miniteDifferent += 60;
        }
        int operations = hourDifferent;
        if (miniteDifferent >= 15) {
            operations += (miniteDifferent / 15);
            miniteDifferent %= 15;
        }
        if (miniteDifferent >= 5) {
            operations += (miniteDifferent / 5);
            miniteDifferent %= 5;
        }
        operations += miniteDifferent;
        return operations;
    }
}
