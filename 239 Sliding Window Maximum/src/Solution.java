import java.util.*;

public class Solution {
  // With arrays
  public int[] maxSlidingWindow(int[] nums, int k) {
    int len = nums.length;
    int[] lefts = new int[len], rights = new int[len], res = new int[len - k + 1];
    int left = 0, right = 0;
    for (int i = 0; i < len; i++) {
      if (i % k == 0)
        left = nums[i];
      else
        left = Math.max(nums[i], left);
      lefts[i] = left;
    }
    for (int i = len - 1; i >= 0; i--) {
      if (i % k == k - 1 || i == len - 1)
        right = nums[i];
      else
        right = Math.max(nums[i], right);
      rights[i] = right;
    }
    for (int i = 0; i <= len - k; i++) {
      res[i] = Math.max(rights[i], lefts[i + k - 1]);
    }
    return res;
  }

  // With Deque
  public int[] maxSlidingWindow2(int[] nums, int k) {
    if (nums.length < 2)
      return nums;
    int[] res = new int[nums.length - k + 1];
    Deque<Integer> queue = new LinkedList<>();
    int i;
    for (i = 0; i < k; i++) {
      addNum(queue, nums[i]);
    }
    res[0] = queue.peekFirst();
    for (i = k; i < nums.length; i++) {
      if (nums[i - k] == queue.peekFirst())
        queue.pollFirst();
      addNum(queue, nums[i]);
      res[i - k + 1] = queue.peekFirst();
    }
    return res;
  }

  private void addNum(Deque<Integer> queue, int num) {
    while (!queue.isEmpty() && queue.peekLast() < num)
      queue.pollLast();
    queue.add(num);
  }

  public static void print(int[] nums) {
    for (int num : nums)
      System.out.print(num + "!");
    System.out.println();
  }

  public static void main(String[] args) {
    int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    Solution s = new Solution();
    print(s.maxSlidingWindow(arr, k));
  }

}
