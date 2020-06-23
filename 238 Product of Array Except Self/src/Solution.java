
public class Solution {

  // Space complexity: O(1), except the res array
  public int[] productExceptSelf(int[] nums) {
    int len = nums.length;
    if (len == 0)
      return new int[0];
    if (len == 1)
      return new int[] {1};
    if (len == 2)
      return new int[] {nums[1], nums[0]};

    int[] res = new int[len];
    res[len - 1] = 1;
    for (int i = len - 2; i >= 0; i--)
      res[i] = res[i + 1] * nums[i + 1];
    int left = 1;
    for (int i = 1; i < len; i++) {
      left *= nums[i - 1];
      res[i] *= left;
    }
    return res;
  }

  // Space complexity: O(n)
  public int[] productExceptSelf2(int[] nums) {
    int len = nums.length;
    if (len == 0)
      return new int[] {};
    if (len == 1)
      return new int[] {1};
    if (len == 2)
      return new int[] {nums[1], nums[0]};

    int[] lefts = new int[len], rights = new int[len];
    lefts[0] = 1;
    rights[len - 1] = 1;
    for (int i = 1; i < len; i++) {
      lefts[i] = nums[i - 1] * lefts[i - 1];
    }
    for (int i = len - 2; i >= 0; i--) {
      rights[i] = nums[i + 1] * rights[i + 1];
    }
    int[] res = new int[len];
    for (int i = 0; i < len; i++) {
      res[i] = lefts[i] * rights[i];
    }
    return res;
  }

  public static void print(int[] nums) {
    for (int num : nums)
      System.out.print(num + "!");
    System.out.println();
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    Solution s = new Solution();
    print(s.productExceptSelf(nums));
  }

}
