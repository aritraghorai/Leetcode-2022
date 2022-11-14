package Design_DS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 !Name: Aritra Ghorai
 !Date:12/11/2022
 ?Program Details: 
   */
public class Q11_Find_Median_Data_Stream {

}

class MedianFinder {
    List<Integer> arr;

    public MedianFinder() {
        arr = new ArrayList<>();
    }

    public void addNum(int num) {
        int idx = Collections.binarySearch(arr, num);
        if (idx >= 0) {
            arr.add(idx, num);
        } else {
            arr.add(-idx - 1, num);
        }
    }

    public double findMedian() {
        int len = arr.size();
        int mid = arr.get(len / 2);
        if (len % 2 == 1) {
            return mid;
        } else {
            return 1.0 * ((arr.get(len / 2 - 1)) + mid) / 2;
        }

    }

}
