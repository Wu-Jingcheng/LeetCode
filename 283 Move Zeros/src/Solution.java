
public class Solution {
  public void moveZeroes(int[] nums) {
    if (nums.length < 2)
      return;
    int border = -1, current = 0;
    for (; current < nums.length; current++) {
      if (nums[current] != 0) {
        border++;
        if (border != current)
          swap(nums, border, current);
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void print(int[] arr) {
    for (int num : arr)
      System.out.print(num + "!");
    System.out.println();
  }

  public static void main(String[] args) {
    int[] arr = {0, 1, 0, 3, 12};
    Solution s = new Solution();
    s.moveZeroes(arr);
    print(arr);
  }

}
