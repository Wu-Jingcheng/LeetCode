
public class Solution {

  public int numIslands(char[][] grid) {
    if (grid.length == 0 || grid[0].length == 0)
      return 0;
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          regiongrowth(grid, i, j);
          count++;
        }
      }
    }
    return count;
  }

  private void regiongrowth(char[][] grid, int i, int j) {
    if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
      grid[i][j] = '0';
      regiongrowth(grid, i - 1, j);
      regiongrowth(grid, i + 1, j);
      regiongrowth(grid, i, j - 1);
      regiongrowth(grid, i, j + 1);
    }
  }

  public static void main(String[] args) {
    char[][] grid1 = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
    char[][] grid2 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
    int output1 = 1, output2 = 3;

    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.numIslands(grid1) == output1));
    System.out.println("Checking case2: " + (s.numIslands(grid2) == output2));
  }
}


