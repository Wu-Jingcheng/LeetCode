
public class Solution {
  public int hammingDistance(int x, int y) {
    x = x ^ y;
    y = 0;
    while (x != 0) {
      if (x % 2 == 1)
        y++;
      x >>= 1;
    }
    return y;
  }

  public static void main(String[] args) {
    int x = 1, y = 4;
    Solution s = new Solution();
    System.out.println(s.hammingDistance(x, y) == 2);
  }

}
