
public class Solution {
  // A more neat dp, much faster
  // First, we use only one dimension for each day in dp memory
  // Second, we keep pointers for 7days and 30days backtracking
  public int mincostTickets(int[] days, int[] costs) {
    int len = days.length;
    if (len == 0)
      return 0;
    int[] dp = new int[len];
    int j7 = 0, j30 = 0;
    for (int i = 0; i < len; i++) {
      int cost1d = i == 0 ? costs[0] : dp[i - 1] + costs[0];
      int cost7d, cost30d;
      for (; days[i] - days[j7] >= 7; j7++);
      for (; days[i] - days[j30] >= 30; j30++);
      cost7d = j7 == 0 ? costs[1] : dp[j7 - 1] + costs[1];
      cost30d = j30 == 0 ? costs[2] : dp[j30 - 1] + costs[2];
      dp[i] = Math.min(cost1d, Math.min(cost7d, cost30d));
    }
    return dp[len - 1];
  }

  // Let's go dp this time, not neat enough
  public int mincostTickets3(int[] days, int[] costs) {
    int len = days.length;
    if (len == 0)
      return 0;
    int[][] dp = new int[len][3];
    for (int i = 0; i < len; i++) {
      int fromBeg = days[i] - days[0];
      dp[i][0] = i == 0 ? costs[0]
          : Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])) + costs[0];
      if (fromBeg < 7)
        dp[i][1] = costs[1];
      else {
        int j = i;
        for (; days[i] - days[j] < 7; j--);
        dp[i][1] = Math.min(dp[j][0], Math.min(dp[j][1], dp[j][2])) + costs[1];
      }
      if (fromBeg < 30)
        dp[i][2] = costs[2];
      else {
        int j = i;
        for (; days[i] - days[j] < 30; j--);
        dp[i][2] = Math.min(dp[j][0], Math.min(dp[j][1], dp[j][2])) + costs[2];
      }
    }
    return Math.min(dp[len - 1][0], Math.min(dp[len - 1][1], dp[len - 1][2]));
  }

  // beyond time limitation
  public int mincostTickets2(int[] days, int[] costs) {
    if (days.length == 0)
      return 0;
    return mincostHelper(days, costs, days[0], 0, 0);
  }

  private int mincostHelper(int[] days, int[] costs, int day, int index, int cost) {
    for (; index < days.length && days[index] < day; index++);
    if (index == days.length)
      return cost;
    day = days[index];
    int cost1D = mincostHelper(days, costs, day + 1, index, cost + costs[0]);
    int cost7D = mincostHelper(days, costs, day + 7, index, cost + costs[1]);
    int cost30D = mincostHelper(days, costs, day + 30, index, cost + costs[2]);
    return Math.min(cost1D, Math.min(cost7D, cost30D));
  }

  public static void main(String[] args) {
    int[] costs = {2, 7, 15};
    int[] days1 = {}, days2 = {1, 4, 6, 7, 8, 20}, days3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
    Solution s = new Solution();
    System.out.println(s.mincostTickets(days1, costs));// 0
    System.out.println(s.mincostTickets(days2, costs));// 11
    System.out.println(s.mincostTickets(days3, costs));// 17
  }

}
