
public class Solution {
  public int missingNumber(int[] nums) {
    int res = 0;
    for (int i = 0; i <= nums.length; i++)
      res ^= i;
    for (int num : nums)
      res ^= num;
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums1 = {3, 0, 1};
    int[] nums2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
    System.out.println(s.missingNumber(nums1));// 2
    System.out.println(s.missingNumber(nums2));// 8
  }

}
