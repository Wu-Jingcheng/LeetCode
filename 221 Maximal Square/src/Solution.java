import java.util.Arrays;

public class Solution {

  public int maximalSquare(char[][] matrix) {
    int max = 0;
    if (matrix.length == 0 || matrix[0].length == 0)
      return 0;

    int ncols = matrix[0].length;

    int[] heights = new int[ncols], lefts = new int[ncols], rights = new int[ncols];
    Arrays.fill(rights, ncols);
    for (char[] row : matrix) {
      int currentLeft = 0;
      for (int i = 0; i < ncols; i++) {
        lefts[i] = Math.max(lefts[i], currentLeft);
        if (row[i] == '1') {
          heights[i]++;
        } else {
          heights[i] = 0;
          currentLeft = i + 1;
          lefts[i] = 0;
        }
      }

      int currentRight = ncols;
      for (int i = ncols - 1; i >= 0; i--) {
        rights[i] = Math.min(rights[i], currentRight);
        if (row[i] == '0') {
          currentRight = i;
          rights[i] = ncols;
        }
      }

      for (int i = 0; i < ncols; i++) {
        if (row[i] == '1') {
          int current = Math.min(heights[i], (rights[i] - lefts[i]));
          current *= current;
          if (current > max)
            max = current;
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    char[][] arr = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}};
    int output = 4;

    Solution s = new Solution();

    System.out.println("Checking: " + (s.maximalSquare(arr) == output));
  }

}
