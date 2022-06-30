package ProrityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 !Name: Aritra Ghorai
 !Date:23/06/2022
 ?Program Details:630. Course Schedule III
 *https://leetcode.com/problems/course-schedule-iii/
   */
public class Q10_Course_Shedule_3 {
    public static void main(String[] args) {
        int[][] courses = { { 5, 15 }, { 3, 19 }, { 6, 7 }, { 2, 10 }, { 5, 16 }, { 8, 14 }, { 10, 11 }, { 2, 19 } };
        System.out.println(scheduleCourse(courses));
    }

    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> {
            return a[1] == b[1] ? a[0] - b[0] : a[1] - b[1];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            pq.offer(course[0]);
            if (time > course[1]) {
                time -= pq.poll();
            }
        }
        return pq.size();
    }
}
