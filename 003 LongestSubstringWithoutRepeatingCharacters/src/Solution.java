import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int lengthOfLongestSubstring(String s) {
    int len = s.length(), res = 0;
    int i = -1, j = 0;
    int[] map = new int[128];
    Arrays.fill(map, -1);
    for (; j < len; j++) {
      int index = s.charAt(j);
      i = Math.max(i, map[index]);
      res = Math.max(res, j - i);
      map[index] = j;
    }
    return res;
  }

  public int lengthOfLongestSubstring2(String s) {
    int length = s.length(), ans = 0;
    int i = 0, j = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (; i < length && j < length; j++) {
      if (map.containsKey(s.charAt(j))) {
        i = Math.max(i, map.get(s.charAt(j)));
      }
      ans = Math.max(ans, j - i + 1);
      map.put(s.charAt(j), j + 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    String str1 = "abcabcbb";
    System.out.println("Checking str1: " + (s.lengthOfLongestSubstring(str1) == 3));

    String str2 = "bbbbbbbb";
    System.out.println("Checking str2: " + (s.lengthOfLongestSubstring(str2) == 1));

    String str3 = "pwekew";
    System.out.println("Checking str3: " + (s.lengthOfLongestSubstring(str3) == 4));
  }

}
