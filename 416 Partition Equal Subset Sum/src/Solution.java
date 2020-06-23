
public class Solution {
  // dp, 1 dimension matrix
  public boolean canPartition(int[] nums) {
    if (nums.length == 0)
      return true;
    int sum = 0;
    for (int num : nums)
      sum += num;
    if (sum % 2 != 0)
      return false;
    sum /= 2;
    boolean[] dp = new boolean[sum + 1];
    dp[0] = true;
    for (int num : nums)
      for (int i = sum; i >= 0; i--) {
        if (!dp[i] && i - num >= 0)
          dp[i] = dp[i - num];
        if (dp[sum] == true)
          return true;
      }
    return dp[sum];
  }

  // dp, the last column
  public boolean canPartition4(int[] nums) {
    if (nums.length == 0)
      return true;
    int sum = 0;
    for (int num : nums)
      sum += num;
    if (sum % 2 != 0)
      return false;
    sum /= 2;
    boolean[][] dp = new boolean[nums.length][sum + 1];
    for (int i = 0; i < nums.length; i++)
      dp[i][0] = true;
    for (int i = 1; i < nums.length; i++) {
      for (int j = 1; j <= sum; j++) {
        dp[i][j] = dp[i - 1][j];
        if (!dp[i][j] && j - nums[i] >= 0)
          dp[i][j] = dp[i - 1][j - nums[i]];
        if (j == sum && dp[i][j])
          return true;
      }
    }
    return dp[nums.length - 1][sum];
  }

  // dp, version 1
  public boolean canPartition3(int[] nums) {
    if (nums.length == 0)
      return true;
    int sum = 0;
    for (int num : nums)
      sum += num;
    if (sum % 2 != 0)
      return false;
    sum /= 2;
    boolean[][] dp = new boolean[nums.length][sum + 1];
    for (int i = 0; i < nums.length; i++)
      dp[i][0] = true;
    for (int i = 1; i < nums.length; i++) {
      for (int j = 1; j <= sum; j++) {
        dp[i][j] = dp[i - 1][j];
        if (!dp[i][j] && j - nums[i] >= 0)
          dp[i][j] = dp[i - 1][j - nums[i]];
      }
    }
    return dp[nums.length - 1][sum];
  }

  // Beyond time limit
  public boolean canPartition2(int[] nums) {
    if (nums.length == 0)
      return true;
    int sum = 0;
    for (int num : nums)
      sum += num;
    if (sum % 2 != 0)
      return false;
    return partition(nums, 0, sum / 2);
  }

  private boolean partition(int[] nums, int index, int rem) {
    boolean res = false;
    for (int i = index; i < nums.length && !res; i++) {
      int newRem = rem - nums[i];
      if (newRem == 0)
        return true;
      else if (newRem > 0 && i != nums.length - 1) {
        res = partition(nums, i + 1, newRem);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] arr1 = {1, 5, 11, 5}, arr2 = {1, 2, 3, 5};
    Solution s = new Solution();
    System.out.println("Case1: " + (s.canPartition(arr1) == true));
    System.out.println("Case2: " + (s.canPartition(arr2) == false));
  }

}
