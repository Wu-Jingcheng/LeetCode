// 我的思路对了，但是没想到处理负数的最佳方式，即维护最大值的同时也维护最小值
public class Solution {

  public int maxProduct(int[] nums) {
    int imax = 1, imin = 1, max = Integer.MIN_VALUE;
    for (int num : nums) {
      if (num < 0) {
        int temp = imax;
        imax = imin;
        imin = temp;
      }
      imax = Math.max(imax * num, num);
      imin = Math.min(imin * num, num);
      if (imax > max)
        max = imax;
    }
    return max;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums1 = {2, 3, -2, 4};
    int[] nums2 = {-2, 0, -1};
    System.out.println("Checking case1: " + (s.maxProduct(nums1)));
    System.out.println("Checking case2: " + (s.maxProduct(nums2)));
  }

}
