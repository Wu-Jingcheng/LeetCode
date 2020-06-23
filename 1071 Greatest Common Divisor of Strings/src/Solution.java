public class Solution {
  // 最优雅的代码在这里
  public String gcdOfStrings2(String str1, String str2) {
    if (!(str1 + str2).equals(str2 + str1))
      return "";
    else
      return str1.substring(0, gcd(str1.length(), str2.length()));
  }

  private int gcd(int i, int j) {
    return j == 0 ? i : gcd(j, i % j);
  }

  private int gcd2(int i, int j) {
    int temp;
    if (j > i) {
      temp = i;
      i = j;
      j = temp;
    }
    while (i != j) {
      if (i - j > j) {
        i = i - j;
      } else {
        temp = i - j;
        i = j;
        j = temp;
      }
    }
    return i;
  }

  // 这个方法复杂度很低，但是不是最优雅的
  public String gcdOfStrings(String str1, String str2) {
    int larger = Math.max(str1.length(), str2.length());
    int less = Math.min(str1.length(), str2.length());
    while (larger != less) {
      if (larger - less > less) {
        larger -= less;
      } else {
        int temp = larger - less;
        larger = less;
        less = temp;
      }
    }
    String divisor = str1.substring(0, less);
    return isDivisor(str1, divisor) && isDivisor(str2, divisor) ? str1.substring(0, less) : "";
  }

  private boolean isDivisor(String str, String divisor) {
    if (str.length() % divisor.length() != 0)
      return false;
    for (int i = 0; i < str.length() / divisor.length(); i++) {
      if (!divisor.equals(str.substring(i * divisor.length(), (i + 1) * divisor.length())))
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String str1 = "ABCABCABC", str2 = "ABC";
    System.out.println("Checking case1: " + (s.gcdOfStrings2(str1, str2).equals("ABC")));

    str1 = "ABABAB";
    str2 = "ABAB";
    System.out.println("Checking case2: " + (s.gcdOfStrings2(str1, str2).equals("AB")));

    str1 = "LEET";
    str2 = "CODE";
    System.out.println("Checking case3: " + (s.gcdOfStrings2(str1, str2).equals("")));

    str1 = "ABABABABAB";
    str2 = "ABABAB";
    System.out.println("Checking case4: " + (s.gcdOfStrings2(str1, str2).equals("AB")));

    str1 = "ABCDEF";
    str2 = "ABC";
    System.out.println("Checking case5: " + (s.gcdOfStrings2(str1, str2).equals("")));
  }

}
