package String;

/*
 !Name: Aritra Ghorai
 !Date:27/06/2022
 ?Program Details:1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
 *https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
   */
public class Q17_Partittion_Into_minimum_number_of_deci_num {
    public int minPartitions(String n) {
        int max = 0;
        for (char ch : n.toCharArray()) {
            max = Math.max(max, ch - '0');
        }
        return max;
    }
}
