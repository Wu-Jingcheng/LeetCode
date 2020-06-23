import java.util.*;

public class Solution {
  // 使用array
  public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
    if (n1 == 0)
      return 0;
    int s1cnt = 0, index = 0, s2cnt = 0, s1cnt_pre = 0, s2cnt_pre = 0;
    int[][] map = new int[s2.length()][2];
    Arrays.fill(map, null);
    while (true) {
      s1cnt++;
      for (char c1 : s1.toCharArray()) {
        if (c1 == s2.charAt(index)) {
          index++;
          if (index == s2.length()) {
            index = 0;
            s2cnt++;
          }
        }
      }
      if (s1cnt == n1)
        return s2cnt / n2;
      if (map[index] != null) {
        int[] pair = map[index];
        s1cnt_pre = pair[0];
        s2cnt_pre = pair[1];
        break;
      } else {
        int[] pair = {s1cnt, s2cnt};
        map[index] = pair;
      }
    }
    int s1cnt_in = s1cnt - s1cnt_pre;
    int s2cnt_in = s2cnt - s2cnt_pre;
    int res = s2cnt_pre + (n1 - s1cnt_pre) / s1cnt_in * s2cnt_in;
    int rest = (n1 - s1cnt_pre) % s1cnt_in;
    for (int i = 0; i < rest; i++) {
      for (char c : s1.toCharArray()) {
        if (c == s2.charAt(index)) {
          index++;
          if (index == s2.length()) {
            res++;
            index = 0;
          }
        }
      }
    }
    return res / n2;
  }

  // 使用HashMap
  public int getMaxRepetitions2(String s1, int n1, String s2, int n2) {
    if (n1 == 0)
      return 0;
    int s1cnt = 0, index = 0, s2cnt = 0;
    int s1cnt_pre = 0, s2cnt_pre = 0;
    Map<Integer, int[]> map = new HashMap<Integer, int[]>();
    while (true) {
      s1cnt++;
      for (char c1 : s1.toCharArray()) {
        if (c1 == s2.charAt(index)) {
          index++;
          if (index == s2.length()) {
            s2cnt++;
            index = 0;
          }
        }
      }
      if (s1cnt == n1)
        return s2cnt / n2;
      if (map.containsKey(index)) {
        int[] previous = map.get(index);
        s1cnt_pre = previous[0];
        s2cnt_pre = previous[1];
        break;
      } else {
        int[] pair = new int[2];
        pair[0] = s1cnt;
        pair[1] = s2cnt;
        map.put(index, pair);
      }
    }
    int res = s2cnt_pre + (n1 - s1cnt_pre) / (s1cnt - s1cnt_pre) * (s2cnt - s2cnt_pre);
    int rest = (n1 - s1cnt_pre) % (s1cnt - s1cnt_pre);
    for (int i = 0; i < rest; i++) {
      for (char c : s1.toCharArray()) {
        if (c == s2.charAt(index)) {
          index++;
          if (index == s2.length()) {
            res++;
            index = 0;
          }
        }
      }
    }
    return res / n2;
  }

  public static void main(String[] args) {
    String s1 = "acb", s2 = "ab";
    int n1 = 4, n2 = 2;
    Solution s = new Solution();
    System.out.println(s.getMaxRepetitions(s1, n1, s2, n2));
    s1 = "lovelive";
    s2 = "lovelive";
    n1 = 1;
    n2 = 10;
    System.out.println(s.getMaxRepetitions(s1, n1, s2, n2));
  }

}
