
public class Solution {

  public void sortColors(int[] nums) {
    if (nums.length < 2)
      return;
    int pr0, pr1, pr2;
    for (pr0 = 0; pr0 < nums.length && nums[pr0] == 0; pr0++);
    for (pr2 = nums.length - 1; pr2 >= 0 && nums[pr2] == 2; pr2--);
    pr1 = pr0;
    while (pr0 < pr2 && pr1 <= pr2) {
      if (nums[pr1] == 2)
        swap(nums, pr1, pr2--);
      else if (nums[pr1] == 0)
        swap(nums, pr0++, pr1);
      else
        pr1++;
      if (pr0 > pr1)
        pr1 = pr0;
    }
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] nums) {
    for (int i = 0; i < nums.length; i++)
      System.out.print(nums[i] + "!");
    System.out.println();
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] input1 = {2, 0, 2, 1, 1, 0};
    int[] input2 = {2, 0};
    s.sortColors(input1);
    print(input1);
    s.sortColors(input2);
    print(input2);
  }

}
