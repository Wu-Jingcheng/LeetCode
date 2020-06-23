
public class Solution {
  public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - k);
    reverse(nums, nums.length - k, nums.length);
    reverse(nums, 0, nums.length);
  }

  private void reverse(int[] nums, int start, int end) {
    end--;
    while (start < end)
      swap(nums, start++, end--);
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void print(int[] nums) {
    for (int num : nums)
      System.out.print(num + "!");
    System.out.println();
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 4, 5, 6, 7}, nums2 = {-1, -100, 3, 99};
    int k1 = 3, k2 = 2;
    Solution s = new Solution();
    s.rotate(nums1, k1);
    s.rotate(nums2, k2);
    print(nums1);
    print(nums2);
  }

}
