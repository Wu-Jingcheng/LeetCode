
public class Solution {
  // dp, can save time
  public int maxProfit(int[] prices) {
    if (prices.length < 2)
      return 0;
    int[][] dp = new int[prices.length][2];
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    dp[1][0] = Math.max(0, prices[1] - prices[0]);
    dp[1][1] = Math.max(-prices[1], -prices[0]);
    for (int i = 2; i < prices.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i - 2][0] - prices[i], dp[i - 1][1]);
    }
    return dp[prices.length - 1][0];
  }

  // Good one, but exceed time limit.
  public int maxProfit2(int[] prices) {
    return maxProfitHelper(prices, 0, 0, false, false);
  }

  private int maxProfitHelper(int[] prices, int index, int buyingPrice, boolean cooldown,
      boolean buying) {
    if (index == prices.length) {
      return -buyingPrice;
    }

    if (cooldown) {
      return maxProfitHelper(prices, index + 1, 0, false, false);
    } else {
      if (buying) {
        return Math.max(maxProfitHelper(prices, index + 1, buyingPrice, false, true),
            prices[index] - buyingPrice + maxProfitHelper(prices, index + 1, 0, true, false));
      } else {
        return Math.max(maxProfitHelper(prices, index + 1, 0, false, false),
            maxProfitHelper(prices, index + 1, prices[index], false, true));
      }
    }
  }

  public static void main(String[] args) {
    int[] arr1 = {1, 2, 4};
    Solution s = new Solution();
    System.out.println(s.maxProfit(arr1) == 3);
  }

}
