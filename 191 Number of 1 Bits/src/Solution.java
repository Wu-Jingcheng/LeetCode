
public class Solution {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int count = 0;
    for (int i = 1; i != 0; i <<= 1)
      if ((i & n) != 0)
        count++;
    return count;
  }

  public static void main(String[] args) {
    int n1 = 0b00000000000000000000000000001011, n2 = 0b00000000000000000000000010000000,
        n3 = 0b11111111111111111111111111111101;
    Solution s = new Solution();
    System.out.println(s.hammingWeight(n1));// 3
    System.out.println(s.hammingWeight(n2));// 1
    System.out.println(s.hammingWeight(n3));// 31
  }

}
