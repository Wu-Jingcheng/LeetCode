
public class Solution {
  // Hash code
  public int strStr(String haystack, String needle) {
    int needleLen = needle.length();
    int haystackLen = haystack.length();
    if (needleLen == 0)
      return 0;
    if (haystackLen < needleLen)
      return -1;
    int hashCode = 0, needleCode = 0;
    int slow = 0, fast = 0;
    int multiple = 1;
    for (int i = 0; i < needleLen; i++)
      multiple *= 26;
    for (char c : needle.toCharArray())
      needleCode = needleCode * 26 + c - 'a';
    for (; fast < needleLen; fast++)
      hashCode = hashCode * 26 + haystack.charAt(fast) - 'a';
    for (; hashCode != needleCode && fast < haystackLen; fast++, slow++) {
      hashCode =
          hashCode * 26 + haystack.charAt(fast) - 'a' - (haystack.charAt(slow) - 'a') * multiple;
    }
    if (hashCode == needleCode)
      return slow;
    else
      return -1;
  }

  // Good, but beyond time limit
  public int strStr2(String haystack, String needle) {
    if (needle.length() == 0)
      return 0;
    char needleHead = needle.charAt(0);
    for (int i = 0; i < haystack.length(); i++) {
      char cur = haystack.charAt(i);
      if (cur == needleHead) {
        boolean flag = true;
        for (int j = 1; j < needle.length(); j++) {
          if (i + j == haystack.length() || haystack.charAt(i + j) != needle.charAt(j)) {
            flag = false;
            break;
          }
        }
        if (flag)
          return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    String haystack1 = "hello", needle1 = "ll";
    String haystack2 = "aaaaa", needle2 = "bba";
    String haystack3 = "ababc", needle3 = "abc";
    Solution s = new Solution();
    System.out.println(s.strStr(haystack1, needle1));
    System.out.println(s.strStr(haystack2, needle2));
    System.out.println(s.strStr(haystack3, needle3));
  }
}
