
public class Solution {

  public int findDuplicate(int[] nums) {
    int slow = nums[0], fast = nums[0];
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);
    fast = slow;
    slow = nums[0];
    while (slow != fast) {
      fast = nums[fast];
      slow = nums[slow];
    }
    return slow;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] arr1 = {1, 3, 4, 2, 2}, arr2 = {3, 1, 3, 4, 2};
    int res1 = 2, res2 = 3;
    System.out.println("Case1: " + (s.findDuplicate(arr1) == res1));
    System.out.println("Case2: " + (s.findDuplicate(arr2) == res2));

  }

}
