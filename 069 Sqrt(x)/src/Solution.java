
public class Solution {
  public int mySqrt(int x) {
    if (x == 1)
      return 1;
    long left = 0, right = x;
    while (left < right - 1) {
      long mid = (left + right) / 2;
      if (mid * mid < x)
        left = mid;
      else if (mid * mid > x)
        right = mid;
      else
        return (int)mid;
    }
    return (int)left;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.mySqrt(4));
    System.out.println(s.mySqrt(8));
    System.out.println(s.mySqrt(1));
    System.out.println(s.mySqrt(0));
    System.out.println(s.mySqrt(2147395599));
    int num = 2147395599;
    System.out.println(num);
  }

}
