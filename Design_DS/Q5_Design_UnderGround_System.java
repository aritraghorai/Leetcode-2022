package Design_DS;

import java.util.HashMap;

/*
 !Name: Aritra Ghorai
 !Date:24/04/2022
 ?Program Details: 1396. Design Underground System
*https://leetcode.com/problems/design-underground-system/
   */
public class Q5_Design_UnderGround_System {

}

class userPair {
    String stationName;
    int timeTake;

    userPair(String sn, int ti) {
        stationName = sn;
        timeTake = ti;
    }
}

class stationPair {
    int time;
    int count;

    stationPair(int t, int c) {
        time = t;
        count = c;
    }
}

class UndergroundSystem {
    HashMap<Integer, userPair> users;
    HashMap<String, stationPair> path;

    public UndergroundSystem() {
        users = new HashMap<>();
        path = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        users.put(id, new userPair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        var rup = users.remove(id);
        String newKey = rup.stationName + "-" + stationName;
        var removePathPair = path.containsKey(newKey) ? path.remove(newKey) : new stationPair(0, 0);
        removePathPair.time += (t - rup.timeTake);
        removePathPair.count += 1;
        path.put(newKey, removePathPair);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + '-' + endStation;
        var pathPair = path.get(key);
        return (double) pathPair.time / pathPair.count;
    }

}
