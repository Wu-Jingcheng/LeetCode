
public class Solution {
  public int massage(int[] nums) {
    int  max = 0, preMax = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i - 2 >= 0 && nums[i - 2] > preMax)
        preMax = nums[i - 2];
      nums[i] += preMax;
      if (nums[i] > max)
        max = nums[i];
    }
    return max;
  }

  public static void main(String[] args) {
    int[] arr1 = {1, 2, 3, 1}, arr2 = {2, 7, 9, 3, 1}, arr3 = {2, 1, 4, 5, 3, 1, 1, 3};
    int output1 = 4, output2 = 12, output3 = 12;

    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.massage(arr1) == output1));
    System.out.println("Checking case2: " + (s.massage(arr2) == output2));
    System.out.println("Checking case3: " + (s.massage(arr3) == output3));

  }

}
