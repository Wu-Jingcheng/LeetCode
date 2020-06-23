
public class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = pushBack(nums1, m), j = 0;
    for (int k = 0; k < nums1.length; k++)
      if (i == nums1.length)
        nums1[k] = nums2[j++];
      else if (j == n)
        nums1[k] = nums1[i++];
      else if (nums1[i] < nums2[j])
        nums1[k] = nums1[i++];
      else
        nums1[k] = nums2[j++];
  }

  private int pushBack(int[] nums1, int m) {
    int diff = nums1.length - m;
    for (int i = m - 1; i >= 0; i--)
      nums1[i + diff] = nums1[i];
    return diff;
  }

  public static void print(int[] nums) {
    for (int num : nums)
      System.out.print(num + "!");
    System.out.println();
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0};
    int[] nums2 = {2, 5};
    int m = 3, n = 3;
    Solution s = new Solution();
    s.merge(nums1, m, nums2, n);
    print(nums1);
    int[] nums3 = {1, 2, 3};
    int[] nums4 = {};
    m = 3;
    n = 0;
    s.merge(nums3, m, nums4, n);
    print(nums3);
    int[] nums5 = {0, 0, 0};
    int[] nums6 = {1, 2, 3};
    m = 0;
    n = 3;
    s.merge(nums5, m, nums6, n);
    print(nums5);
  }

}
