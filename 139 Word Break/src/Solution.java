import java.util.*;

public class Solution {

  // dp
  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; !dp[i] && j < wordDict.size(); j++) {
        dp[i] = checkWord(s, i, wordDict.get(j), dp);
      }
    }

    return dp[s.length()];
  }

  private boolean checkWord(String s, int i, String str, boolean[] dp) {
    if (i < str.length() || !dp[i - str.length()])
      return false;
    i -= str.length();
    for (int j = 0; j < str.length(); j++) {
      if (s.charAt(i + j) != str.charAt(j))
        return false;
    }
    return true;
  }

  // 递归，但是会超时
  public boolean wordBreak2(String s, List<String> wordDict) {
    return wordBreakCore(s, wordDict, 0);
  }

  private boolean wordBreakCore(String s, List<String> wordDict, int index) {
    if (index == s.length())
      return true;
    for (String str : wordDict) {
      if (check(s, index, str) && wordBreakCore(s, wordDict, index + str.length())) {
        return true;
      }
    }
    return false;
  }

  private boolean check(String s, int index, String str) {
    if (str.length() > s.length() - index)
      return false;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != s.charAt(index + i))
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String str1 = "leetcode";
    String[] arr1 = {"leet", "code"};
    List<String> dict1 = new ArrayList<String>(Arrays.asList(arr1));

    String str2 = "applepenapple";
    String[] arr2 = {"apple", "pen"};
    List<String> dict2 = new ArrayList<String>(Arrays.asList(arr2));

    String str3 = "catsandog";
    String[] arr3 = {"cats", "dog", "sand", "and", "cat"};
    List<String> dict3 = new ArrayList<String>(Arrays.asList(arr3));

    boolean res1 = true, res2 = true, res3 = false;

    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.wordBreak(str1, dict1) == res1));
    System.out.println("Checking case2: " + (s.wordBreak(str2, dict2) == res2));
    System.out.println("Checking case3: " + (s.wordBreak(str3, dict3) == res3));
  }

}
