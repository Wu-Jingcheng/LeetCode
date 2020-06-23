import java.util.*;

public class Solution {
  private Set<String> set = new HashSet<String>();
  private int min = Integer.MAX_VALUE;

  private void recurse(String s, int index, int left, int right, StringBuffer sb, int count) {
    if (index == s.length()) {
      if (left == right) {
        if (count <= min) {
          String str = sb.toString();
          if (count < min) {
            set.clear();
            min = count;
          }
          set.add(str);
        }
      }
    } else {
      char c = s.charAt(index);
      int len = sb.length();
      if (c != '(' && c != ')') {
        sb.append(c);
        recurse(s, index + 1, left, right, sb, count);
        sb.deleteCharAt(len);
      } else {
        recurse(s, index + 1, left, right, sb, count + 1);
        sb.append(c);
        if (c == '(') {
          recurse(s, index + 1, left + 1, right, sb, count);
        } else if (right < left) {
          recurse(s, index + 1, left, right + 1, sb, count);
        }
        sb.deleteCharAt(len);
      }
    }
  }

  private void reset() {
    set.clear();
    min = Integer.MAX_VALUE;
  }

  // Unlimited recursions
  public List<String> removeInvalidParentheses2(String s) {
    reset();
    recurse(s, 0, 0, 0, new StringBuffer(), 0);
    return new ArrayList<String>(set);
  }

  private void helper(String s, int index, int left, int right, int leftRem, int rightRem,
      StringBuffer sb) {
    if (index == s.length()) {
      if (leftRem == 0 && rightRem == 0)
        set.add(sb.toString());
    } else {
      char c = s.charAt(index);
      int len = sb.length();
      if (c != '(' && c != ')') {
        sb.append(c);
        helper(s, index + 1, left, right, leftRem, rightRem, sb);
        sb.deleteCharAt(len);
      } else {
        if (c == '(') {
          sb.append(c);
          helper(s, index + 1, left + 1, right, leftRem, rightRem, sb);
          sb.deleteCharAt(len);
          if (leftRem > 0) {
            helper(s, index + 1, left, right, leftRem - 1, rightRem, sb);
          }
        } else {
          if (right < left) {
            sb.append(c);
            helper(s, index + 1, left, right + 1, leftRem, rightRem, sb);
            sb.deleteCharAt(len);
          }
          if (rightRem > 0) {
            helper(s, index + 1, left, right, leftRem, rightRem - 1, sb);
          }
        }
      }
    }
  }

  // Limited recursions
  // Predetermine the leftRemoved and rightRemoved, really smart way to do it
  public List<String> removeInvalidParentheses(String s) {
    int left = 0, right = 0;
    for (char c : s.toCharArray()) {
      if (c == '(')
        left++;
      else if (c == ')') {
        if (left == 0)
          right++;
        else
          left--;
      }
    }
    reset();
    helper(s, 0, 0, 0, left, right, new StringBuffer());
    return new ArrayList<String>(set);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String s1 = "()())()", s2 = "(a)())()", s3 = ")(";
    System.out.println(s.removeInvalidParentheses(s1));
    System.out.println(s.removeInvalidParentheses(s2));
    System.out.println(s.removeInvalidParentheses(s3));

  }

}
