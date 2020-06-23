
public class Solution {

  public int myAtoi(String str) {
    int index = 0;
    int res = 0;
    int sign = 1;
    int len = str.length();
    for (; index < len && str.charAt(index) == ' '; index++);

    if (index == len)
      return 0;
    else if (str.charAt(index) == '-') {
      sign = -1;
      index++;
    } else if (str.charAt(index) == '+')
      index++;

    final int MAX_RES = Integer.MAX_VALUE / 10, MAX_REM = Integer.MAX_VALUE % 10,
        MIN_RES = -(Integer.MIN_VALUE / 10), MIN_REM = -(Integer.MIN_VALUE % 10);

    for (; index < len && str.charAt(index) >= '0' && str.charAt(index) <= '9'; index++) {
      int current = str.charAt(index) - '0';
      if (sign == 1 && (res > MAX_RES || res == MAX_RES && current > MAX_REM))
        return Integer.MAX_VALUE;
      else if (sign == -1 && (res > MIN_RES || res == MIN_RES && current > MIN_REM))
        return Integer.MIN_VALUE;
      res = res * 10 + current;
    }

    return sign * res;
  }

  public static void main(String[] args) {
    String s1 = "42", s2 = "    -42", s3 = "4193 with words", s4 = "words and 987",
        s5 = "-91283472332", s6 = "-2147483648", s7 = "+2147483647", s8 = "-2147483649",
        s9 = "2147483648";

    int r1 = 42, r2 = -42, r3 = 4193, r4 = 0, r5 = Integer.MIN_VALUE, r6 = Integer.MIN_VALUE,
        r7 = Integer.MAX_VALUE, r8 = Integer.MIN_VALUE, r9 = Integer.MAX_VALUE;

    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.myAtoi(s1) == r1));
    System.out.println("Checking case2: " + (s.myAtoi(s2) == r2));
    System.out.println("Checking case3: " + (s.myAtoi(s3) == r3));
    System.out.println("Checking case4: " + (s.myAtoi(s4) == r4));
    System.out.println("Checking case5: " + (s.myAtoi(s5) == r5));
    System.out.println("Checking case6: " + (s.myAtoi(s6) == r6));
    System.out.println("Checking case7: " + (s.myAtoi(s7) == r7));
    System.out.println("Checking case8: " + (s.myAtoi(s8) == r8));
    System.out.println("Checking case9: " + (s.myAtoi(s9) == r9));
  }

}
