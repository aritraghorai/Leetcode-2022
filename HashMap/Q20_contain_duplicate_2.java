import java.util.HashMap;

/**
 * Q20_contain_duplicate_2
 */
public class Q20_contain_duplicate_2 {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        if (i - map.get(nums[i]) <= k) {
          return true;
        }
      }
      map.put(nums[i], i);
    }
    return false;
  }
}
