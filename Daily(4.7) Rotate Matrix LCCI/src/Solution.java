
public class Solution {

  public void rotate(int[][] matrix) {
    if (matrix.length < 2)
      return;
    int nrows = matrix.length / 2;
    int ncols = matrix.length % 2 == 0 ? nrows : nrows + 1;
    for (int i = 0; i < nrows; i++) {
      for (int j = 0; j < ncols; j++) {
        int temp = matrix[i][j];
        for (int count = 0; count < 4; count++) {
          int nTemp = temp;
          int iTemp = i;
          i = j;
          j = matrix.length - 1 - iTemp;
          temp = matrix[i][j];
          matrix[i][j] = nTemp;
        }
      }
    }
  }

  public static void print(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++)
        System.out.print(matrix[i][j] + "!");
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] matrix2 = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};

    Solution s = new Solution();

    s.rotate(matrix1);
    s.rotate(matrix2);

    print(matrix1);
    print(matrix2);
  }

}
