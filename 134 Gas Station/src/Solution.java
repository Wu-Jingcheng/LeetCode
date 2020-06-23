
public class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int totalTank = 0, curTank = 0, startingPos = 0;
    int n = gas.length;
    for (int i = 0; i < n; i++) {
      int diff = gas[i] - cost[i];
      totalTank += diff;
      curTank += diff;
      if (curTank < 0) {
        startingPos = i + 1;
        curTank = 0;
      }
    }
    return totalTank < 0 ? -1 : startingPos;
  }

  public static void main(String[] args) {
    int[] gas1 = {1, 2, 3, 4, 5}, cost1 = {3, 4, 5, 1, 2};
    int[] gas2 = {2, 3, 4}, cost2 = {3, 4, 3};
    Solution s = new Solution();
    System.out.println(s.canCompleteCircuit(gas1, cost1));
    System.out.println(s.canCompleteCircuit(gas2, cost2));
  }

}
