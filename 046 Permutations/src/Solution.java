import java.util.ArrayList;
import java.util.List;

public class Solution {
  // 全字典, we need the method swap as well
  // 毕竟遍历的次数比较少，所以速度比较快O(n^2)
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> al = new ArrayList<List<Integer>>();
    if (nums.length == 0)
      return al;
    permuteCore(nums, al, 0);
    return al;
  }

  private void permuteCore(int[] nums, List<List<Integer>> al, int index) {
    if (index == nums.length - 1) {
      List<Integer> temp = new ArrayList<Integer>();
      for (int i = 0; i < nums.length; i++)
        temp.add(nums[i]);
      al.add(temp);
    }
    for (int i = index; i < nums.length; i++) {
      swap(nums, index, i);
      permuteCore(nums, al, index + 1);
      swap(nums, index, i);
    }
  }

  // 升序
  public List<List<Integer>> permute2(int[] nums) {
    List<List<Integer>> al = new ArrayList<List<Integer>>();
    if (nums.length == 0)
      return al;

    int[] ref = new int[nums.length];
    int count = 0, i, j;
    for (i = 0; i < nums.length; i++)
      ref[i] = nums[i];

    // while (count < 1) {
    for (; count < limit(nums.length); count++) {
      List<Integer> temp = new ArrayList<Integer>();
      for (i = 0; i < nums.length; i++)
        temp.add(nums[i]);
      al.add(temp);
      for (i = nums.length - 2; i >= 0 && nums[i] > nums[i + 1]; i--);

      if (i >= 0) {
        for (j = nums.length - 1; j > i && nums[i] > nums[j]; j--);
        swap(nums, i, j);
      }
      reverse(nums, i + 1);
      /*
       * if (isSame(nums, ref)) count++;
       */
    }

    return al;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private void reverse(int[] nums, int i) {
    int j = nums.length - 1;
    for (; i < j; i++, j--)
      swap(nums, i, j);
  }

  private int limit(int n) {
    int res = 1;
    for (int i = 1; i <= n; i++)
      res *= i;
    return res;
  }

  private boolean isSame(int[] nums, int[] ref) {
    for (int i = 0; i < ref.length; i++)
      if (nums[i] != ref[i])
        return false;
    return true;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    int[] nums1 = {1, 2, 3};
    int[] nums2 = {1};

    System.out.println("Checking nums1: " + s.permute(nums1));
    System.out.println("Checking nums2: " + s.permute(nums2));
  }

}
