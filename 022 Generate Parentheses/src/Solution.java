import java.util.*;

public class Solution {
  // 闭合数方法，相对来说还是有点慢，毕竟用了递归。
  public List<String> generateParenthesis3(int n) {
    List<String> res = new ArrayList<String>();
    if (n == 0)
      res.add("");
    else {
      for (int i = n - 1; i >= 0; i--) {
        for (String left : generateParenthesis3(i)) {
          for (String right : generateParenthesis3(n - 1 - i)) {
            res.add("(" + left + ")" + right);
          }
        }
      }
    }
    return res;
  }

  // 快速的方法
  public List<String> generateParenthesis2(int n) {
    List<String> al = new ArrayList<String>();
    backtrack(al, "", 0, 0, n);
    return al;
  }

  private void backtrack(List<String> al, String s, int open, int close, int max) {
    if (s.length() == 2 * max) {
      al.add(s);
      return;
    }
    if (open < max)
      backtrack(al, s + "(", open + 1, close, max);
    if (close < open)
      backtrack(al, s + ")", open, close + 1, max);
  }

  // 这个思路复杂了
  public List<String> generateParenthesis(int n) {
    ArrayList<String> al = new ArrayList<String>();
    Stack<Character> stack = new Stack<Character>();
    generateParenthesesCore(n, stack, new StringBuffer(), al);
    return al;
  }

  private void generateParenthesesCore(int n, Stack<Character> stack, StringBuffer s,
      ArrayList<String> al) {
    if (n != 0) {
      stack.push('(');
      s.append('(');
      generateParenthesesCore(n - 1, stack, s, al);
      stack.pop();
      s.deleteCharAt(s.length() - 1);
    }
    if (!stack.isEmpty()) {
      stack.pop();
      s.append(')');
      generateParenthesesCore(n, stack, s, al);
      stack.add('(');
      s.deleteCharAt(s.length() - 1);
    }
    if (stack.isEmpty() && n == 0)
      al.add(s.toString());
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.generateParenthesis2(3));
  }

}
