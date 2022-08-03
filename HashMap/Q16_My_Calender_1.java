package HashMap;

import java.util.TreeMap;

/*
 !Name: Aritra Ghorai
 !Date:03/08/2022
 ?Program Details:My Calendar I
 *https://leetcode.com/problems/my-calendar-i/ 
   */
public class Q16_My_Calender_1 {

}

class MyCalendar {
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        // ! start in the middle of any existing entry
        if (map.floorEntry(start) != null && map.floorEntry(start).getValue() > start) {
            return false;
        }
        // !End int the middle of any existing entry
        if (map.ceilingEntry(start) != null && map.ceilingEntry(start).getKey() < end) {
            return false;
        }
        map.put(start, end);
        return true;
    }
}
