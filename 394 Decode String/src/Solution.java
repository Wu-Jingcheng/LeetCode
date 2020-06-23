
public class Solution {
  public String decodeString(String s) {
    return decodeHelper(s, 0, s.length() - 1);
  }

  private String decodeHelper(String s, int start, int end) {
    StringBuffer sb = new StringBuffer();
    int i = start;
    while (i <= end) {
      char c = s.charAt(i);
      if (c != '[' && c != ']' && (c < '0' || c > '9')) {
        sb.append(c);
        i++;
      } else {
        int numStart = i;
        for (; s.charAt(i) >= '0' && s.charAt(i) <= '9'; i++);
        int times = Integer.valueOf(s.substring(numStart, i));
        int subStart = i + 1, count = 0;
        do {
          if (s.charAt(i) == '[')
            count++;
          else if (s.charAt(i) == ']')
            count--;
          i++;
        } while (count > 0);
        String substring = decodeHelper(s, subStart, i - 2);
        for (; times > 0; times--)
          sb.append(substring);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String s1 = "3[a]2[bc]", s2 = "3[a2[c]]", s3 = "2[abc]3[cd]ef";
    Solution s = new Solution();
    System.out.println("Case1: " + s.decodeString(s1));
    System.out.println("Case2: " + s.decodeString(s2));
    System.out.println("Case3: " + s.decodeString(s3));
  }

}
