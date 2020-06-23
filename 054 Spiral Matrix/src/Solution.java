import java.util.*;

public class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<Integer>();
    if (matrix.length == 0 || matrix[0].length == 0)
      return res;
    int nRows = matrix.length;
    int nCols = matrix[0].length;
    int up = 0, left = 0, down = nRows - 1, right = nCols - 1;
    int i, j;
    while (up <= down && left <= right) {
      for (i = up, j = left; j <= right; j++)
        res.add(matrix[i][j]);
      up++;
      for (i = up, j = right; i <= down; i++)
        res.add(matrix[i][j]);
      right--;
      for (i = down, j = right; j >= left && up <= down; j--)
        res.add(matrix[i][j]);
      down--;
      for (i = down, j = left; i >= up && left <= right; i--)
        res.add(matrix[i][j]);
      left++;
    }
    return res;
  }

  public static void main(String[] args) {
    int[][] mat1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] mat2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    Solution s = new Solution();
    System.out.println(s.spiralOrder(mat1));
    System.out.println(s.spiralOrder(mat2));
  }

}
