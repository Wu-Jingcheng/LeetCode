import java.util.*;
public class Solution {
  // 更好的是hashmap的方法，hashmap的containKey可以是O(1)
  public int[] twoSum2(int[] nums, int target) {
    if(nums.length<2)return null;
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    int complement;
    for(int i=0;i<nums.length;i++) {
      complement = target-nums[i];
      if(map.containsKey(complement))return new int[] {map.get(complement),i};
      map.put(nums[i], i);
    }
    return null;
  }

  // 暴力的算法
  public int[] twoSum(int[] nums, int target) {
    if (nums.length < 2)
      return null;
    int[] res = new int[2];
    for (int i = 0; i < nums.length; i++)
      for (int j = i + 1; j < nums.length; j++)
        if (nums[i] + nums[j] == target) {
          res[0] = i;
          res[1] = j;
          return res;
        }
    return null;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    int[] arr = {2, 7, 11, 15};
    System.out.println("Checking case1: " + (s.twoSum(arr, 9)[0] == 0 && s.twoSum2(arr, 9)[1] == 1));

  }

}
