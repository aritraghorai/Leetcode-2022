package Design_DS;

import java.util.Iterator;

/*
 !Name: Aritra Ghorai
 !Date:25/04/2022
 ?Program Details:284. Peeking Iterator
 *https://leetcode.com/problems/peeking-iterator/ 
   */
public class Q6_Peeking_Itarator {

}

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    Integer nextVal;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        it = iterator;
        if (it.hasNext()) {
            nextVal = it.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextVal;

    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int val = nextVal;
        if (it.hasNext()) {
            nextVal = it.next();
        } else {
            nextVal = null;
        }
        return val;
    }

    @Override
    public boolean hasNext() {
        return nextVal != null || it.hasNext();
    }

}
