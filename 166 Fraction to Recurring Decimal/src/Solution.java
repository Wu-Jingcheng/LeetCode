import java.util.*;

public class Solution {
  public String fractionToDecimal(int numerator, int denominator) {
    StringBuffer sb = new StringBuffer();
    long a = (long) numerator;
    long b = (long) denominator;
    if (a * b < 0)
      sb.append('-');
    if (a < 0)
      a = -a;
    if (b < 0)
      b = -b;
    sb.append(a / b);
    a = 10 * (a % b);
    if (a != 0)
      sb.append('.');
    int index = sb.length();
    Map<Long, Integer> map = new HashMap<Long, Integer>();
    for (; a != 0; a = 10 * (a % b)) {
      if (map.containsKey(a)) {
        sb.insert(map.get(a), "(");
        sb.append(')');
        break;
      }
      sb.append(a / b);
      map.put(a, index++);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    int numerator1 = 1, denominator1 = 2;
    int numerator2 = 2, denominator2 = 1;
    int numerator3 = 2, denominator3 = 3;
    Solution s = new Solution();
    System.out.println(s.fractionToDecimal(numerator1, denominator1));
    System.out.println(s.fractionToDecimal(numerator2, denominator2));
    System.out.println(s.fractionToDecimal(numerator3, denominator3));
  }

}
