
public class Solution {
  public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    for (int j = 1; j <= p.length() && dp[0][j - 1] && p.charAt(j - 1) == '*'; j++)
      dp[0][j] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= p.length(); j++) {
        char sChar = s.charAt(i - 1), pChar = p.charAt(j - 1);
        if (pChar == '*')
          dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i - 1][j - 1];
        else if (pChar == sChar || pChar == '?')
          dp[i][j] = dp[i - 1][j - 1];
        else
          dp[i][j] = false;
      }
    }
    return dp[s.length()][p.length()];
  }

  public boolean isMatch2(String s, String p) {
    return isMatchCore(s, 0, p, 0);
  }

  private boolean isMatchCore(String s, int i, String p, int j) {
    if (i == s.length())
      return j == p.length() || p.charAt(j) == '*' && isMatchCore(s, i, p, j + 1);
    if (j == p.length())
      return false;
    char sChar = s.charAt(i), pChar = p.charAt(j);
    if (pChar == '*')
      return isMatchCore(s, i + 1, p, j) || isMatchCore(s, i, p, j + 1)
          || isMatchCore(s, i + 1, p, j + 1);
    else if (pChar == '?' || pChar == sChar)
      return isMatchCore(s, i + 1, p, j + 1);
    else
      return false;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String str = "aa", pat = "a";
    System.out.println(s.isMatch(str, pat) == false);
    pat = "*";
    System.out.println(s.isMatch(str, pat) == true);
    str = "cb";
    pat = "?a";
    System.out.println(s.isMatch(str, pat) == false);
    str = "adceb";
    pat = "*a*b";
    System.out.println(s.isMatch(str, pat) == true);
    str = "acdcb";
    pat = "a*c?b";
    System.out.println(s.isMatch(str, pat) == false);
  }

}
