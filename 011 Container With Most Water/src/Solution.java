
public class Solution {
  public int maxArea(int[] height) {
    int res = 0;
    int start = 0, end = height.length - 1;
    while (start < end) {
      int cur = Math.min(height[start], height[end]) * (end - start);
      if (cur > res)
        res = cur;
      if (height[start] < height[end])
        start++;
      else
        end--;
    }
    return res;
  }

  public static void main(String[] args) {
    int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int res = 49;
    Solution s = new Solution();
    System.out.println(s.maxArea(heights) == res);
  }

}
