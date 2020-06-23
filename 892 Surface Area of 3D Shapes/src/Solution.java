
public class Solution {

  public int surfaceArea(int[][] grid) {
    if (grid.length == 0 || grid[0].length == 0)
      return 0;
    int nrows = grid.length, ncols = grid[0].length;
    int res = 0;
    int[][] adj = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    for (int i = 0; i < nrows; i++)
      for (int j = 0; j < ncols; j++) {
        for (int[] pair : adj) {
          int x = i + pair[0], y = j + pair[1];
          if (x >= 0 && x < nrows && y >= 0 && y < ncols) {
            res += grid[i][j] > grid[x][y] ? grid[i][j] - grid[x][y] : 0;
          } else
            res += grid[i][j];
        }
        if (grid[i][j] > 0)
          res += 2;
      }
    return res;
  }

  public static void main(String[] args) {
    int[][] arr1 = {{2}}, arr2 = {{1, 2}, {3, 4}}, arr3 = {{1, 0}, {0, 2}},
        arr4 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    int res1 = 10, res2 = 34, res3 = 16, res4 = 32;

    Solution s = new Solution();

    System.out.println("Chekcing case1: " + (s.surfaceArea(arr1) == res1));
    System.out.println("Checking case2: " + (s.surfaceArea(arr2) == res2));
    System.out.println("Checking case3: " + (s.surfaceArea(arr3) == res3));
    System.out.println("Checking case4: " + (s.surfaceArea(arr4) == res4));
  }

}
