import java.util.*;

public class Solution {

  public List<String> letterCombinations(String digits) {
    final String[] checklist = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<String>();
    if (digits.length() == 0)
      return res;
    int len = digits.length();
    char[] dummyChar = new char[len];
    letterCombinationsCore(digits, 0, checklist, len, dummyChar, res);
    return res;
  }

  private void letterCombinationsCore(String digits, int index, final String[] checklist, int len,
      char[] dummyChar, List<String> res) {
    int value = (int) (digits.charAt(index) - '2');
    int length = checklist[value].length();
    for (int i = 0; i < length; i++) {
      dummyChar[index] = checklist[value].charAt(i);
      if (index < len - 1)
        letterCombinationsCore(digits, index + 1, checklist, len, dummyChar, res);
      else
        res.add(new String(dummyChar));
    }
  }

  public static void main(String[] args) {
    String str = "23";
    Solution s = new Solution();
    System.out.println(s.letterCombinations(str));
  }

}
