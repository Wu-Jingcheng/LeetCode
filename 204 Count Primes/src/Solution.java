import java.util.*;

public class Solution {
  // The best way to do O(n*log(logn))
  // A really important point is to understand the spirit of sqrt(n)
  public int countPrimes(int n) {
    if (n < 3)
      return 0;
    boolean[] isComposite = new boolean[n];
    isComposite[0] = true;
    isComposite[1] = true;
    for (int i = 2; i * i < n; i++) {
      if (!isComposite[i])
        for (int j = i * i; j < n; j += i) {
          isComposite[j] = true;
        }
    }
    int count = 0;
    for (boolean flag : isComposite)
      if (!flag)
        count++;
    return count;
  }

  // Too Slow
  public int countPrimes2(int n) {
    Set<Integer> primes = new HashSet<Integer>();
    for (int i = 2; i < n; i++) {
      boolean isPrime = true;
      for (int prime : primes) {
        if (i % prime == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime)
        primes.add(i);
    }
    return primes.size();
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.countPrimes(10));
  }

}
