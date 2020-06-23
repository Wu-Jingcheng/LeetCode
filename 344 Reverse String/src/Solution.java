
public class Solution {
  // save time and space
  public void reverseString(char[] s) {
    int left = 0, right = s.length - 1;
    while (left < right) {
      char temp = s[left];
      s[left++] = s[right];
      s[right--] = temp;
    }
  }

  // normal way
  public void reverseString2(char[] s) {
    int left = 0, right = s.length - 1;
    while (left < right)
      swap(s, left++, right--);
  }

  private void swap(char[] s, int i, int j) {
    char temp = s[i];
    s[i] = s[j];
    s[j] = temp;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    char[] s1 = "hello".toCharArray();
    char[] s2 = "Hannah".toCharArray();
    s.reverseString(s1);
    s.reverseString(s2);
    System.out.println(new String(s1));
    System.out.println(new String(s2));
  }

}
