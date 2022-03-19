package Design_DS;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:19/03/2022
 ?Program Details:895. Maximum Frequency Stack
 *https://leetcode.com/problems/maximum-frequency-stack/ 
   */
public class Q1_Max_Freq_Stack {

}

class FreqStack {
    // *HashMap To Track Freq
    HashMap<Integer, LinkedList<Integer>> freqMap;
    // *Map Elements With Their Freq
    Map<Integer, Integer> elements;
    int maxFreq = 0;

    public FreqStack() {
        freqMap = new HashMap<>();
        elements = new HashMap<>();
    }

    public void push(int val) {
        // *Get The Element New Freqency
        int fre = elements.getOrDefault(val, 0) + 1;
        // *Put Into The Map The New Freq Of Elements
        elements.put(val, fre);
        // *Set The max freq and use it later for pop the element
        maxFreq = Math.max(maxFreq, fre);
        if (!freqMap.containsKey(fre)) {
            freqMap.put(fre, new LinkedList<>());
        }
        freqMap.get(fre).push(val);

    }

    public int pop() {
        int x = freqMap.get(maxFreq).pop();
        if (maxFreq > 1)
            elements.put(x, maxFreq - 1);
        if (freqMap.get(maxFreq).size() == 0)
            maxFreq--;
        return x;
    }

}
