import java.util.*;

public class Solution {

  public int numSquares
  // Nice try, but exceed the time limit(ver. 1)
  // Now we have a map(ver. 2), still out of time limit
  public int numSquares2(int n) {
    int i;
    for (i = 1; i * i <= n; i++);
    i--;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    return numSquaresCore(n, i, map);
  }

  private int numSquaresCore(int n, int i, Map<Integer, Integer> map) {
    if (map.containsKey(n))
      return map.get(n);
    int res = Integer.MAX_VALUE;
    for (; i > 0; i--) {
      if (i * i < n) {
        res = Math.min(numSquaresCore(n - i * i, i, map), res);
      } else if (i * i == n)
        return 1;
    }
    if (res != Integer.MAX_VALUE) {
      map.put(null, 1 + res);
      return 1 + res;
    } else
      return res;
  }

  public static void main(String[] args) {
    int n1 = 12, n2 = 13, n3 = 1, n4 = 3;
    int res1 = 3, res2 = 2, res3 = 1, res4 = 3;

    Solution s = new Solution();

    System.out.println("Case1: " + (s.numSquares(n1) == res1));
    System.out.println("Case2: " + (s.numSquares(n2) == res2));
    System.out.println("Case3: " + (s.numSquares(n3) == res3));
    System.out.println("Case4: " + (s.numSquares(n4) == res4));
  }

}
