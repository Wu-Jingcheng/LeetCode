import java.util.Arrays;
import java.util.Comparator;

public class Solution {
  public String largestNumber(int[] nums) {
    String[] strs = new String[nums.length];
    for (int i = 0; i < nums.length; i++)
      strs[i] = String.valueOf(nums[i]);
    Arrays.sort(strs, new Comparator<String>() {
      public int compare(String str1, String str2) {
        String a = str1 + str2, b = str2 + str1;
        if (greaterThan(a, b))
          return -1;
        else
          return 1;
      }
    });
    StringBuffer sb = new StringBuffer();
    for (String str : strs)
      sb.append(str);
    return sb.charAt(0) == ('0') ? "0" : sb.toString();
  }


  private boolean greaterThan(String str1, String str2) {
    final int len = Math.min(str1.length(), str2.length());
    for (int i = 0; i < len; i++) {
      char a = str1.charAt(i);
      char b = str2.charAt(i);
      if (a > b)
        return true;
      else if (a < b)
        return false;
    }
    return str1.length() > str2.length();
  }

  public static void main(String[] args) {
    int[] nums1 = {10, 2}, nums2 = {3, 30, 34, 5, 9}, nums3 = {999999998, 999999997, 999999999},
        nums4 = {0, 9, 8, 7, 6, 5, 4, 3, 2, 1}, nums5 = {3, 30, 34, 5, 9};
    Solution s = new Solution();
    System.out.println(s.largestNumber(nums1));
    System.out.println(s.largestNumber(nums2));
    System.out.println(s.largestNumber(nums3));
    System.out.println(s.largestNumber(nums4));
    System.out.println(s.largestNumber(nums5));
  }

}
