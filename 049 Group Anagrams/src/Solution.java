import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    for (String str : strs) {
      int[] counts = new int[26];
      for (char c : str.toCharArray())
        counts[c - 'a']++;
      StringBuffer sb = new StringBuffer();
      for (int count : counts) {
        sb.append(count);
        sb.append('!');
      }
      String key = sb.toString();
      if (!map.containsKey(key))
        map.put(key, new ArrayList<String>());
      map.get(key).add(str);
    }
    return new ArrayList<List<String>>(map.values());
  }

  public static void main(String[] args) {
    String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
    Solution s = new Solution();

    System.out.println("Checking strs1: " + s.groupAnagrams(strs1));
  }

}
