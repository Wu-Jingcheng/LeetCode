
public class Solution {
  // We can also save space, and be much faster
  public int maxProfit(int[] prices) {
    int holding = -prices[0];
    int soldout = 0;
    int tempHolding, tempSoldout;
    for (int i = 1; i < prices.length; i++) {
      tempHolding = soldout - prices[i];
      tempSoldout = holding + prices[i];
      if (tempHolding > holding)
        holding = tempHolding;
      if (tempSoldout > soldout)
        soldout = tempSoldout;
    }
    return soldout;
  }

  // Original Mindest
  public int maxProfit2(int[] prices) {
    int[][] dp = new int[prices.length][2];
    dp[0][0] = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
    }
    return dp[dp.length - 1][1];
  }

  public static void main(String[] args) {
    int[] stocks1 = {7, 1, 5, 3, 6, 4};
    int[] stocks2 = {1, 2, 3, 4, 5};
    int[] stocks3 = {7, 6, 4, 3, 1};
    Solution s = new Solution();
    System.out.println(s.maxProfit(stocks1));
    System.out.println(s.maxProfit(stocks2));
    System.out.println(s.maxProfit(stocks3));
  }

}
