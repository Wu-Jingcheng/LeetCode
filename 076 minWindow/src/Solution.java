import java.util.*;

public class Solution {

  public String minWindow(String s, String t) {
    int sLen = s.length(), tLen = t.length();
    if (sLen < tLen)
      return "";
    if (sLen == 0)
      return "";

    Map<Character, Integer> mapS = new HashMap<Character, Integer>(),
        mapT = new HashMap<Character, Integer>();
    for (char c : t.toCharArray())
      if (!mapT.containsKey(c))
        mapT.put(c, 1);
      else
        mapT.put(c, mapT.get(c) + 1);

    int left = 0, right = 0, validLeft = 0, validRight = 0;

    while (right < sLen || isValid(mapS, mapT)) {
      if (!isValid(mapS, mapT)) {
        char current = s.charAt(right++);
        if (mapT.containsKey(current)) {
          if (!mapS.containsKey(current))
            mapS.put(current, 1);
          else
            mapS.put(current, mapS.get(current) + 1);
        }
      } else {
        
//        System.out.println(left + "," + right);
        
        if (right - left < validRight - validLeft || validLeft == 0 && validRight == 0) {
          validLeft = left;
          validRight = right;
        }
        char current = s.charAt(left++);
        if (mapT.containsKey(current)) {
          try {
            mapS.put(current, mapS.get(current) - 1);
          } catch (Exception excpt) {
            System.out.println("Sth. goes wrong");
          }
        }
      }
    }
//    System.out.println(validLeft + "+" + validRight);
    return s.substring(validLeft, validRight);

  }

  private boolean isValid(Map<Character, Integer> mapS, Map<Character, Integer> mapT) {
    for (Character c : mapT.keySet()) {
/*      if (mapS.containsKey(c))
        System.out.println(mapT.get(c) + "," + mapS.get(c) + "," + (mapT.get(c) <= mapS.get(c)));*/
      if (!(mapS.containsKey(c) && mapS.get(c) >= mapT.get(c)))
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String S1 = "ADOBECODEBANC", T1 = "ABC";
    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.minWindow(S1, T1).equals("BANC")));
    System.out.println("Checking case2: " + (s.minWindow("aa", "aa")));
  }

}
