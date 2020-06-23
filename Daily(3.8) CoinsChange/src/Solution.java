
public class Solution {
  public int coinChange(int[] coins, int amount) {
    if (coins.length == 0 || amount < 0)
      return -1;

    return coinChangeCore(coins, amount, new int[amount]);
  }

  private int coinChangeCore(int[] coins, int rem, int[] count) {
    if(rem<0)return -1;
    if(rem==0)return 0;
    if(count[rem-1]!=0)return count[rem-1];
    int min = Integer.MAX_VALUE;
    for(int coin:coins) {
      int temp = coinChangeCore(coins, rem-coin, count);
      if(temp<min&&temp!=-1)min=temp;
    }
    count[rem-1]=min==Integer.MAX_VALUE?-1:min+1;
    return count[rem-1];
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    int[] coins1 = {1, 2, 5};
    int mount1 = 11;
    System.out.println("Checking case1: " + (s.coinChange(coins1, mount1) == 3));

    int[] coins2 = {2};
    int mount2 = 3;
    System.out.println("Checking case2: " + (s.coinChange(coins2, mount2) == -1));

    int[] coins3 = {2, 5, 10, 1};
    int mount3 = 27;
    System.out.println("Checking case3: " + (s.coinChange(coins3, mount3) == 4));
  }

}
