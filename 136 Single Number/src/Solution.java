
public class Solution {

  public int singleNumber(int[] nums) {
    for (int i = 1; i < nums.length; i++)
      nums[i] ^= nums[i - 1];
    return nums[nums.length - 1];
  }

  public static void main(String[] args) {
    int[] arr1 = {2, 2, 1};
    int[] arr2 = {4, 1, 2, 1, 2};
    int res1 = 1, res2 = 4;

    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.singleNumber(arr1) == res1));
    System.out.println("Checking case2: " + (s.singleNumber(arr2) == res2));
  }

}
