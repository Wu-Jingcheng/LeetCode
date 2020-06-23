
public class Solution {
  public int[] countBits(int num) {
    int[] res = new int[num + 1];
    int ref = 2, refIndex = 0;
    for (int i = 1; i < res.length; i++) {
      if (i == ref) {
        ref *= 2;
        refIndex = 0;
      }
      res[i] = res[refIndex++] + 1;
    }
    return res;
  }

  public static void print(int[] nums) {
    for (int num : nums)
      System.out.print(num + "!");
    System.out.println();
  }

  public static void main(String[] args) {
    int n1 = 2;
    int n2 = 5;
    Solution s = new Solution();
    print(s.countBits(n1));
    print(s.countBits(n2));
  }

}
