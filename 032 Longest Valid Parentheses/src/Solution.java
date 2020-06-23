import java.util.Stack;

public class Solution {
  // another way
  // 之所以要从两个方向逼近，是为了防止从某个方向逼近的时候没办法收拢到left==right
  // 如()((())应当为output=4，但是从左边扫描的时候没办法发现在尾端的4
  public int longestValidParentheses(String s) {
    int left = 0, right = 0, max = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(')
        left++;
      else
        right++;

      if (left == right && left * 2 > max)
        max = 2 * left;
      else if (right > left)
        left = right = 0;
    }

    left = right = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == ')')
        right++;
      else
        left++;

      if (left == right && left * 2 > max)
        max = left * 2;
      else if (left > right)
        left = right = 0;
    }

    return max;
  }

  // stack
  public int longestValidParentheses2(String s) {
    Stack<Integer> stack = new Stack<Integer>();
    int max = 0;
    stack.push(-1);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(')
        stack.push(i);
      else {
        stack.pop();
        if (stack.isEmpty())
          stack.push(i);
        else if (i - stack.peek() > max)
          max = i - stack.peek();
      }
    }
    return max;
  }

  // dp
  public int longestValidParentheses3(String s) {
    int maxans = 0;
    int[] dp = new int[s.length()];
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(')
          dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
        else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(')
          dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
        if (dp[i] > maxans)
          maxans = dp[i];
      }
    }
    return maxans;
  }


  public static void main(String[] args) {
    Solution s = new Solution();

    String str1 = "(()";
    String str2 = ")()())";
    String str3 = "()(()";
    String str4 = "()(()()";
    String str5 = "(()))())(";
    String str6 = "(()(((()";

    System.out.println("Checking case1: " + (s.longestValidParentheses(str1) == 2));
    System.out.println("Checking case2: " + (s.longestValidParentheses(str2) == 4));
    System.out.println("Checking case3: " + (s.longestValidParentheses(str3) == 2));
    System.out.println("Checking case4: " + (s.longestValidParentheses(str4) == 4));
    System.out.println("Checking case5: " + (s.longestValidParentheses(str5) == 4));
    System.out.println("Checking case6: " + (s.longestValidParentheses(str6) == 2));// 2
  }

}
