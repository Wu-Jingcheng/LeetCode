
public class Solution {
  public int movingCount(int m, int n, int k) {
    int[][] dp = new int[m][n];
    if (m == 0 || n == 0 || k < 0)
      return 0;
    dp[0][0] = 1;
    return movingCountCore(1, 0, m, n, k, dp) + movingCountCore(0, 1, m, n, k, dp) + 1;
  }

  private int movingCountCore(int i, int j, int m, int n, int k, int[][] dp) {
    if (i < 0 || i >= m || j < 0 || j >= n || dp[i][j] == 1 || dp[i][j] == -1)
      return 0;
    int count = 0, tmpI = i, tmpJ = j;
    while (tmpI != 0) {
      count += tmpI % 10;
      tmpI /= 10;
    }
    while (tmpJ != 0) {
      count += tmpJ % 10;
      tmpJ /= 10;
    }
    if (count > k) {
      dp[i][j] = -1;
      return 0;
    }
    dp[i][j] = 1;
    return 1 + movingCountCore(i - 1, j, m, n, k, dp) + movingCountCore(i + 1, j, m, n, k, dp)
        + movingCountCore(i, j - 1, m, n, k, dp) + movingCountCore(i, j + 1, m, n, k, dp);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println("Checking case1: " + (s.movingCount(2, 3, 1) == 3));
    System.out.println("Checking case2: " + (s.movingCount(3, 1, 0) == 1));
  }

}
