import java.util.*;

public class Solution {
  // Method1: dp
  public int superEggDrop(int K, int N) {
    return dp(K, N);
  }

  Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

  private int dp(int K, int N) {
    if (!memo.containsKey(100 * N + K)) {
      int ans;
      if (N == 0)
        ans = 0;
      else if (K == 1)
        ans = N;
      else {
        int lo = 1, hi = N;
        while (lo + 1 < hi) {
          int x = (lo + hi) / 2;
          int t1 = dp(K - 1, x - 1);
          int t2 = dp(K, N - x);
          if (t1 < t2)
            lo = x;
          else if (t1 > t2)
            hi = x;
          else
            lo = hi = x;
        }
        ans = 1 + Math.min(Math.max(dp(K - 1, lo - 1), dp(K, N - lo)),
            Math.max(dp(K - 1, hi - 1), dp(K, N - hi)));

      }
      memo.put(100 * N + K, ans);
    }
    return memo.get(100 * N + K);
  }

  public static void main(String[] args) {
    int K1 = 1, N1 = 2, res1 = 2;
    int K2 = 2, N2 = 6, res2 = 3;
    int K3 = 3, N3 = 14, res3 = 4;
    int K4 = 4, N4 = 3, res4 = 2;
    int K5 = 14, N5 = 14, res5 = 4;
    int K6 = 2, N6 = 2, res6 = 2;
    int K7 = 1, N7 = 14, res7 = 14;
    Solution s = new Solution();
    System.out.println("Checking case1: " + (s.superEggDrop(K1, N1) == res1));
    s = new Solution();
    System.out.println("Checking case2: " + (s.superEggDrop(K2, N2) == res2));
    s = new Solution();
    System.out.println("Checking case3: " + (s.superEggDrop(K3, N3) == res3));
    s = new Solution();
    System.out.println("Checking case4: " + (s.superEggDrop(K4, N4) == res4));
    s = new Solution();
    System.out.println("Checking case5: " + (s.superEggDrop(K5, N5) == res5));
    s = new Solution();
    System.out.println("Checking case6: " + (s.superEggDrop(K6, N6) == res6));
    s = new Solution();
    System.out.println("Checking case7: " + (s.superEggDrop(K7, N7) == res7));
  }

}
