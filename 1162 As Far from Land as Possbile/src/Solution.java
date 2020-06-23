import java.util.*;

public class Solution {
  // 2 dps
  public int maxDistance(int[][] grid) {
    int[][] dp1 = new int[grid.length][grid.length], dp2 = new int[grid.length][grid.length];

    boolean hasWater = false, hasLand = false;
    for (int i = 0; i < grid.length; i++)
      for (int j = 0; j < grid.length; j++)
        if (grid[i][j] == 0) {
          dp1[i][j] =
              Math.min(i - 1 >= 0 ? dp1[i - 1][j] : 200, j - 1 >= 0 ? dp1[i][j - 1] : 200) + 1;
          if (!hasWater)
            hasWater = true;
        } else if (!hasLand)
          hasLand = true;

    if (!hasLand || !hasWater)
      return -1;

    for (int i = grid.length - 1; i >= 0; i--)
      for (int j = grid.length - 1; j >= 0; j--)
        if (grid[i][j] == 0)
          dp2[i][j] = Math.min(i + 1 < grid.length ? dp2[i + 1][j] : 200,
              j + 1 < grid.length ? dp2[i][j + 1] : 200) + 1;

    int max = 0;
    for (int i = 0; i < grid.length; i++)
      for (int j = 0; j < grid.length; j++) {
        int current = Math.min(dp1[i][j], dp2[i][j]);
        if (current > max)
          max = current;
      }

    return max;
  }

  // 多源广度搜索
  public int maxDistance2(int[][] grid) {
    if (grid.length == 0)
      return -1;

    boolean hasWater = false;
    Queue<int[]> queue = new LinkedList<int[]>();
    for (int i = 0; i < grid.length; i++)
      for (int j = 0; j < grid.length; j++)
        if (grid[i][j] == 1) {
          grid[i][j] = 0;
          queue.add(new int[] {i, j});
        } else {
          if (!hasWater)
            hasWater = true;
          grid[i][j] = -1;
        }

    if (!hasWater)
      return -1;

    int count, value = 0;
    while (!queue.isEmpty()) {
      count = queue.size();
      value++;
      for (; count != 0; count--) {
        int[] current = queue.poll();
        int x = current[0] - 1, y = current[1];
        if (x >= 0 && grid[x][y] == -1) {
          grid[x][y] = value;
          queue.add(new int[] {x, y});
        }

        x = current[0] + 1;
        if (x < grid.length && grid[x][y] == -1) {
          grid[x][y] = value;
          queue.add(new int[] {x, y});
        }

        x = current[0];
        y = current[1] - 1;
        if (y >= 0 && grid[x][y] == -1) {
          grid[x][y] = value;
          queue.add(new int[] {x, y});
        }

        y = current[1] + 1;
        if (y < grid.length && grid[x][y] == -1) {
          grid[x][y] = value;
          queue.add(new int[] {x, y});
        }

      }
    }

    return value - 1;
  }

  public static void main(String[] args) {
    int[][] input1 = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
    int[][] input2 = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    int output1 = 2, output2 = 4;

    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.maxDistance(input1)));
    System.out.println("Checking case2: " + (s.maxDistance(input2)));
  }

}
