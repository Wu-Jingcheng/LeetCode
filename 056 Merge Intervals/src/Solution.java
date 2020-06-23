import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  public int[][] merge(int[][] intervals) {
    if (intervals.length < 2)
      return intervals;
    Arrays.sort(intervals, new Comparator<int[]>() {
      public int compare(int[] arr1, int[] arr2) {
        return arr1[0] - arr2[0];
      }
    });
    int len = 0, start = intervals[0][0], end = intervals[0][1];
    for (int i = 1; i < intervals.length; i++)
      if (intervals[i][0] > end) {
        end = intervals[i][1];
        len++;
      } else if (intervals[i][1] > end)
        end = intervals[i][1];
    len++;
    end = intervals[0][1];
    int[][] res = new int[len][2];
    int index = 0;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] > end) {
        res[index][0] = start;
        res[index++][1] = end;
        start = intervals[i][0];
        end = intervals[i][1];
      } else {
        if (intervals[i][0] < start)
          start = intervals[i][0];
        if (intervals[i][1] > end)
          end = intervals[i][1];
      }
      if (i == intervals.length - 1) {
        res[index][0] = start;
        res[index][1] = end;
      }
    }
    return res;
  }

  public static void print(int[][] nums) {
    if (nums.length == 0) {
      System.out.println();
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums[0].length; j++)
        System.out.print(nums[i][j] + "!");
      System.out.println();
    }
    System.out.println(nums.length);
  }

  public static void main(String[] args) {
    int[][] arr1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int[][] arr2 = {{1, 4}, {4, 5}};

    Solution s = new Solution();

    print(s.merge(arr1));
    print(s.merge(arr2));
  }

}
