package Array;

/*
 !Name: Aritra Ghorai
 !Date:21/02/2022
 ?Program Details:2161. Partition Array According to Given Pivot 
 *https://leetcode.com/problems/partition-array-according-to-given-pivot/
   */
public class Q7_Partition_Array_Given_Pivot {
    public int[] pivotArray(int[] arr, int pivot) {
        int n = arr.length;
        int[] answer = new int[n];
        int left = 0, right = n - 1;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (arr[i] < pivot) {
                answer[left++] = arr[i];
            }
            if (arr[j] > pivot) {
                answer[right--] = arr[j];
            }
        }
        while (left <= right) {
            answer[left++] = pivot;
        }
        return answer;
    }
}
