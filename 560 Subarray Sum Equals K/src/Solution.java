import java.util.*;

public class Solution {

  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int sum = 0, count = 0;
    map.put(0, 1);
    for (int num : nums) {
      sum += num;
      if (map.containsKey(sum - k))
        count += map.get(sum - k);
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

  public static void main(String[] args) {
    int[] nums = {1, 1, 1};
    Solution s = new Solution();
    System.out.println(s.subarraySum(nums, 2) == 2);
  }

}
