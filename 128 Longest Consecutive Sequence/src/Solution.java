import java.util.*;

public class Solution {
  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<Integer>();
    int res = 0;
    for (int num : nums)
      set.add(num);
    for (int num : nums) {
      if (!set.contains(num - 1)) {
        int count = 1;
        while (set.contains(++num))
          count++;
        if (count > res)
          res = count;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] arr1 = {100, 4, 200, 1, 3, 2};
    Solution s = new Solution();

    System.out.println("Checking: " + (s.longestConsecutive(arr1) == 4));
  }

}
