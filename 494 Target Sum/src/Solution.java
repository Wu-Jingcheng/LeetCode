
public class Solution {
  public int findTargetSumWays(int[] nums, int S) {
    int sum = 0;
    for (int num : nums)
      sum += num;
    if (S > sum)
      return 0;
    int[] dp = new int[2 * sum + 1];
    dp[sum] = 1;
    for (int i = 0; i < nums.length; i++) {
      int[] next = new int[2 * sum + 1];
      for (int j = 0; j <= 2 * sum; j++) {
        int num = nums[i];
        int count = 0;
        if (j - num >= 0)
          count += dp[j - num];
        if (j + num <= 2 * sum)
          count += dp[j + num];
        next[j] = count;
      }
      dp = next;
    }
    return dp[sum + S];
  }

  // full dp
  public int findTargetSumWays2(int[] nums, int S) {
    int sum = 0;
    for (int num : nums)
      sum += num;
    if (S > sum)
      return 0;
    int[][] dp = new int[nums.length + 1][2 * sum + 1];
    dp[0][sum] = 1;
    for (int i = 1; i <= nums.length; i++) {
      for (int j = 0; j <= 2 * sum; j++) {
        int num = nums[i - 1];
        int count = 0;
        if (j - num >= 0)
          count += dp[i - 1][j - num];
        if (j + num <= 2 * sum)
          count += dp[i - 1][j + num];
        dp[i][j] = count;
      }
    }
    return dp[nums.length][sum + S];
  }

  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 1, 1};
    int target = 3;
    Solution s = new Solution();
    System.out.println(s.findTargetSumWays(nums, target));
    int[] nums2 = {};
    int target1 = 0, target2 = 3;
    System.out.println(s.findTargetSumWays(nums2, target1));
    System.out.println(s.findTargetSumWays(nums2, target2));
  }

}
