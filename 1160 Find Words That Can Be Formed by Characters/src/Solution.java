
public class Solution {

  public int countCharacters(String[] words, String chars) {
    int[] countChars = new int[26];
    for (char c : chars.toCharArray())
      countChars[c - 'a']++;
    int res = 0;
    for (String word : words) {
      int len = word.length();
      int[] countWord = new int[26];
      boolean addable = true;
      for (char ch : word.toCharArray()) {
        if (++countWord[ch - 'a'] > countChars[ch - 'a']) {
          addable = false;
          break;
        }
      }
      if (addable)
        res += len;
    }
    return res;
  }

  public static void main(String[] args) {
    String[] words1 = {"cat", "bt", "hat", "tree"};
    String chars1 = "atach";
    int output1 = 6;

    String[] words2 = {"hello", "world", "leetcode"};
    String chars2 = "welldonehoneyr";
    int output2 = 10;

    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.countCharacters(words1, chars1) == output1));
    System.out.println("Checking case2: " + (s.countCharacters(words2, chars2) == output2));
  }
}


