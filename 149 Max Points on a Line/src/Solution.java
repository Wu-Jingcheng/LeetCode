import java.util.*;

public class Solution {
  // We can use the point as the key
  // And why not use [-1,-1] as a special region to store the same points
  public int maxPoints(int[][] points) {
    final int len = points.length;
    if (len < 2)
      return len;
    int res = 0;
    @SuppressWarnings("unchecked")
    Map<Integer, Map<Integer, Integer>>[] maps = new HashMap[len];
    for (int i = 0; i < len; i++)
      maps[i] = new HashMap<Integer, Map<Integer, Integer>>();
    for (int i = 0; i < len - 1; i++)
      for (int j = i + 1; j < len; j++) {
        int x1 = points[i][0], y1 = points[i][1];
        int x2 = points[j][0], y2 = points[j][1];
        int x, y;
        if (x1 == x2 && y1 == y2) {
          x = -1;
          y = -1;
        } else if (x1 == x2) {
          x = x1;
          y = 0;
        } else if (y1 == y2) {
          y = y1;
          x = 0;
        } else {
          x = x1 - x2;
          y = y1 - y2;
          boolean positive = x * y > 0;
          if (x < 0)
            x = -x;
          if (y < 0)
            y = -y;
          int xygcd = gcd(x, y);
          x = x / xygcd;
          y = positive ? y / xygcd : -y / xygcd;
        }

        Map<Integer, Map<Integer, Integer>> iMap = maps[i];
        Map<Integer, Map<Integer, Integer>> jMap = maps[j];
        if (!iMap.containsKey(x))
          iMap.put(x, new HashMap<Integer, Integer>());
        if (!jMap.containsKey(x))
          jMap.put(x, new HashMap<Integer, Integer>());

        Map<Integer, Integer> iSubMap = iMap.get(x);
        Map<Integer, Integer> jSubMap = jMap.get(x);
        iSubMap.put(y, iSubMap.getOrDefault(y, 1) + 1);
        jSubMap.put(y, jSubMap.getOrDefault(y, 1) + 1);

        int iTemp, jTemp;
        if (x != -1 || y != -1) {
          if (iMap.containsKey(-1) && iMap.get(-1).containsKey(-1))
            iTemp = iMap.get(-1).get(-1) + iSubMap.get(y) - 1;
          else
            iTemp = iSubMap.get(y);
          if (jMap.containsKey(-1) && jMap.get(-1).containsKey(-1))
            jTemp = jMap.get(-1).get(-1) + jSubMap.get(y) - 1;
          else
            jTemp = jSubMap.get(y);
        } else {
          iTemp = iMap.get(-1).get(-1);
          jTemp = jMap.get(-1).get(-1);
        }
        res = Math.max(res, Math.max(iTemp, jTemp));
      }
    return res;
  }

  private int gcd(int i, int j) {
    if (i < j) {
      int temp = i;
      i = j;
      j = temp;
    }
    if (j == 0)
      return i;
    return gcd(j, i % j);
  }

  // We can use the point as the key
  public int maxPoints2(int[][] points) {
    final int len = points.length;
    if (len < 2)
      return len;
    Map<Integer, Map<Integer, Set<Set<int[]>>>> map =
        new HashMap<Integer, Map<Integer, Set<Set<int[]>>>>();
    int res = 0;
    for (int i = 0; i < len - 1; i++)
      for (int j = i + 1; j < len; j++) {
        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];
        int x, y;
        if (x1 == x2) {
          x = x1;
          y = 0;
        } else if (y1 == y2) {
          y = y1;
          x = 0;
        } else {
          x = x1 - x2;
          y = y1 - y2;
          boolean positive = x * y > 0;
          if (x < 0)
            x = -x;
          if (y < 0)
            y = -y;
          int xygcd = gcd(x, y);
          x = x / xygcd;
          y = (positive ? y / xygcd : -y / xygcd);
        }
        if (!map.containsKey(x))
          map.put(x, new HashMap<Integer, Set<Set<int[]>>>());
        Map<Integer, Set<Set<int[]>>> yMap = map.get(x);
        if (!yMap.containsKey(y))
          yMap.put(y, new HashSet<Set<int[]>>());
        Set<Set<int[]>> set1 = yMap.get(y);
        boolean hasPoint = false;
        for (Set<int[]> set2 : set1) {
          if (set2.contains(points[i]) || set2.contains(points[j])) {
            hasPoint = true;
            set2.add(points[i]);
            set2.add(points[j]);
            if (set2.size() > res)
              res = set2.size();
            break;
          }
        }
        if (!hasPoint) {
          Set<int[]> set2 = new HashSet<int[]>();
          set2.add(points[i]);
          set2.add(points[j]);
          if (2 > res)
            res = 2;
          set1.add(set2);
        }
      }
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] plane1 = {{1, 1}, {2, 2}, {3, 3}};// 3
    int[][] plane2 = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};// 4
    int[][] plane3 = {{1, 1}, {5, 3}, {4, 1}, {1, 4}};// 2
    int[][] plane4 = {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 1}, {1, 0}};// 8
    int[][] plane5 = {{1, 1}, {1, 1}, {2, 2}, {2, 2}};// 4
    System.out.println(s.maxPoints(plane1));
    System.out.println(s.maxPoints(plane2));
    System.out.println(s.maxPoints(plane3));
    System.out.println(s.maxPoints(plane4));
    System.out.println(s.maxPoints(plane5));
  }

}
