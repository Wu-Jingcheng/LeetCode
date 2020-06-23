
public class Solution {

  public boolean canMeasureWater(int x, int y, int z) {
    if (z > x + y)
      return false;
    if (x == 0 || y == 0)
      return z == 0 || z == x || z == y;
    return z % gcd(x, y) == 0;
  }

  private int gcd(int i, int j) {
    while (i % j != 0) {
      if (i < j) {
        int temp = i;
        i = j;
        i = temp;
      }
      int temp = i;
      i = j % i;
      j = temp;
    }
    return j;
  }

  public static void main(String[] args) {
    int x1 = 3, y1 = 5, z1 = 4;
    int x2 = 2, y2 = 6, z2 = 5;

    Solution s = new Solution();

    System.out.println("Checking case1: " + s.canMeasureWater(x1, y1, z1));
    System.out.println("Checking case2: " + !s.canMeasureWater(x2, y2, z2));
  }

}
