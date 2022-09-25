package Design_DS;

/*
 !Name: Aritra Ghorai
 !Date:25/09/2022
 ?Program Details:622. Design Circular Queue
*https://leetcode.com/problems/design-circular-queue/
   */
public class Q8_Design_Circular_Queue {

}

class MyCircularQueue {
    int[] arr;
    int f = 0;
    int si = 0;

    public MyCircularQueue(int k) {
        arr = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        arr[(f + si) % arr.length] = value;
        si++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        f += 1;
        f %= arr.length;
        si--;
        return false;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[f];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(f + si) % arr.length];
    }

    public boolean isEmpty() {
        return this.si == 0;
    }

    public boolean isFull() {
        return si == arr.length;
    }
}
