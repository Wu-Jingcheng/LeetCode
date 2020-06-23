
public class Solution {
  public String reverseWords(String s) {
    if (s.isEmpty())
      return "";
    char[] array = s.toCharArray();
    reverse(array, 0, array.length - 1);
    int start = 0, end = array.length - 1;
    for (; start < array.length && array[start] == ' '; start++);
    for (; end >= 0 && array[end] == ' '; end--);

    int pre = start, cur = start;
    StringBuffer sb = new StringBuffer();

    for (; cur <= end; cur++) {
      if (array[cur] == ' ') {
        reverse(array, pre, cur - 1);
        for (; array[cur] == ' '; cur++);
        pre = cur;
      }
    }
    reverse(array, pre, end);

    for (cur = start; cur <= end; cur++) {
      if (array[cur] == ' ') {
        sb.append(' ');
        for (; array[cur] == ' '; cur++);
      }
      sb.append(array[cur]);
    }

    return sb.toString();
  }

  private void reverse(char[] arr, int i, int j) {
    while (i < j) {
      swap(arr, i, j);
      i++;
      j--;
    }
  }

  private void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    String s1 = "the sky is blue", s2 = "    hello world!   ", s3 = "a good    example",
        s4 = "  p p a p   ", s5 = "", s6 = " ";

    Solution s = new Solution();
    System.out.println(s.reverseWords(s1));
    System.out.println(s.reverseWords(s2));
    System.out.println(s.reverseWords(s3));
    System.out.println(s.reverseWords(s4));
    System.out.println(s.reverseWords(s5));
    System.out.println(s.reverseWords(s6));
  }

}
