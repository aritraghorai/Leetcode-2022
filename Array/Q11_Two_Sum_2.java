package Array;

/*
 !Name: Aritra Ghorai
 !Date:09/06/2022
 ?Program Details:167. Two Sum II - Input Array Is Sorted
 *https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/
   */
public class Q11_Two_Sum_2 {
  public int[] twoSum(int[] numbers, int target) {
    int i = 0, j = numbers.length - 1;
    int[] res = new int[2];
    while (i < j) {
      if (numbers[i] + numbers[j] == target) {
        res[0] = i + 1;
        res[1] = j + 1;
        break;
      } else if ((numbers[i] + numbers[j]) > target) {
        j--;
      } else {
        i++;
      }
    }
    return res;
  }
}
