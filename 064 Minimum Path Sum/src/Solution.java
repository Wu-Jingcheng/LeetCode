
public class Solution {
  public int minPathSum(int[][] grid) {
    int nrows = grid.length, ncols = grid[0].length;
    if (nrows == 0 || ncols == 0)
      return 0;
    int[][] dp = new int[nrows][ncols];
    for (int i = nrows - 1; i >= 0; i--) {
      for (int j = ncols - 1; j >= 0; j--) {
        int temp = Math.min(i + 1 == nrows ? Integer.MAX_VALUE : dp[i + 1][j],
            j + 1 == ncols ? Integer.MAX_VALUE : dp[i][j + 1]);
        dp[i][j] = grid[i][j] + (temp == Integer.MAX_VALUE ? 0 : temp);
      }
    }
    return dp[0][0];
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    int[][] arr1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    int output1 = 7;
    System.out.println("Checking case1: " + (s.minPathSum(arr1) == output1));

    int[][] arr2 = {{1, 7, 2}, {5, 1, 1}};
    int output2 = 8;
    System.out.println("Checking case2: " + (s.minPathSum(arr2) == output2));

    int[][] arr3 = {{}};
    System.out.println("Checking case3: " + (s.minPathSum(arr3) == 0));
  }

}
