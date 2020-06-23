
public class Solution {
  private int pointer;

  public int evalRPN(String[] tokens) {
    pointer = tokens.length - 1;
    return evalRPNHelper(tokens);
  }

  // speed up a little bit
  private int evalRPNHelper(String[] tokens) {
    String token = tokens[pointer--];
    if (token.equals("+")) {
      int operand2 = evalRPNHelper(tokens);
      int operand1 = evalRPNHelper(tokens);
      return operand1 + operand2;
    } else if (token.equals("-")) {
      int operand2 = evalRPNHelper(tokens);
      int operand1 = evalRPNHelper(tokens);
      return operand1 - operand2;
    } else if (token.equals("*")) {
      int operand2 = evalRPNHelper(tokens);
      int operand1 = evalRPNHelper(tokens);
      return operand1 * operand2;
    } else if (token.equals("/")) {
      int operand2 = evalRPNHelper(tokens);
      int operand1 = evalRPNHelper(tokens);
      return operand1 / operand2;
    } else
      return Integer.valueOf(token);
  }

  private int evalRPNHelper2(String[] tokens) {
    String token = tokens[pointer--];
    if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/"))
      return Integer.valueOf(token);
    else {
      int operand2 = evalRPNHelper(tokens);
      int operand1 = evalRPNHelper(tokens);
      if (token.equals("+"))
        return operand1 + operand2;
      else if (token.equals("-"))
        return operand1 - operand2;
      else if (token.equals("*"))
        return operand1 * operand2;
      else
        return operand1 / operand2;
    }
  }

  public static void main(String[] args) {
    String[] tokens1 = {"2", "1", "+", "3", "*"};// 9
    String[] tokens2 = {"4", "13", "5", "/", "+"};// 6
    String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};// 22
    Solution s = new Solution();
    System.out.println(s.evalRPN(tokens1));
    System.out.println(s.evalRPN(tokens2));
    System.out.println(s.evalRPN(tokens3));
  }

}
