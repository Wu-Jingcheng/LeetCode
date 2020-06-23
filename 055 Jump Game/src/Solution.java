
public class Solution {
  
  //两处标记都是为了考虑最后一个数字是0的情况
  public boolean canJump(int[] nums) {
    if (nums.length == 1)//标记1
      return true;
    if (nums.length == 0 || nums[0] == 0)
      return false;
    int zeroPointer = -1;
    int pointer = nums.length - 2;//标记2
    for (; pointer >= 0; pointer--) {
      if (zeroPointer == -1 && nums[pointer] == 0)
        zeroPointer = pointer;
      else if (zeroPointer != -1 && nums[pointer] > zeroPointer - pointer)
        zeroPointer = -1;
    }
    return zeroPointer == -1;
  }

  public static void main(String[] args) {
    int[] nums1 = {2, 3, 1, 1, 4};
    int[] nums2 = {3, 2, 1, 0, 4};
    boolean output1 = true, output2 = false;

    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.canJump(nums1) == output1));
    System.out.println("Checking case2: " + (s.canJump(nums2) == output2));
  }

}
