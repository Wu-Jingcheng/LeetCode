import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Solution {

  // Hash: O(n)
  public int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int max = nums.length / 2;
    int value;
    for (int i = 0; i < nums.length; i++) {
      value = nums[i];
      if (map.containsKey(value))
        map.put(value, map.get(value) + 1);
      else
        map.put(value, 1);
    }
    for (int i = 0; i < nums.length; i++) {
      if (map.get(nums[i]) > max)
        return nums[i];
    }
    return -1;
  }

  public int majorityElement2(int[] nums) {
    if (nums.length < 3)
      return nums[0];
    int i = nums.length - 2, j = i + 1;
    while (i >= 0 && j >= 0) {
      for (; i >= 0 && nums[i] == nums[j]; i--);
      if (i >= 0 && i < j - 1)
        swap(nums, i, j - 1);
      j = j - 2;
      i = i - 1;
    }
    return nums[0];
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  // O(nlogn)
  public int majorityElement3(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }

  public static void main(String[] args) {
    int[] arr1 = {3, 2, 3};
    int[] arr2 = {2, 2, 1, 1, 1, 2, 2};
    Solution s = new Solution();

    System.out.println("Checking arr1: " + (s.majorityElement(arr1) == 3));
    System.out.println("Checking arr2: " + (s.majorityElement(arr2) == 2));
  }

}
