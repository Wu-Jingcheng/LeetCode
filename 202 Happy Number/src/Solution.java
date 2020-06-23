import java.util.*;

public class Solution {
  public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<Integer>();
    while (n != 1 && !set.contains(n)) {
      set.add(n);
      int res = 0;
      while (n != 0) {
        int digit = n % 10;
        res += digit * digit;
        n /= 10;
      }
      n = res;
    }
    return n == 1;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.isHappy(19));
  }

}
