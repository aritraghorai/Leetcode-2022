package Design_DS;

/*
 !Name: Aritra Ghorai
 !Date:21/04/2022
 ?Program Details:705. Design HashSet
 *https://leetcode.com/problems/design-hashset/
   */
public class Q2_Design_HashSet {

}

class MyHashSet {
    boolean[] arr;

    public MyHashSet() {
        arr = new boolean[(int) Math.pow(10, 6) + 1];
    }

    public void add(int key) {
        arr[key] = true;
    }

    public void remove(int key) {
        arr[key] = false;
    }

    public boolean contains(int key) {
        return arr[key];
    }

}
