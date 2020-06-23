
public class Solution {

  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0)
      return false;
    int nrows = matrix.length, ncols = matrix[0].length;
    int i = nrows - 1, j = 0;
    while (i >= 0 && j < ncols) {
      if (matrix[i][j] > target)
        i--;
      else if (matrix[i][j] < target)
        j++;
      else
        return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] arr = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}};
    int target1 = 5, target2 = 20;
    boolean res1 = true, res2 = false;

    Solution s = new Solution();
    System.out.println("Checking case1: " + (s.searchMatrix(arr, target1) == res1));
    System.out.println("Checking case2: " + (s.searchMatrix(arr, target2) == res2));
  }

}
