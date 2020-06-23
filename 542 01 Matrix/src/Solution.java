public class Solution {
  public int[][] updateMatrix(int[][] matrix) {
    if (matrix.length == 0 || matrix.length == 0)
      return new int[0][0];
    int nrows = matrix.length, ncols = matrix[0].length;
    int[][] upleft = new int[nrows][ncols];
    int[][] downright = new int[nrows][ncols];
    for (int i = 0; i < nrows; i++)
      for (int j = 0; j < ncols; j++) {
        if (matrix[i][j] == 0)
          upleft[i][j] = 0;
        else {
          int up = i == 0 ? Integer.MAX_VALUE : upleft[i - 1][j];
          int left = j == 0 ? Integer.MAX_VALUE : upleft[i][j - 1];
          int res = Math.min(up, left);
          upleft[i][j] = res == Integer.MAX_VALUE ? res : res + 1;
        }
      }
    for (int i = nrows - 1; i >= 0; i--)
      for (int j = ncols - 1; j >= 0; j--) {
        if (matrix[i][j] == 0)
          downright[i][j] = 0;
        else {
          int down = i == nrows - 1 ? Integer.MAX_VALUE : downright[i + 1][j];
          int right = j == ncols - 1 ? Integer.MAX_VALUE : downright[i][j + 1];
          int res = Math.min(down, right);
          downright[i][j] = res == Integer.MAX_VALUE ? res : res + 1;
        }
        downright[i][j] = Math.min(upleft[i][j], downright[i][j]);
      }
    return downright;
  }

  public static void print(int[][] mat) {
    for (int[] row : mat) {
      for (int num : row)
        System.out.print(num + "!");
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[][] mat1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    int[][] mat2 = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
    Solution s = new Solution();
    print(s.updateMatrix(mat1));
    print(s.updateMatrix(mat2));
  }

}
