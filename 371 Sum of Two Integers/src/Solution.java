
public class Solution {
  public int getSum(int a, int b) {
    int res = a ^ b;
    int c = (a & b) << 1;
    while (c != 0) {
      int cin = res & c;
      res ^= c;
      c = cin << 1;
    }
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.getSum(1, 2));
    System.out.println(s.getSum(-2, 3));
    System.out.println(s.getSum(500, -10000));
  }

}
