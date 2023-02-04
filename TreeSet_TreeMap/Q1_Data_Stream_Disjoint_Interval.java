package TreeSet_TreeMap;

import java.util.ArrayList;
import java.util.TreeSet;

/*
 !Name: Aritra Ghorai
 !Date:28/01/2023
 ?Program Details:352. Data Stream as Disjoint Intervals
*https://leetcode.com/problems/data-stream-as-disjoint-intervals/
   */
public class Q1_Data_Stream_Disjoint_Interval {

}

class SummaryRanges {
    TreeSet<Integer> set;

    public SummaryRanges() {
        set = new TreeSet<>();
    }

    public void addNum(int value) {
        set.add(value);
    }

    public int[][] getIntervals() {
        ArrayList<int[]> res = new ArrayList<>();
        for (int i : set) {
            if (res.isEmpty()) {
                res.add(new int[] { i, i });
            } else {
                if (res.get(res.size() - 1)[1] + 1 == i) {
                    res.get(res.size() - 1)[1] = i;
                } else {
                    res.add(new int[] { i, i });
                }
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
