
public class Solution {
  public int[] singleNumbers(int[] nums) {
    int[] res = new int[2];
    int xor = 0;
    for (int num : nums)
      xor ^= num;
    int bit = 1;
    while ((xor & bit) == 0)
      bit <<= 1;
    for (int num : nums)
      if ((num & bit) == 0)
        res[0] ^= num;
      else
        res[1] ^= num;
    return res;
  }

  public static void print(int[] nums) {
    System.out.println(nums[0] + "!" + nums[1] + "!");
  }

  public static void main(String[] args) {
    int[] nums1 = {4, 1, 4, 6}, nums2 = {1, 2, 10, 4, 1, 4, 3, 3};
    Solution s = new Solution();
    print(s.singleNumbers(nums1));
    print(s.singleNumbers(nums2));
  }

}
