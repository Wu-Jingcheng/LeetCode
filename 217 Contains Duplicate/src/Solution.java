import java.util.*;

public class Solution {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<Integer>();
    for (int num : nums) {
      if (set.contains(num))
        return true;
      set.add(num);
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 1}, nums2 = {1, 2, 3, 4}, nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
    Solution s = new Solution();
    System.out.println(s.containsDuplicate(nums1));// true
    System.out.println(s.containsDuplicate(nums2));// false
    System.out.println(s.containsDuplicate(nums3));// true
  }

}
