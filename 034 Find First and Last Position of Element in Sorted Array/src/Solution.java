
public class Solution {
  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    if (nums.length == 0) {
      res[0] = -1;
      res[1] = -1;
      return res;
    }
    int left, right, mid, loc = 0;
    left = 0;
    right = nums.length - 1;
    while (left <= right) {
      mid = (left + right) / 2;
      if (nums[mid] >= target) {
        loc = mid;
        right = mid - 1;
      } else
        left = mid + 1;
    }
    res[0] = (nums[loc] == target) ? loc : -1;
    left = 0;
    right = nums.length - 1;
    while (left <= right) {
      mid = (left + right) / 2;
      if (nums[mid] <= target) {
        loc = mid;
        left = mid + 1;
      } else
        right = mid - 1;
    }
    res[1] = (nums[loc] == target) ? loc : -1;
    return res;
  }

  public static String print(int[] arr) {
    String res = "";
    for (int i = 0; i < arr.length; i++)
      res += arr[i] + "!";
    return res;
  }

  public static void main(String[] args) {
    int[] arr1 = {5, 7, 7, 8, 8, 10};
    int target1 = 8, target2 = 6;

    int[] arr2 = {0};
    int target3 = 0, target4 = 10;
    
    Solution s = new Solution();
    System.out.println("Checking case1: " + print(s.searchRange(arr1, target1)));
    System.out.println("Checking case2: " + print(s.searchRange(arr1, target2)));
    
    System.out.println("Checking case2: " + print(s.searchRange(arr2, target3)));
    System.out.println("Checking case2: " + print(s.searchRange(arr2, target4)));
  }

}
