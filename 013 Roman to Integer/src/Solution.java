
public class Solution {
  public int romanToInt(String s) {
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int safeIndex = s.length() - 1;
      if (c == 'I') {
        if (i < safeIndex && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
          i++;
          res += s.charAt(i) == 'V' ? 4 : 9;
        } else
          res += 1;
      } else if (c == 'V') {
        res += 5;
      } else if (c == 'X') {
        if (i < safeIndex && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
          i++;
          res += s.charAt(i) == 'L' ? 40 : 90;
        } else
          res += 10;
      } else if (c == 'L') {
        res += 50;
      } else if (c == 'C') {
        if (i < safeIndex && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
          i++;
          res += s.charAt(i) == 'D' ? 400 : 900;
        } else
          res += 100;
      } else if (c == 'D') {
        res += 500;
      } else {
        res += 1000;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String s1 = "III", s2 = "IV", s3 = "IX", s4 = "LVIII", s5 = "MCMXCIV";
    System.out.println(s.romanToInt(s1));
    System.out.println(s.romanToInt(s2));
    System.out.println(s.romanToInt(s3));
    System.out.println(s.romanToInt(s4));
    System.out.println(s.romanToInt(s5));
  }

}
