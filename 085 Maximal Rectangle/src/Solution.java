import java.util.Stack;
import java.util.Arrays;

public class Solution {
  // 优化的dp
  public int maximalRectangle(char[][] matrix) {
    int nrows = matrix.length;
    if (nrows == 0)
      return 0;
    int ncols = matrix[0].length;

    int[] heights = new int[ncols], lefts = new int[ncols], rights = new int[ncols];
    Arrays.fill(rights, ncols);

    int max = 0;

    for (int i = 0; i < nrows; i++) {
      int currentLeft = 0, currentRight = ncols;
      for (int j = 0; j < ncols; j++)
        if (matrix[i][j] == '1') {
          heights[j]++;
          lefts[j] = Math.max(lefts[j], currentLeft);
        } else {
          heights[j] = 0;
          lefts[j] = 0;
          currentLeft = j + 1;
        }
      for (int j = ncols - 1; j >= 0; j--) {
        if (matrix[i][j] == '1')
          rights[j] = Math.min(rights[j], currentRight);
        else {
          rights[j] = ncols;
          currentRight = j;
        }
        max = Math.max(max, heights[j] * (rights[j] - lefts[j]));
      }

    }
    return max;
  }


  // 很棒的dp
  public int maximalRectangle1(char[][] matrix) {
    int nrows = matrix.length;
    if (nrows == 0)
      return 0;
    int ncols = matrix[0].length;

    int[] heights = new int[ncols], lefts = new int[ncols], rights = new int[ncols];
    Arrays.fill(rights, ncols);

    int max = 0;

    for (int i = 0; i < nrows; i++) {
      int currentLeft = 0, currentRight = ncols;
      for (int j = 0; j < ncols; j++)
        if (matrix[i][j] == '1')
          heights[j]++;
        else
          heights[j] = 0;
      for (int j = 0; j < ncols; j++)
        if (matrix[i][j] == '1')
          lefts[j] = Math.max(currentLeft, lefts[j]);
        else {
          lefts[j] = 0;
          currentLeft = j + 1;
        }
      for (int j = ncols - 1; j >= 0; j--) {
        if (matrix[i][j] == '1')
          rights[j] = Math.min(rights[j], currentRight);
        else {
          rights[j] = ncols;
          currentRight = j;
        }
      }
      for (int j = ncols - 1; j >= 0; j--) {
        max = Math.max(max, heights[j] * (rights[j] - lefts[j]));
      }
    }
    return max;
  }


  public int maximalRectangle2(char[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0)
      return 0;
    int nrows = matrix.length, ncols = matrix[0].length;

    int[][] memo = new int[nrows][ncols];

    for (int i = 0; i < nrows; i++)
      for (int j = 0; j < ncols; j++)
        memo[i][j] = (matrix[i][j] == '0' ? 0 : 1 + (j > 0 ? memo[i][j - 1] : 0));

    int max = 0;

    Stack<Integer> stack = new Stack<Integer>();
    stack.push(-1);
    for (int j = 0; j < ncols; j++) {
      for (int i = 0; i < nrows; i++) {
        while (stack.peek() != -1 && memo[i][j] < memo[stack.peek()][j]) {
          int temp = memo[stack.pop()][j] * (i - stack.peek() - 1);
          if (temp > max)
            max = temp;
        }
        stack.push(i);
      }
      while (stack.peek() != -1) {
        int temp = memo[stack.pop()][j] * (nrows - stack.peek() - 1);
        if (temp > max) {
          max = temp;
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
    int output = 6;

    Solution s = new Solution();

    System.out.println("Checking: " + (s.maximalRectangle(matrix)));
  }
}

