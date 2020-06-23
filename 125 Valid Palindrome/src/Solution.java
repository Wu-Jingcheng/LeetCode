
public class Solution {
  public boolean isPalindrome(String s) {
    if (s.length() < 2)
      return true;
    int i = 0, j = s.length() - 1;
    char left = s.charAt(i), right = s.charAt(j);
    int diff = 'a' - 'A';
    while (i < j) {
      if (left < '0' || left > '9' && left < 'A' || left > 'Z' && left < 'a' || left > 'z')
        left = s.charAt(++i);
      else if (right < '0' || right > '9' && right < 'A' || right > 'Z' && right < 'a'
          || right > 'z')
        right = s.charAt(--j);
      else if (left == right || right >= 'a' && left + diff == right
          || left >= 'a' && left == right + diff) {
        left = s.charAt(++i);
        right = s.charAt(--j);
      } else
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String str1 = "A man, a plan, a canal: Panama", str2 = "race a car", str3 = "0P";
    Solution s = new Solution();
    System.out.println(s.isPalindrome(str1) == true);
    System.out.println(s.isPalindrome(str2) == false);
    System.out.println(s.isPalindrome(str3) == false);
  }

}
