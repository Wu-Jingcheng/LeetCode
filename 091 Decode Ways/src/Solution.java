
public class Solution {
  // We even don't need a array to do dp, think about this interesting question
  public int numDecodings(String s) {
    if (s.charAt(0) == '0')
      return 0;
    if (s.length() == 1)
      return 1;

    int[] dp = new int[s.length()];
    dp[0] = 1;
    if (s.charAt(1) == '0') {
      if (s.charAt(0) > '2')
        return 0;
      else
        dp[1] = 1;
    } else {
      int together = (s.charAt(0) - '0') * 10 + s.charAt(1) - '0';
      if (together > 26 || together < 10)
        dp[1] = 1;
      else
        dp[1] = 2;
    }

    for (int i = 2; i < s.length(); i++) {
      char pre = s.charAt(i - 1), cur = s.charAt(i);
      if (cur == '0')
        if (pre > '2' || pre == '0')
          return 0;
        else
          dp[i] = dp[i - 2];
      else {
        int together = 10 * (pre - '0') + cur - '0';
        if (together > 26 || together < 10)
          dp[i] = dp[i - 1];
        else
          dp[i] = dp[i - 1] + dp[i - 2];
      }
    }
    return dp[s.length() - 1];
  }

  public static void main(String[] args) {
    String str1 = "12", str2 = "226", str3 = "011", str4 = "101", str5 = "30", str6 = "111100",
        str7 = "111501";
    int res1 = 2, res2 = 3, res3 = 0, res4 = 1, res5 = 0;
    Solution s = new Solution();
    System.out.println(s.numDecodings(str1));
    System.out.println(s.numDecodings(str2));
    System.out.println(s.numDecodings(str3));
    System.out.println(s.numDecodings(str4));
    System.out.println(s.numDecodings(str5));
    System.out.println(s.numDecodings(str6));
    System.out.println(s.numDecodings(str7));
  }

}
