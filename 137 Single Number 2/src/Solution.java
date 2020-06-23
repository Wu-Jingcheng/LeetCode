import java.util.*;

public class Solution {
  // We can interpret the code as follows:
  // once records the bits that appear only once.
  // twice records the bits that appear twice
  // each time, when we update them, we need to check whether the bits have been recorded twice
  // why we don't have threeTime?
  // I suppose that's 
  public int singleNumber(int[] nums) {
    int once = 0, twice = 0;
    for (int num : nums) {
      once = ~twice & (once ^ num);
      twice = ~once & (twice ^ num);
    }
    return once;
  }

  // Too slow, hashmap
  public int singleNumber2(int[] nums) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int num : nums)
      map.put(num, map.getOrDefault(num, 0) + 1);
    for (int num : nums)
      if (map.get(num) == 1)
        return num;
    return 0;
  }

  public static void main(String[] args) {
    int[] arr1 = {2, 2, 3, 2}, arr2 = {0, 1, 0, 1, 0, 1, 99};
    Solution s = new Solution();
    System.out.println(s.singleNumber(arr1));
    System.out.println(s.singleNumber(arr2));
  }

}
