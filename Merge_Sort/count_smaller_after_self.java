package Merge_Sort;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:23/07/2022
 ?Program Details:315. Count of Smaller Numbers After Self
 *https://leetcode.com/problems/count-of-smaller-numbers-after-self/
   */
public class count_smaller_after_self {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        mergePair[] pairs = new mergePair[n];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs[i] = new mergePair(i, nums[i]);
            res.add(0);
        }
        getCounts(pairs, res, 0, n - 1);
        return res;
    }

    private void getCounts(mergePair[] pairs, List<Integer> res, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) >> 1;
        getCounts(pairs, res, low, mid);
        getCounts(pairs, res, mid + 1, high);
        merge(pairs, low, mid, high, res);
    }

    private void merge(mergePair[] pairs, int low, int mid, int high, List<Integer> res) {
        int leftSize = mid - low + 1;
        int rightSize = high - mid;
        mergePair[] leftArray = new mergePair[leftSize];
        mergePair[] rightArray = new mergePair[rightSize];
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = pairs[low + i];
        }
        for (int i = 0; i < rightSize; i++) {
            rightArray[i] = pairs[mid + 1 + i];
        }
        int i = 0, j = 0, k = low, count = 0;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i].num > rightArray[j].num) {
                count++;
                pairs[k] = rightArray[j++];
            } else {
                res.set(leftArray[i].idx, res.get(leftArray[i].idx) + count);
                pairs[k] = leftArray[i++];
            }
            k++;
        }
        while (i < leftSize) {
            res.set(leftArray[i].idx, res.get(leftArray[i].idx) + count);
            pairs[k++] = leftArray[i++];
        }
        while (j < rightSize) {
            pairs[k++] = rightArray[j++];
        }
    }

}

class mergePair {
    int idx;
    int num;

    public mergePair(int idx, int num) {
        this.idx = idx;
        this.num = num;
    }

}
