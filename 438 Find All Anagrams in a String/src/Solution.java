import java.util.*;

public class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<Integer>();
    if (p.length() > s.length())
      return res;

    int[] counts = new int[26];
    for (char c : p.toCharArray()) {
      counts[c - 'a']++;
    }

    int i = 0, j = p.length() - 1;
    for (int index = 0; index < j; index++) {
      char c = s.charAt(index);
      counts[c - 'a']--;
    }
    while (j < s.length()) {
      char cur = s.charAt(j++);
      counts[cur - 'a']--;
      boolean flag = true;
      for (char c : p.toCharArray()) {
        if (counts[c - 'a'] != 0) {
          flag = false;
          break;
        }
      }
      if (flag)
        res.add(i);
      cur = s.charAt(i++);
      counts[cur - 'a']++;
    }
    return res;
  }

  // ²Ý£¬Õâ¸ö³¬¼¶Âý
  public List<Integer> findAnagrams3(String s, String p) {
    List<Integer> res = new ArrayList<Integer>();
    if (p.length() > s.length())
      return res;

    int[] counts = new int[26];
    for (char c : p.toCharArray()) {
      counts[c - 'a']++;
    }

    int i = 0, j = p.length() - 1;
    for (int index = 0; index < j; index++) {
      char c = s.charAt(index);
      counts[c - 'a']--;
    }
    while (j < s.length()) {
      char cur = s.charAt(j++);
      counts[cur - 'a']--;
      boolean flag = true;
      for (char c : p.toCharArray()) {
        if (counts[c - 'a'] != 0) {
          flag = false;
          break;
        }
      }
      if (flag)
        res.add(i);
      cur = s.charAt(i++);
      counts[cur - 'a']++;
    }
    return res;
  }

  public List<Integer> findAnagrams2(String s, String p) {
    List<Integer> res = new ArrayList<Integer>();
    if (p.length() > s.length())
      return res;

    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (char c : p.toCharArray()) {
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }

    int i = 0, j = p.length() - 1;
    for (int index = 0; index < j; index++) {
      char c = s.charAt(index);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) - 1);
      }
    }
    while (j < s.length()) {
      char cur = s.charAt(j++);
      if (map.containsKey(cur))
        map.put(cur, map.get(cur) - 1);
      boolean flag = true;
      for (char c : map.keySet()) {
        if (map.get(c) != 0) {
          flag = false;
          break;
        }
      }
      if (flag)
        res.add(i);
      cur = s.charAt(i++);
      if (map.containsKey(cur))
        map.put(cur, map.get(cur) + 1);
    }
    return res;
  }

  public static void main(String[] args) {
    String s = "cbaebabacd", p = "abc";
    Solution solu = new Solution();
    System.out.println(solu.findAnagrams(s, p));
    s = "abab";
    p = "ab";
    System.out.println(solu.findAnagrams(s, p));
  }

}
