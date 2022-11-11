package Stack;

/*
 !Name: Aritra Ghorai
 !Date:11/11/2022
 ?Program Details: 
   */
public class Q12_Remove_Duplicate_From_Sorted_Array {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
    }

    public static int removeDuplicates(int[] nums) {
        int k = 0;
        int i = 0, j = 0;
        int n = nums.length;
        while (j < n) {
            while (j < n && nums[j] == nums[i]) {
                j++;
            }
            nums[k++] = nums[i];
            i = j;
        }
        return k;
    }
}
