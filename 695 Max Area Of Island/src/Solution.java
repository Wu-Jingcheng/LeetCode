
public class Solution {

  public int maxAreaOfIsland(int[][] grid) {
    if (grid.length == 0 || grid[0].length == 0)
      return 0;
    int nrows = grid.length, ncols = grid[0].length;
    int max = 0;
    for (int i = 0; i < nrows; i++)
      for (int j = 0; j < ncols; j++) {
        int temp = maxAreaCore(grid, i, j, nrows, ncols);
        if (temp > max)
          max = temp;
      }
    return max;
  }

  private int maxAreaCore(int[][] grid, int i, int j, int nrows, int ncols) {
    if (i < 0 || j < 0 || i >= nrows || j >= ncols || grid[i][j] == 0)
      return 0;
    grid[i][j] = 0;
    return 1 + maxAreaCore(grid, i - 1, j, nrows, ncols) + maxAreaCore(grid, i, j - 1, nrows, ncols)
        + maxAreaCore(grid, i + 1, j, nrows, ncols) + maxAreaCore(grid, i, j + 1, nrows, ncols);
  }

  public static void main(String[] args) {
    int[][] arr1 =
        {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
    int[][] arr2 = {{0, 0, 0, 0, 0, 0, 0, 0}};

    Solution s = new Solution();

    System.out.println("Checking arr1: " + (s.maxAreaOfIsland(arr1) == 6));
    System.out.println("Checking arr2: " + (s.maxAreaOfIsland(arr2) == 0));
  }

}
