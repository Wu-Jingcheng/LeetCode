import java.util.*;

public class Solution {
  public int[][] reconstructQueue(int[][] people) {

    // rather fast
    Arrays.sort(people, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        // if the heights are equal, compare k-values
        return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
      }
    });

    List<int[]> output = new LinkedList<>();
    for (int[] p : people) {
      output.add(p[1], p);
    }

    int n = people.length;
    return output.toArray(new int[n][2]);
  }

  // too slow...
  public int[][] reconstructQueue2(int[][] people) {
    Arrays.sort(people, new Comparator<int[]>() {
      public int compare(int[] person1, int[] person2) {
        if (person1[0] == person2[0])
          return person2[1] - person1[1];
        return person1[0] - person2[0];
      }
    });
    print(people);
    int[][] queue = new int[people.length][2];
    boolean[] occupied = new boolean[people.length];
    for (int[] person : people) {
      int len = person[1];
      int i = 0;
      for (; i <= len; i++)
        if (occupied[i])
          len++;
      queue[len] = person;
      occupied[len] = true;
    }
    return queue;
  }

  public static void print(int[][] people) {
    for (int j = 0; j < 2; j++) {
      for (int i = 0; i < people.length; i++)
        System.out.print(people[i][j] + "!");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[][] input = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
    Solution s = new Solution();
    print(s.reconstructQueue(input));
  }

}
