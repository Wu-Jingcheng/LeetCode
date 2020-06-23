import java.util.*;

public class Solution {
  // 深度优先搜索DFS维持一个flag
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] flags = new int[numCourses];
    List<List<Integer>> followups = new ArrayList<>();
    for (int i = 0; i < numCourses; i++)
      followups.add(new ArrayList<>());
    for (int[] pre : prerequisites)
      followups.get(pre[1]).add(pre[0]);
    for (int i = 0; i < numCourses; i++)
      if (!dfs(followups, flags, i))
        return false;
    return true;
  }

  private boolean dfs(List<List<Integer>> followups, int[] flags, int course) {
    if (flags[course] == 1)
      return false;
    if (flags[course] == -1)
      return true;
    flags[course] = 1;
    for (int followup : followups.get(course)) {
      if (!dfs(followups, flags, followup))
        return false;
    }
    flags[course] = -1;
    return true;
  }

  // 广度优先搜索BFS
  public boolean canFinish2(int numCourses, int[][] prerequisites) {
    List<List<Integer>> followups = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    int[] outdegrees = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      followups.add(new ArrayList<>());
    }
    for (int[] pre : prerequisites) {
      outdegrees[pre[0]]++;
      followups.get(pre[1]).add(pre[0]);
    }
    for (int i = 0; i < numCourses; i++) {
      if (outdegrees[i] == 0)
        queue.add(i);
    }
    while (!queue.isEmpty()) {
      int course = queue.poll();
      numCourses--;
      for (int followup : followups.get(course)) {
        if (--outdegrees[followup] == 0) {
          queue.add(followup);
        }
      }
    }
    return numCourses == 0;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    int num1 = 2, num2 = 2;
    int[][] pre1 = {{1, 0}}, pre2 = {{1, 0}, {0, 1}};

    System.out.println("Checking case1: " + (s.canFinish(num1, pre1) == true));
    System.out.println("Checking case2: " + (s.canFinish(num2, pre2) == false));
  }

}
