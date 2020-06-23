
public class Solution {
  public int titleToNumber(String s) {
    int res = 0;
    for (char c : s.toCharArray())
      res = res * 26 + c - '@';
    return res;
  }

  public static void main(String[] args) {
    String str1 = "A", str2 = "AB", str3 = "ZY";
    Solution s = new Solution();
    System.out.println(s.titleToNumber(str1));// 1
    System.out.println(s.titleToNumber(str2));// 28
    System.out.println(s.titleToNumber(str3));// 701
  }

}
