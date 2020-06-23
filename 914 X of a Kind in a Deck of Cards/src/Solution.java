import java.util.*;

public class Solution {
  public boolean hasGroupsSizeX(int[] deck) {
    if (deck.length < 2)
      return false;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < deck.length; i++) {
      map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
    }
    int res = map.get(deck[0]);
    for (int value : map.values()) {
      res = gcd(res, value);
      if (res < 2)
        return false;
    }
    return true;
  }

  private int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

  public static void main(String[] args) {
    int[] deck1 = {1, 2, 3, 4, 4, 3, 2, 1}, deck2 = {1, 1, 1, 2, 2, 2, 3, 3}, deck3 = {1},
        deck4 = {1, 1}, deck5 = {1, 1, 2, 2, 2, 2};
    boolean res1 = true, res2 = false, res3 = false, res4 = true, res5 = true;

    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.hasGroupsSizeX(deck1) == res1));
    System.out.println("Checking case2: " + (s.hasGroupsSizeX(deck2) == res2));
    System.out.println("Checking case3: " + (s.hasGroupsSizeX(deck3) == res3));
    System.out.println("Checking case4: " + (s.hasGroupsSizeX(deck4) == res4));
    System.out.println("Checking case5: " + (s.hasGroupsSizeX(deck5) == res5));
  }

}
