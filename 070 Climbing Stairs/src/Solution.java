
public class Solution {
  public int climbStairs(int n) {
    int num1 = 1, num2 = 1;
    while (n > 1) {
      num2 += num1;
      num1 = num2 - num1;
      n--;
    }
    return num2;
  }

  public static void main(String[] args) {
    int input1 = 2, output1 = 2;
    int input2 = 3, output2 = 3;
    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.climbStairs(input1) == output1));
    System.out.println("Checking case2: " + (s.climbStairs(input2) == output2));
  }

}
