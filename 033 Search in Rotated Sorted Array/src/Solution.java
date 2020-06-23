
public class Solution {
  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1, mid = (left + right) / 2;

    if (nums.length == 0 || nums[left] > target && target > nums[right])
      return -1;

    while (left < right) {
      if (nums[left] == target)
        return left;
      if (nums[right] == target)
        return right;
      System.out.println(left + "!" + right);
      if (nums[left] < nums[right]) {
        if (nums[mid] < target)
          left = mid + 1;
        else if (target < nums[mid])
          right = mid - 1;
        else
          return mid;
      } else {

        if (nums[mid] < target && target < nums[right]
            || nums[mid] > nums[right] && (nums[mid] < target || target < nums[right]))
          left = mid + 1;
        else if (nums[left] < target && target < nums[mid]
            || nums[left] > nums[mid] && (nums[left] < target || target < nums[mid]))
          right = mid - 1;
        else if (nums[mid] == target)
          return mid;
        else
          return -1;
      }
      mid = (left + right) / 2;
    }
    System.out.println(left + ";" + right);
    if (nums[left] == target)
      return left;
    else if (right >= 0 && nums[right] == target)
      return right;
    else
      return -1;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {4, 5, 6, 7, 0, 1, 2};
    int target1 = 0, target2 = 3, target3 = 4;

    System.out.println("Checking case1: " + (s.search(nums, target1)));
    System.out.println("Checking case2: " + (s.search(nums, target2) == -1));
    System.out.println("Checking case1: " + (s.search(nums, target3)));

    for (int i = 0; i < nums.length; i++) {
      System.out.println("Checking case: " + (s.search(nums, nums[i])));
    }
  }

}
