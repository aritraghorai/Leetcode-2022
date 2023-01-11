package ProrityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q17_Remove_Stone_To_Minimize_Cost {
    public static void main(String[] args) {

    }

    public int minStoneSum(int[] piles, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : piles) {
            pq.offer(i);
        }
        while (k > 0) {
            int rn = pq.poll();
            int half = (int) Math.round((double) (rn) / 2.0);
            if (half == 0) {
                continue;
            }
            pq.offer(half);
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
}
