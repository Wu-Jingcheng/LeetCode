import java.util.Stack;

public class Solution {
  // Or we can use stack
  public int findUnsortedSubarray(int[] nums) {
    Stack<Integer> stack = new Stack<Integer>();
    int l = nums.length, r = 0;
    for (int i = 0; i < nums.length; i++) {
      while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
        l = Math.min(l, stack.pop());
      stack.push(i);
    }
    stack.clear();
    for (int i = nums.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
        r = Math.max(r, stack.pop());
      stack.push(i);
    }
    return r - l > 0 ? r - l + 1 : 0;
  }

  // Rather hard mindset
  public int findUnsortedSubarray2(int[] nums) {
    int start = 0;
    for (; start < nums.length - 1 && nums[start] <= nums[start + 1]; start++);
    if (start == nums.length - 1)
      return 0;
    int end = nums.length - 1;
    for (; end > 0 && nums[end - 1] <= nums[end]; end--);
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int i = start; i <= end; i++) {
      if (nums[i] < min)
        min = nums[i];
      if (nums[i] > max)
        max = nums[i];
    }
    for (start = 0; nums[start] <= min; start++);
    for (end = nums.length - 1; nums[end] >= max; end--);
    return end - start + 1;
  }

  public static void main(String[] args) {
    int[] arr1 = {2, 9, 10, 8, 6, 7, 12};
    int ans1 = 5;
    int[] arr2 = {2, 6, 4, 8, 10, 9, 15};
    int ans2 = 5;
    int[] arr3 = {1, 2, 3, 4, 0, 1, 2};
    int ans3 = 7;
    int[] arr4 = {1, 2, 3};
    int ans4 = 0;
    Solution s = new Solution();
    System.out.println(s.findUnsortedSubarray(arr1) == ans1);
    System.out.println(s.findUnsortedSubarray(arr2) == ans2);
    System.out.println(s.findUnsortedSubarray(arr3) == ans3);
    System.out.println(s.findUnsortedSubarray(arr4) == ans4);
  }

}
