enum Result {
  TRUE, FALSE
}


public class Solution {
  Result[][] memo;

  // dp-bottomToTop
  public boolean isMatch3(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[s.length()][p.length()] = true;
    for (int i = s.length(); i >= 0; i--)
      for (int j = p.length() - 1; j >= 0; j--) {
        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j + 1 < p.length() && p.charAt(j+1) == '*')
          dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
        else
          dp[i][j] = firstMatch && dp[i + 1][j + 1];
      }
    return dp[0][0];
  }

  // dp-topToBottom
  public boolean isMatch2(String s, String p) {
    memo = new Result[s.length() + 1][p.length() + 1];
    return dp(0, 0, s, p);
  }

  private boolean dp(int i, int j, String s, String p) {
    if (memo[i][j] != null)
      return memo[i][j] == Result.TRUE;
    boolean ans;
    if (j == p.length())
      ans = i == s.length();
    else {
      boolean firstMatch = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

      if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
        ans = dp(i, j + 2, s, p) || firstMatch && dp(i + 1, j, s, p);
      } else {
        ans = firstMatch && dp(i + 1, j + 1, s, p);
      }
    }
    memo[i][j] = ans ? Result.TRUE : Result.FALSE;
    return ans;
  }

  // 普通的回溯法
  public boolean isMatch(String s, String p) {
    char[] str = s.toCharArray();
    char[] pat = p.toCharArray();
    if (pat.length == 0)
      return false;
    return isMatchCore(str, pat, 0, 0);
  }

  private boolean isMatchCore(char[] s, char[] p, int i, int j) {
    if (i == s.length && j == p.length)
      return true;
    if (i < s.length && j == p.length)
      return false;
    if (j < p.length - 1 && p[j + 1] == '*') {
      if (i < s.length && (s[i] == p[j] || p[j] == '.'))
        return isMatchCore(s, p, i + 1, j) || isMatchCore(s, p, i + 1, j + 2)
            || isMatchCore(s, p, i, j + 2);
      else
        return isMatchCore(s, p, i, j + 2);
    }
    if (i < s.length && (s[i] == p[j] || p[j] == '.'))
      return isMatchCore(s, p, i + 1, j + 1);
    return false;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    String s1 = "aa";
    String p1 = "a";

    String s2 = "aa";
    String p2 = "a*";

    String s3 = "ab";
    String p3 = ".*";

    String s4 = "aab";
    String p4 = "c*a*b";

    String s5 = "mississippi";
    String p5 = "mis*is*p*.";

    String s6 = "ab";
    String p6 = ".*..";

    System.out.println("Checking case1: " + !s.isMatch3(s1, p1));
    System.out.println("Checking case2: " + s.isMatch3(s2, p2));
    System.out.println("Checking case3: " + s.isMatch3(s3, p3));
    System.out.println("Checking case4: " + s.isMatch3(s4, p4));
    System.out.println("Checking case5: " + !s.isMatch3(s5, p5));
    System.out.println("Checking case4: " + s.isMatch3(s6, p6));
  }

}
