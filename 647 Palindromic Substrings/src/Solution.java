import java.util.*;

public class Solution {
  // Manacher
  public int countSubstrings(String s) {
    char[] A = new char[s.length() * 2 + 3];
    A[0] = '@';
    A[1] = '#';
    A[A.length - 1] = '!';
    int t = 2;
    for (char ch : s.toCharArray()) {
      A[t++] = ch;
      A[t++] = '#';
    }
    int[] Z = new int[A.length];
    int center = 0;
    int right = 0;
    for (int i = 1; i < A.length - 1; i++) {
      if (i < right)
        Z[i] = Math.min(right - i, Z[center * 2 - i]);
      while (A[i - Z[i] - 1] == A[i + Z[i] + 1])
        Z[i]++;
      if (i + Z[i] > right) {
        right = i + Z[i];
        center = i;
      }
    }
    int res = 0;
    for (int z : Z) {
      res += (z + 1) / 2;
    }
    return res;
  }

  // A straightforward mindset
  public int countSubstrings2(String s) {
    List<Integer> indices = new ArrayList<Integer>();
    int res = 0;
    for (int index = 0; index < s.length(); index++) {
      indices.add(index);
      indices.add(index - 1);
      for (int i = indices.size() - 1; i >= 0; i--) {
        int pre = indices.get(i);
        if (pre >= 0 && s.charAt(pre) == s.charAt(index)) {
          indices.set(i, pre - 1);
          res++;
        } else
          indices.remove(i);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    String s1 = "abc", s2 = "aaa";
    int res1 = 3, res2 = 6;
    Solution s = new Solution();
    System.out.println(s.countSubstrings(s1) == res1);
    System.out.println(s.countSubstrings(s2) == res2);
  }

}
