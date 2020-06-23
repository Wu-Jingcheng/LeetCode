
public class Solution {
  public int jump(int[] nums) {
    final int len = nums.length;
    if (len < 2)
      return 0;
    int right = nums[0], nextRight = right;
    int res = 1;
    for (int i = 1; i < len && nextRight < len - 1; i++) {
      if (i > right) {
        res++;
        right = nextRight;
      }
      if (i + nums[i] > nextRight)
        nextRight = i + nums[i];
    }
    return right >= len - 1 ? res : res + 1;
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, 1, 1, 4};
    Solution s = new Solution();
    System.out.println(s.jump(nums));
  }

}
