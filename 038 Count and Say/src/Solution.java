
public class Solution {
  public String countAndSay(int n) {
    String str = "1";
    for (; n > 1; n--) {
      int count = 0;
      StringBuffer sb = new StringBuffer();
      char cur = str.charAt(0);
      for (char c : str.toCharArray()) {
        if (c == cur)
          count++;
        else {
          sb.append(String.valueOf(count));
          sb.append(cur);
          count = 1;
          cur = c;
        }
      }
      sb.append(String.valueOf(count));
      sb.append(cur);
      str = sb.toString();
    }
    return str;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.countAndSay(4));
    System.out.println(s.countAndSay(5));
  }
}
