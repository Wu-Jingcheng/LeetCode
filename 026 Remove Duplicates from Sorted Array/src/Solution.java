
public class Solution {
  public int removeDuplicates(int[] nums) {
    int slow = -1, fast = 0;
    while (fast < nums.length) {
      if (slow == -1 || nums[slow] != nums[fast]) {
        nums[++slow] = nums[fast];
      }
      fast++;
    }
    return slow + 1;
  }

  public static void print(int[] nums, int length) {
    for (int i = 0; i < length; i++) {
      System.out.print(nums[i]);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums1 = {1, 1, 2}, nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    print(nums1, s.removeDuplicates(nums1));
    print(nums2, s.removeDuplicates(nums2));
  }

}
