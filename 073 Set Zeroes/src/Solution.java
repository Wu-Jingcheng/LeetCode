
public class Solution {
  // Space Complexity is O(1)
  public void setZeroes(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0)
      return;
    
    // We need to specially handle the case of matrix[0][0]
    boolean rowZero = false, colZero = false;
    for (int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix[0].length; j++)
        if (matrix[i][j] == 0) {
          if (i == 0)
            rowZero = true;
          else
            matrix[i][0] = 0;
          if (j == 0)
            colZero = true;
          else
            matrix[0][j] = 0;
        }

    for (int i = 1; i < matrix.length; i++)
      if (matrix[i][0] == 0)
        for (int j = 1; j < matrix[0].length; j++)
          matrix[i][j] = 0;

    for (int j = 1; j < matrix[0].length; j++)
      if (matrix[0][j] == 0)
        for (int i = 1; i < matrix.length; i++)
          matrix[i][j] = 0;

    if (rowZero)
      for (int j = 0; j < matrix[0].length; j++)
        matrix[0][j] = 0;
    if (colZero)
      for (int i = 0; i < matrix.length; i++)
        matrix[i][0] = 0;
  }

  // Space Complexity is O(m+n)
  public void setZeroes2(int[][] matrix) {
    int[] rows = new int[matrix.length];
    int[] cols = new int[matrix[0].length];
    for (int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix[0].length; j++)
        if (matrix[i][j] == 0) {
          rows[i] = 1;
          cols[j] = 1;
        }

    for (int i = 0; i < rows.length; i++)
      if (rows[i] == 1)
        for (int j = 0; j < cols.length; j++)
          matrix[i][j] = 0;

    for (int j = 0; j < cols.length; j++)
      if (cols[j] == 1)
        for (int i = 0; i < rows.length; i++)
          matrix[i][j] = 0;
  }

  public static void print(int[][] nums) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums[0].length; j++)
        System.out.print(nums[i][j] + "!");
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[][] arr1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    int[][] arr2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
    int[][] arr3 = {{1, 1, 0}, {0, 1, 1}, {1, 1, 1}};
    Solution s = new Solution();
    s.setZeroes(arr1);
    print(arr1);
    s.setZeroes(arr2);
    print(arr2);
    s.setZeroes(arr3);
    print(arr3);
  }

}
