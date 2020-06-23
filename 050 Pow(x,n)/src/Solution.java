
public class Solution {
  public double myPow(double x, int n) {
    long N = n;
    if (N < 0) {
      N = -N;
      x = 1 / x;
    }
    return fastPow(x, N);
  }

  private double fastPow(double x, long n) {
    if (n == 0)
      return 1.;
    double half = fastPow(x, n / 2);
    if (n % 2 == 0)
      return half * half;
    else
      return half * half * x;
  }

  // Straightforward but slow, beyond time limit
  public double myPow2(double x, int n) {
    if (x == 0. || x == 1.)
      return x;
    if (n < 0) {
      x = 1 / x;
      n = -n;
    }
    double res = 1;
    for (; n > 0; n--)
      res *= x;
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.myPow(2., 10));
    System.out.println(s.myPow(2.1, 3));
    System.out.println(s.myPow(2., -2));
  }

}
