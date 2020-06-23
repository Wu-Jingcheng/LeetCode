import java.util.*;

public class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    List<Integer> list = new LinkedList<Integer>();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int num1 : nums1)
      map.put(num1, map.getOrDefault(num1, 0) + 1);
    for (int num2 : nums2) {
      if (map.getOrDefault(num2, 0) > 0) {
        map.put(num2, map.get(num2) - 1);
        list.add(num2);
      }
    }
    int[] res = new int[list.size()];
    for (int i = 0; i < res.length; i++)
      res[i] = list.get(i);
    return res;
  }

  public static void print(int[] nums) {
    for (int num : nums)
      System.out.print(num + "!");
    System.out.println();
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
    print(s.intersect(nums1, nums2));// 2,2
    nums1 = new int[] {4, 9, 5};
    nums2 = new int[] {9, 4, 9, 8, 4};
    print(s.intersect(nums1, nums2));// 4,9
  }

}
