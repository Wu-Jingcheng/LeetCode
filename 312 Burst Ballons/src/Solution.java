
public class Solution {

  // loop
  public int maxCoins(int[] nums) {
    int n = nums.length + 2;
    int[][] memo = new int[n][n];
    int[] copy = new int[n];
    for (int i = 0; i < nums.length; i++)
      copy[i + 1] = nums[i];
    copy[0] = copy[n - 1] = 1;
    for (int left = n - 2; left > -1; left--)
      for (int right = left + 1; right < n; right++)
        for (int i = left + 1; i < right; i++)
          memo[left][right] = Math.max(memo[left][right],
              copy[left] * copy[right] * copy[i] + memo[left][i] + memo[i][right]);
    return memo[0][n - 1];
  }

  // Recursion
  public int maxCoins2(int[] nums) {
    int n = nums.length + 2;
    int[][] memo = new int[n][n];
    int[] copy = new int[n];
    for (int i = 0; i < nums.length; i++)
      copy[i + 1] = nums[i];
    copy[0] = copy[n - 1] = 1;
    return dp(copy, 0, n - 1, memo);
  }

  private int dp(int[] copy, int left, int right, int[][] memo) {
    if (left + 1 == right)
      return 0;
    if (memo[left][right] > 0)
      return memo[left][right];
    int ans = 0;
    for (int i = left + 1; i < right; i++) {
      ans = Math.max(ans,
          copy[i] * copy[left] * copy[right] + dp(copy, left, i, memo) + dp(copy, i, right, memo));
    }
    memo[left][right] = ans;
    return ans;
  }

  public static void main(String[] args) {
    int[] coins = {3, 1, 5, 8};
    Solution s = new Solution();
    System.out.println(s.maxCoins(coins) == 167);
  }

}
