
public class Solution {
  public int divide(int dividend, int divisor) { // ������ ����
    if (divisor == -1 && dividend == Integer.MIN_VALUE)
      return Integer.MAX_VALUE; // ���
    int sign = 1;
    if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
      sign = -1;
    if (divisor == 1)
      return dividend;
    if (divisor == -1)
      return -dividend;
    int a = dividend > 0 ? -dividend : dividend;
    int b = divisor > 0 ? -divisor : divisor;
    // ����Ϊ��������Ϊint �ķ�Χ��[2^32, 2^32-1]�����a��-2^32��תΪ����ʱ�������
    // System.out.println(a + " " + b);
    if (a > b)
      return 0;
    int ans = div(a, b);
    return sign == -1 ? -ans : ans;
  }

  int div(int a, int b) {
    if (a > b)
      return 0;
    int count = 1;
    int tb = b;
    while (tb + tb >= a && tb + tb < 0) { // ���֮����С��0
      tb += tb;
      count += count;
      // System.out.println(tb + " " + count + " " + count*b);
    }
    return count + div(a - tb, b);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int dividend = 10, divisor = 3;
    System.out.println(s.divide(dividend, divisor));
    dividend = 7;
    divisor = -3;
    System.out.println(s.divide(dividend, divisor));
  }

}
