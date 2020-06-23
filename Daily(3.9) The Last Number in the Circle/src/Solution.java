
public class Solution {

  public int lastRemaining(int n, int m) {
    int res = 0;
    for (int i = 2; i <= n; i++) {
      res = (res + m) % i;
    }
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int n1 = 5, m1 = 3, n2 = 10, m2 = 17;

    int res1 = 3, res2 = 2;

    System.out.println("Checking case1: " + (s.lastRemaining(n1, m1) == res1));
    System.out.println("Checking case2: " + (s.lastRemaining(n2, m2) == res2));
  }

}
