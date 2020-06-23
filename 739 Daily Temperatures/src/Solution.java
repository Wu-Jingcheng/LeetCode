import java.util.Stack;

public class Solution {

  // Stack, and no need to store the temperatures
  public int[] dailyTemperatures(int[] T) {
    Stack<Integer> stack = new Stack<Integer>();
    int[] res = new int[T.length];
    for (int i = 0; i < T.length; i++) {
      while (!stack.isEmpty() && T[i] > T[stack.peek()])
        res[stack.peek()] = i - stack.pop();
      stack.push(i);
    }
    return res;
  }

  // Stack, and we store the temperatures
  public int[] dailyTemperatures2(int[] T) {
    Stack<Integer> temperatures = new Stack<Integer>();
    Stack<Integer> indices = new Stack<Integer>();
    int[] res = new int[T.length];
    for (int i = 0; i < T.length; i++) {
      int t = T[i];
      while (!temperatures.isEmpty() && t > temperatures.peek()) {
        temperatures.pop();
        res[indices.peek()] = i - indices.pop();
      }
      temperatures.push(t);
      indices.push(i);
    }
    return res;
  }

  public static void print(int[] nums) {
    for (int num : nums)
      System.out.print(num + "!");
    System.out.println();
  }

  public static void main(String[] args) {
    int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
    Solution s = new Solution();
    print(s.dailyTemperatures(T));
  }

}
