package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q18_FInd_Duplicate_In_The_FileSystem {
    public static void main(String[] args) {

    }

    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : paths) {
            String[] path = s.split(" ");
            for (int i = 1; i < path.length; i++) {
                String[] contain = path[i].split("(");
                String sp = contain[1].substring(0, contain[1].length() - 1);
                if (map.containsKey(sp)) {
                    map.get(sp).add(path[0] + "/" + contain[0]);
                } else {
                    map.put(sp, new ArrayList<>());
                    map.get(sp).add(path[0] + "/" + contain[0]);
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s).size() > 1) {
                res.add(map.get(s));
            }
        }
        return res;
    }

}
