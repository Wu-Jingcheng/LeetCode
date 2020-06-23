import java.util.*;

public class Solution {
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    final int n = A.length;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        map.put(-A[i] - B[j], map.getOrDefault(-A[i] - B[j], 0) + 1);
    int res = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (map.containsKey(C[i] + D[j]))
          res += map.get(C[i] + D[j]);
    return res;
  }

  public static void main(String[] args) {
    int[] A = {1, 2}, B = {-2, -1}, C = {-1, 2}, D = {0, 2};
    Solution s = new Solution();
    System.out.println(s.fourSumCount(A, B, C, D));// 2
  }

}
