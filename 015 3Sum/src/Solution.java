import java.util.*;

public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> al = new ArrayList<List<Integer>>();
    if (nums.length < 3)
      return al;
    Arrays.sort(nums);
    int i, left, right, sum;
    for (i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      left = i + 1;
      right = nums.length - 1;
      while (left < right) {
        if (left > i + 1 && nums[left] == nums[left - 1]) {
          left++;
          continue;
        }
        if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
          right--;
          continue;
        }
        sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          ArrayList<Integer> temp = new ArrayList<Integer>();
          temp.add(nums[i]);
          temp.add(nums[left]);
          temp.add(nums[right]);
          al.add(temp);
          left++;
          right--;
        } else if (sum > 0)
          right--;
        else
          left++;
      }
    }
    return al;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    int[] arr1 = {-1, 0, 1, 2, -1, -4};
    int[] arr2 = {0, 0, 0, 0};
    int[] arr3 = {-1, -1, -1, 0, 1, 2};
    int[] arr4 = {-2, 0, 1, 1, 2};
    int[] arr5 = {0, 1, 0, -1};

    System.out.println(s.threeSum(arr1));
    System.out.println(s.threeSum(arr2));
    System.out.println(s.threeSum(arr3));
    System.out.println(s.threeSum(arr4));
    System.out.println(s.threeSum(arr5));
  }

}
