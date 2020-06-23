public class Solution {
  //这个算法要记住，蛮有意思的
  public void nextPermutation(int[] nums) {
    int i = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1])
      i--;
    if (i >= 0) {
      int j = nums.length - 1;
      while (j > i && nums[j] <= nums[i])
        j--;
      swap(nums, i, j);
    }
    reverse(nums, i + 1);
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private void reverse(int[] nums, int i) {
    int j = nums.length - 1;
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }

  public static void print(int[] nums) {
    for (int i = 0; i < nums.length; i++)
      System.out.print(nums[i] + "!");
    System.out.println();
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] arr1 = {1, 2, 3};
    s.nextPermutation(arr1);
    print(arr1);

    int[] arr2 = {3, 2, 1};
    s.nextPermutation(arr2);
    print(arr2);

    int[] arr3 = {1, 1, 5};
    s.nextPermutation(arr3);
    print(arr3);
  }

}
