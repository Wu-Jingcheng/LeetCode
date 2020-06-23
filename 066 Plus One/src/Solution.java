
public class Solution {
  public int[] plusOne(int[] digits) {
    int[] res = null;
    for (int digit : digits)
      if (digit != 9) {
        res = digits;
        break;
      }
    if (res == null) {
      res = new int[digits.length + 1];
      for (int i = digits.length - 1; i >= 0; i--)
        res[i + 1] = digits[i];
    }
    for (int i = res.length - 1; i >= 0; i--)
      if (res[i] == 9)
        res[i] = 0;
      else {
        res[i]++;
        break;
      }
    return res;
  }

  public static void print(int[] nums) {
    for (int num : nums)
      System.out.print(num + "!");
    System.out.println();
  }

  public static void main(String[] args) {
    int[] num1 = {1, 2, 3}, num2 = {4, 3, 2, 1}, num3 = {9, 9}, num4 = {0};
    Solution s = new Solution();
    print(s.plusOne(num1));
    print(s.plusOne(num2));
    print(s.plusOne(num3));
    print(s.plusOne(num4));
  }

}
