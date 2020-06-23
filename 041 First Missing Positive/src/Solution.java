
public class Solution {
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++)
      if (nums[i] <= 0)
        nums[i] = -nums[i] + n + 1;
    for (int num : nums) {
      if (num < 0)
        num = -num;
      if (num > 0 && num <= n && nums[num - 1] > 0)
        nums[num - 1] = -nums[num - 1];
    }
    for (int i = 0; i < n; i++)
      if (nums[i] > 0)
        return i + 1;
    return n + 1;
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 0}, nums2 = {3, 4, -1, 1}, nums3 = {7, 8, 9, 11, 12};
    int res1 = 3, res2 = 2, res3 = 1;
    Solution s = new Solution();
    System.out.println(s.firstMissingPositive(nums1) == res1);
    System.out.println(s.firstMissingPositive(nums2) == res2);
    System.out.println(s.firstMissingPositive(nums3) == res3);
  }

}
