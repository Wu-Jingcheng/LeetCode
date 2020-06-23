
public class Solution {
  // catalan
  public int numTrees(int n) {
    long res = 1;
    for (int i = 0; i < n; i++)
      res = (res * 2 * (2 * i + 1) / (i + 2));
    return (int) res;
  }

  public int numTrees2(int n) {
    if (n < 2)
      return 1;
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++)
        dp[i] += dp[j - 1] * dp[i - j];
    }
    return dp[n];
  }

  public static void main(String[] args) {
    int input1 = 3, input2 = 4, output1 = 5, output2 = 14;

    Solution s = new Solution();
    System.out.println("Checking case1: " + (s.numTrees(input1)));
    System.out.println("Checking case2: " + (s.numTrees(input2) == output2));
  }

}
