import java.util.*;

public class Solution {

  public int largestRectangleArea(int[] heights) {

    int max = 0;
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(-1);
    for (int i = 0; i < heights.length; i++) {
      while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
        int temp = heights[stack.pop()] * (i - stack.peek() - 1);
        if (temp > max)
          max = temp;
      }
      stack.push(i);

    }

    while (stack.peek() != -1) {
      int temp = heights[stack.pop()] * (heights.length - stack.peek() - 1);
      if (temp > max)
        max = temp;
    }
    return max;

  }

  public static void main(String[] args) {
    int[] heights1 = {2, 1, 5, 6, 2, 3}, heights2 = {}, heights3 = {5, 2, 4, 2, 3, 2};
    int output1 = 10, output2 = 0, output3 = 12;

    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.largestRectangleArea(heights1)));
    System.out.println("Checking case2: " + (s.largestRectangleArea(heights2) == output2));
    System.out.println("Checking case3: " + (s.largestRectangleArea(heights3) == output3));
  }

}
