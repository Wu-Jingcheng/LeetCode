
public class Solution {

  // Binary Search
  public int findPeakElement(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = (left + right) / 2;
      if (nums[mid] < nums[mid + 1])
        left = mid + 1;
      else
        right = mid;
    }
    return left;
  }

  // Linear Way
  public int findPeakElement2(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++)
      if (nums[i] > nums[i + 1])
        return i;
    return nums.length - 1;
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 1}, nums2 = {1, 2, 1, 3, 5, 6, 4};
    Solution s = new Solution();
    System.out.println(s.findPeakElement(nums1));// 2
    System.out.println(s.findPeakElement(nums2));// 1 or 5
  }

}
