
public class Solution {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
      res = (res << 1) + (n & 1);
      n >>= 1;
    }
    return res;
  }

  public static void main(String[] args) {
    int n1 = 0b00000010100101000001111010011100, res1 = 0b00111001011110000010100101000000;
    int n2 = 0b11111111111111111111111111111101, res2 = 0b10111111111111111111111111111111;
    Solution s = new Solution();
    System.out.println(s.reverseBits(n1) == res1);
    System.out.println(s.reverseBits(n2) == res2);
  }

}
