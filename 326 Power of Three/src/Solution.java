
public class Solution {
  // try it
  public boolean isPowerOfThree(int n) {
    if (n == 0)
      return false;
    int divisor = 3;
    int preDivisor = 1;
    for (; n % divisor == 0; preDivisor = divisor, divisor *= divisor);
    for (divisor = preDivisor; n % divisor == 0; preDivisor = divisor, divisor *= 3);
    return preDivisor == n;
  }

  // too slow
  public boolean isPowerOfThree2(int n) {
    if (n == 0)
      return false;
    for (; n % 3 == 0; n /= 3);
    return n == 1;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.isPowerOfThree(27));// true
    System.out.println(s.isPowerOfThree(0));// false
    System.out.println(s.isPowerOfThree(9));// true
    System.out.println(s.isPowerOfThree(45));// false
  }

}
