import java.util.*;

public class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> res = new ArrayList<Integer>();
    for (int i = 0; i < nums.length; i++) {
      int index = nums[i] > 0 ? nums[i] - 1 : -nums[i] - 1;
      nums[index] = nums[index] > 0 ? -nums[index] : nums[index];
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0)
        res.add(i + 1);
    }
    return res;
  }


  public static void main(String[] args) {
    int[] input = {4, 3, 2, 7, 8, 2, 3, 1};
    Solution s = new Solution();
    System.out.println(s.findDisappearedNumbers(input));
  }

}
