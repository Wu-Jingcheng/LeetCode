
public class Solution {

  public int maxSubArray(int[] nums) {
    if (nums.length == 0)
      return 0;
    return maxSubArrayCore(nums, 0, nums.length - 1);
  }

  private int maxSubArrayCore(int[] nums, int left, int right) {
    if (left == right)
      return nums[left];
    int mid = (left + right) / 2;
    return Math.max(
        Math.max(maxSubArrayCore(nums, left, mid), maxSubArrayCore(nums, mid + 1, right)),
        crossSum(nums, left, right, mid));
  }

  private int crossSum(int[] nums, int left, int right, int mid) {
    int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE, currentSum = 0;
    for (int i = mid; i >= left; i--) {
      currentSum += nums[i];
      if (currentSum > leftSum)
        leftSum = currentSum;
    }
    currentSum = 0;
    for (int i = mid + 1; i <= right; i++) {
      currentSum += nums[i];
      if (currentSum > rightSum)
        rightSum = currentSum;
    }

    return leftSum + rightSum;
  }

  public int maxSubArray2(int[] nums) {
    int left = 0, right = nums.length - 1;
    if (left > right)
      return 0;
    int max = Integer.MIN_VALUE;
    int sum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      sum = Math.max(sum + nums[i], nums[i]);
      if (sum > max)
        max = sum;
    }
    return max;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    int[] input1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int output1 = 6;

    int[] input2 = {};
    int output2 = 0;

    System.out.println("Checking case1: " + (s.maxSubArray(input1) == output1));
    System.out.println("Checking case2: " + (s.maxSubArray(input2) == output2));
  }

}
