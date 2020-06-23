
public class Solution {
  // The deduction is really interesting
  // we have (a0+1)*(a0+b0+1) different ways with respect to each x
  public int waysToChange(int n) {
    int res = 0;
    for (int i = 0; i * 25 <= n; i++) {
      int rest = n - 25 * i;
      int a = rest / 10;
      int b = rest % 10 / 5;
      res = (int) (res + (long) (a + 1) * (a + b + 1) % 1000000007) % 1000000007;
    }
    return res;
  }

  // DP, but too slow, we can do it mathematically
  public int waysToChange2(int n) {
    int[][] dp = new int[n + 1][3];
    for (int i = 5; i <= n; i++) {
      dp[i][0] = (dp[i - 5][0] + 1) % 1000000007;
      if (i >= 25) {
        dp[i][2] = (dp[i - 25][2] + dp[i - 25][1] + dp[i - 25][0] + 1) % 1000000007;
        dp[i][1] = (dp[i - 10][1] + dp[i - 10][0] + 1) % 1000000007;
      } else if (i >= 10)
        dp[i][1] = (dp[i - 10][1] + dp[i - 10][0] + 1) % 1000000007;
    }
    return (dp[n][0] + dp[n][1] + dp[n][2] + 1) % 1000000007;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.waysToChange(5) == 2);
    System.out.println(s.waysToChange(10) == 4);
  }
}
