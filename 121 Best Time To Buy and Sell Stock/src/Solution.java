import java.util.*;

public class Solution {
  public int maxProfit2(int[] prices) {
    int res = 0;
    if(prices.length<2)return res;
    int buyingPrice = Integer.MAX_VALUE;
    for(int i=0;i<prices.length;i++) {
      if(prices[i]-buyingPrice>res)res=prices[i]-buyingPrice;
      if(buyingPrice>prices[i])buyingPrice=prices[i];
    }
    return res;
  }
  
  public int maxProfit(int[] prices) {
    int res = 0;
    if (prices.length < 2)
      return res;
    Deque<Integer> queue = new LinkedList<Integer>();
    int temp = Integer.MIN_VALUE;
    for (int i = 0; i < prices.length; i++) {
      if (!queue.isEmpty()) {
        temp = prices[i] - queue.peekFirst();
      }
      if (temp > res)
        res = temp;
      while (!queue.isEmpty() && queue.peekLast() > prices[i])
        queue.pollLast();
      queue.add(prices[i]);
    }

    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    int[] prices1 = {7, 1, 5, 3, 6, 4};
    int ans1 = 5;

    int[] prices2 = {7, 6, 4, 3, 1};
    int ans2 = 0;
    System.out.println("Checking case1: " + (s.maxProfit2(prices1) == ans1));
    System.out.println("Checking case2: " + (s.maxProfit2(prices2) == ans2));
  }

}
