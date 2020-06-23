
public class Solution {
  public void rotate(int[][] matrix) {
    int nrows = matrix.length;
    if (nrows == 0)
      return;

    int ncols = matrix[0].length;
    if (ncols == 0)
      return;

    boolean isOddFlag = nrows % 2 != 0;

    int iOld, iNew, jOld, jNew;

    for (iOld = 0; iOld <= (isOddFlag ? nrows / 2 : nrows / 2 - 1); iOld++)
      for (jOld = 0; jOld <= ncols / 2 - 1; jOld++) {
        int tempNew, tempOld = matrix[iOld][jOld];
        for (int i = 0; i < 4; i++) {
          iNew = jOld;
          jNew = nrows - 1 - iOld;
          tempNew = matrix[iNew][jNew];
          matrix[iNew][jNew] = tempOld;
          tempOld = tempNew;
          iOld = iNew;
          jOld = jNew;
        }
      }
  }

  public static void print(int[][] matrix) {
    if (matrix.length == 0) {
      System.out.println();
      return;
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++)
        System.out.print(matrix[i][j] + "!");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    Solution s = new Solution();

    print(matrix1);
    s.rotate(matrix1);
    print(matrix1);

    print(matrix2);
    s.rotate(matrix2);
    print(matrix2);
  }

}
