package HashMap;

/*
 !Name: Aritra Ghorai
 !Date:06/04/2022
 ?Program Details:923. 3Sum With Multiplicity
 *https://leetcode.com/problems/3sum-with-multiplicity/
   */
public class Q10_3_Sum_Multiplicity {
    public int threeSumMultiSlow(int[] arr, int target) {
        long count = 0;
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < arr.length; i++) {
            int[] freq = new int[101];
            for (int j = i + 1; j < arr.length; j++) {
                int k = target - arr[i] - arr[j];
                if (k >= 0 && k <= 100 && freq[k] > 0) {
                    count += freq[k];
                    count %= mod;
                }
                freq[arr[j]]++;
            }
        }
        return (int) count;
    }

    public int threeSumMulti(int[] arr, int target) {
        // *In Constrains we see number range is 0-100
        long[] freq = new long[101];
        int mod = (int) 1e9 + 7;
        long res = 0;
        for (int i : arr) {
            freq[i]++;
        }
        System.out.println(freq[0]);
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k < 0 || k > 100)
                    continue;
                // *i==j and j==k
                if (i == j && j == k) {
                    res += (((freq[i]) * (freq[i] - 1) * (freq[i] - 2)) / 6);
                } else if (i == j && j != k) {
                    res += ((freq[i] * (freq[i] - 1) * freq[k]) / 2);
                } else if (i < j && j < k) {
                    res += (freq[i] * freq[j] * freq[k]);
                }
                res %= mod;
            }
        }
        return (int) res;

    }
}
