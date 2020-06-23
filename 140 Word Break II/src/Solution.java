import java.util.*;

public class Solution {
  // dp right now
  public List<String> wordBreak(String s, List<String> wordDict) {
    List<String>[] dp = new LinkedList[s.length() + 1];
    dp[0] = new LinkedList<String>(Arrays.asList(""));
    for (int i = 1; i <= s.length(); i++) {
      List<String> list = new LinkedList<String>();
      for (int j = 0; j < i; j++)
        if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i)))
          for (String str : dp[j])
            list.add(str + (str.equals("") ? "" : " ") + s.substring(j, i));
      dp[i] = list;
    }
    return dp[s.length()];
  }

  // backtracking with memory
  public List<String> wordBreak2(String s, List<String> wordDict) {
    int len = s.length();
    List<String>[] list = (List<String>[]) new List[len];
    wordBreakHelper(s, wordDict, list, 0);
    return list[0];
  }

  private void wordBreakHelper(String s, List<String> wordDict, List<String>[] list, int start) {
    List<String> temp = new ArrayList<String>();
    for (String word : wordDict) {
      if (start + word.length() > s.length())
        continue;
      int i;
      for (i = 0; i < word.length() && word.charAt(i) == s.charAt(start + i); i++);
      if (start + i == s.length())
        temp.add(word);
      else if (i == word.length()) {
        if (list[start + i] == null)
          wordBreakHelper(s, wordDict, list, start + i);
        List<String> next = list[start + i];
        for (String followingStr : next)
          temp.add(word + " " + followingStr);
      }
    }
    list[start] = temp;
  }

  public static void main(String[] args) {
    String s1 = "catsanddog", s2 = "pineapplepenapple", s3 = "catsandog";
    List<String> list1 = new ArrayList<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
    List<String> list2 =
        new ArrayList<String>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
    List<String> list3 = new ArrayList<String>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
    Solution s = new Solution();
    System.out.println(s.wordBreak(s1, list1));
    System.out.println(s.wordBreak(s2, list2));
    System.out.println(s.wordBreak(s3, list3));
  }

}
