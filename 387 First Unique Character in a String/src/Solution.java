
public class Solution {
  public int firstUniqChar(String s) {
    int len = s.length();
    int[] counts = new int[26];
    for (char c : s.toCharArray())
      counts[c - 'a']++;
    for (int i = 0; i < len; i++)
      if (counts[s.charAt(i) - 'a'] == 1)
        return i;
    return -1;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String str = "leetcode";
    System.out.println(s.firstUniqChar(str));// 0
    str = "loveleetcode";
    System.out.println(s.firstUniqChar(str));// 2
  }

}
