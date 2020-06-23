
public class Solution {
  public int trailingZeroes(int n) {
    int count = 0;
    while (n > 0) {
      n /= 5;
      count += n;
    }
    return count;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.trailingZeroes(3));// 0
    System.out.println(s.trailingZeroes(5));// 1
    System.out.println(s.trailingZeroes(13));// 2
    System.out.println(s.trailingZeroes(7));// 1
    System.out.println(s.trailingZeroes(30));// 7
    System.out.println(s.trailingZeroes(625));// 156
  }

}
