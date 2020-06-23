import java.util.Stack;

public class Solution {
  // 简单算法：利用栈
  public boolean isValid2(String s) {
    char current;
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
      current = s.charAt(i);
      if (current == '(' || current == '{' || current == '[')
        stack.push(current);
      else {
        if (stack.isEmpty())
          return false;
        else if (current == ')' && stack.peek() != '(' || current == ']' && stack.peek() != '['
            || current == '}' && stack.peek() != '{')
          return false;
        stack.pop();
      }
    }
    return stack.isEmpty();
  }

  // 初级算法
  public boolean isValid(String s) {
    char[] str = s.toCharArray();
    if (str.length == 0)
      return true;
    return isValidCore(str, 0, str.length - 1);
  }

  private boolean isValidCore(char[] str, int start, int end) {
    if (start > end)
      return true;
    if (start == end)
      return false;
    char target;
    int index, count = 0;
    if (str[start] == '(')
      target = ')';
    else if (str[start] == '[')
      target = ']';
    else
      target = '}';
    for (index = start + 1; index <= end && !(count == 0 && str[index] == target); index++) {
      if (str[index] == str[start])
        count++;
      if (str[index] == target && count != 0)
        count--;
    }
    return index <= end && isValidCore(str, start + 1, index - 1)
        && isValidCore(str, index + 1, end);
  }

  public static void main(String[] args) {
    String str1 = "()";
    String str2 = "()[]{}";
    String str3 = "([)]";
    String str4 = "{[]}";
    String str5 = "((){()})";
    String str6 = "{)";
    Solution s = new Solution();

    System.out.println("Checking str1: " + s.isValid2(str1));
    System.out.println("Checking str2: " + s.isValid2(str2));
    System.out.println("Checking str3: " + !s.isValid2(str3));
    System.out.println("Checking str4: " + s.isValid2(str4));
    System.out.println("Checking str5: " + s.isValid2(str5));
    System.out.println("Checking str6: " + !s.isValid2(str6));
  }

}
