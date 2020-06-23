
public class Solution {
  // 排列组合，纯数学 C^(m-1)_(m+n-2)，溢出不知道怎么处理
  public int uniquePaths(int m, int n) {
    return continuousProduct(n, m + n - 2) / continuousProduct(1, m - 1);
  }

  private int continuousProduct(int i, int j) {
    int res = 1;
    while (i <= j)
      res *= i++;
    return res;
  }

  // O(mn)不够简便
  public int uniquePaths2(int m, int n) {
    int[] memo = new int[m];
    memo[0] = 1;
    for (int dummyCount = 0; dummyCount < n; dummyCount++)
      for (int i = 1; i < m; i++)
        memo[i] += memo[i - 1];
    return memo[m - 1];
  }

  // 会超时，回溯
  public int uniquePaths3(int m, int n) {
    if (m == 1 && n == 1)
      return 1;
    if (m < 1 || n < 1)
      return 0;
    return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.uniquePaths(3, 2) == 3));
    System.out.println("Checking case2: " + (s.uniquePaths(7, 3) == 28));
  }

}
