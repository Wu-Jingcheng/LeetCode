
public class Solution {

  public int rob(int[] nums) {
    int len = nums.length, max = 0;
    int[] dp = new int[len];
    for (int i = 0; i < len && i < 2; i++) {
      dp[i] = nums[i];
      if (dp[i] > max)
        max = dp[i];
    }
    if (2 < len) {
      dp[2] = dp[0] + nums[2];
      if (dp[2] > max)
        max = dp[2];
    }
    for (int i = 3; i < len; i++) {
      dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
      if (dp[i] > max)
        max = dp[i];
    }
    return max;
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 1};
    int[] nums2 = {2, 7, 9, 3, 1};
    int[] nums3 = {4, 0, 0, 4, 1, 2, 6};
    int res1 = 4, res2 = 12, res3 = 14;

    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.rob(nums1) == res1));
    System.out.println("Checking case2: " + (s.rob(nums2) == res2));
    System.out.println("Checking case3: " + (s.rob(nums3) == res3));

  }

}
