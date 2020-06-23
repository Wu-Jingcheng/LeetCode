
public class Solution {
  public boolean isAnagram(String s, String t) {
    int[] checklist = new int[26];
    for (char c : s.toCharArray())
      checklist[c - 'a']++;
    for (char c : t.toCharArray())
      checklist[c - 'a']--;
    for (int num : checklist)
      if (num != 0)
        return false;
    return true;
  }

  public static void main(String[] args) {
    Solution solu = new Solution();
    String s = "anagram", t = "nagaram";
    System.out.println(solu.isAnagram(s, t));// true
    s = "rat";
    t = "car";
    System.out.println(solu.isAnagram(s, t));// false
  }

}
