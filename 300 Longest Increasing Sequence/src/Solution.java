
public class Solution {
  // O(nlogn) 其实就是遍历n个数字，然后插入一个有序数组，假如新的有序序列可以比原本的长他就会覆盖原本的尾端
  public int lengthOfLIS(int[] nums) {
    if (nums.length == 0)
      return 0;
    int index = 0, left, right, mid, loc=0;
    int[] increasing = new int[nums.length];
    increasing[0] = nums[0];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > increasing[index]) {
        increasing[index + 1] = nums[i];
        index++;
      }
      for (left = 0, right = index; left <= right;) {
        mid = (left + right) / 2;
        if (increasing[mid] >= nums[i]) {
          loc = mid;
          right = mid - 1;
        } else
          left = mid + 1;
      }
      increasing[loc] = nums[i];
    }
    return index + 1;

  }

  // O(n^2)
  public int lengthOfLIS2(int[] nums) {
    if (nums.length < 2)
      return nums.length;
    int left = 0, right = 1, currentMax = 1, overallMax = 0;
    int[] memo = new int[nums.length];
    memo[0] = 1;
    for (; right < nums.length; right++) {
      currentMax = 1;
      for (left = 0; left < right; left++) {
        if (nums[left] < nums[right] && memo[left] + 1 > currentMax)
          currentMax = memo[left] + 1;
      }
      memo[right] = currentMax;
      if (memo[right] > overallMax)
        overallMax = memo[right];
    }
    return overallMax;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    int[] arr1 = {10, 9, 2, 5, 3, 7, 101, 18};
    int[] arr2 = {};
    int[] arr3 = {1, 2, 1, 10, 5, 7, 3};
    int[] arr4 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    System.out.println("Checking arr1: " + (s.lengthOfLIS(arr1) == 4));
    System.out.println("Checking arr2: " + (s.lengthOfLIS(arr2) == 0));
    System.out.println("Checking arr3: " + (s.lengthOfLIS(arr3) == 4));
    System.out.println("Checking arr4: " + (s.lengthOfLIS(arr4) == 1));
  }

}
