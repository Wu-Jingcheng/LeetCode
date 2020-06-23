
public class Solution {
  public int trap(int[] height) {
    if (height.length == 0)
      return 0;
    int count = 0, left = 0, right = height.length - 1, leftMax = height[left],
        rightMax = height[right], overallMax = Math.min(leftMax, rightMax), loc;

    while (left < right) {
      if (height[left] > leftMax)
        leftMax = height[left];
      else if (height[right] > rightMax)
        rightMax = height[right];
      overallMax = Math.min(leftMax, rightMax);
      if (leftMax < rightMax) {
        loc = left;
        left++;
      } else {
        loc = right;
        right--;
      }
      count += overallMax - height[loc];
    }
    return count;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] trap1 = {1, 0, 3, 1, 2, 1, 3, 0, 2}, trap2 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1},
        trap3 = {}, trap4= {5};
    int res1 = 8, res2 = 6, res3 = 0, res4 = 0;

    System.out.println("Checking trap1: " + (s.trap(trap1) == res1));
    System.out.println("Checking trap2: " + (s.trap(trap2) == res2));
    System.out.println("Checking trap3: " + (s.trap(trap3) == res3));
    System.out.println("Checking trap4: " + (s.trap(trap4) == res4));
  }

}
