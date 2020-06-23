import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    ArrayList<List<Integer>> al = new ArrayList<List<Integer>>();
    int[] counts = new int[candidates.length];
    combinationSumCore(candidates, target, 0, counts, al);
    return al;
  }

  private void combinationSumCore(int[] nums, int target, int index, int[] counts,
      List<List<Integer>> al) {
    if (target == 0) {
      ArrayList<Integer> temp = new ArrayList<Integer>();
      for (int i = 0; i < nums.length; i++) {
        for (int j = 0; j < counts[i]; j++) {
          temp.add(nums[i]);
        }
      }
      al.add(temp);
      return;
    }

    if (index == nums.length || target < 0)
      return;

    int limit = target / nums[index];
    for (int i = 0; i <= limit; i++) {
      int tmp = counts[index];
      counts[index] = i;
      combinationSumCore(nums, target - i * nums[index], index + 1, counts, al);
      counts[index] = tmp;
    }
  }

  public static void main(String[] args) {
    int[] arr1 = {2, 3, 6, 7};
    int[] arr2 = {2, 3, 5};
    int[] arr3 = {};
    int target1 = 7, target2 = 8;

    Solution s = new Solution();
    System.out.println("Checking case1: " + (s.combinationSum(arr1, target1)));
    System.out.println("Checking case2: " + (s.combinationSum(arr2, target2)));
    System.out.println("Checking case3: " + (s.combinationSum(arr3, target2)));
  }

}
