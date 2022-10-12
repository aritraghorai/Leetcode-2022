package Design_DS;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:06/10/2022
 ?Program Details:981. Time Based Key-Value Store
*https://leetcode.com/problems/time-based-key-value-store/description/
   */
public class Q9_Time_Based_Key_Value_Pair {

}

class TimeMap {
    HashMap<String, List<Time_Pair>> map = new HashMap<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Time_Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        var li = map.get(key);
        int lb = lowerBound(li, timestamp);
        if (lb == -1) {
            return "";
        }
        return li.get(lb).value;
    }

    private int lowerBound(List<Time_Pair> li, int ele) {
        int low = 0, hi = li.size() - 1;
        if (li.get(low).timestamp > ele) {
            return -1;
        }
        while (low <= hi) {
            int mid = low + (hi - low) / 2;
            if (li.get(mid).timestamp == ele) {
                return mid;
            } else if (li.get(mid).timestamp > ele) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return hi;
    }

}

class Time_Pair {

    int timestamp;
    String value;

    public Time_Pair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }

}
