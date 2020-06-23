import java.util.*;

public class Solution {

  // Good, but beyond time limit, maybe we can try dp
  public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
    int len = wordList.size();
    boolean hasEnd = false;
    for (String word : wordList)
      if (word.equals(endWord)) {
        hasEnd = true;
        break;
      }
    if (!hasEnd)
      return 0;
    boolean[] occupied = new boolean[len];
    boolean[][] connected = new boolean[len][len];
    generateConnected(connected, wordList);
    int res = 0;
    for (int i = 0; i < len; i++) {
      String word = wordList.get(i);
      if (distance(beginWord, word)) {
        int temp = ladderHelper(wordList, i, connected, occupied, endWord);
        if (temp > 0 && (temp + 1 < res || res == 0))
          res = temp + 1;
      }
    }
    return res;
  }

  private int ladderHelper(List<String> wordList, int i, boolean[][] connected, boolean[] occupied,
      String endWord) {
    if (occupied[i])
      return 0;
    if (wordList.get(i).equals(endWord))
      return 1;
    int res = 0;
    occupied[i] = true;
    for (int j = 0; j < connected.length; j++)
      if (connected[i][j]) {
        int temp = ladderHelper(wordList, j, connected, occupied, endWord);
        if (temp > 0 && (temp + 1 < res || res == 0))
          res = temp + 1;
      }
    occupied[i] = false;
    return res;
  }

  // dp, still beyond time limit
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    int len = wordList.size();
    boolean hasEnd = false;
    for (String word : wordList)
      if (word.equals(endWord)) {
        hasEnd = true;
        break;
      }
    if (!hasEnd)
      return 0;
    boolean[] occupied = new boolean[len];
    int[] dp = new int[len];
    boolean[][] connected = new boolean[len][len];
    generateConnected(connected, wordList);
    int res = 0;
    for (int i = 0; i < len; i++) {
      String word = wordList.get(i);
      if (distance(beginWord, word)) {
        int temp = ladderHelper(wordList, i, connected, occupied, endWord, dp);
        if (temp > 0 && (temp + 1 < res || res == 0))
          res = temp + 1;
      }
    }
    return res;
  }

  private boolean distance(String word1, String word2) {
    int count = 0;
    for (int i = 0; i < word1.length(); i++)
      if (word1.charAt(i) != word2.charAt(i))
        if (count == 1)
          return false;
        else
          count++;
    return count == 1;
  }

  private int ladderHelper(List<String> wordList, int i, boolean[][] connected, boolean[] occupied,
      String endWord, int[] dp) {
    if (occupied[i])
      return 0;
    if (wordList.get(i).equals(endWord))
      return 1;
    if (dp[i] > 0)
      return dp[i];
    int res = 0;
    occupied[i] = true;
    for (int j = 0; j < connected.length; j++)
      if (connected[i][j]) {
        int temp = ladderHelper(wordList, j, connected, occupied, endWord, dp);
        if (temp > 0 && (temp + 1 < res || res == 0)) {
          res = temp + 1;
          dp[i] = res;
        }
      }
    occupied[i] = false;
    return res;
  }

  private void generateConnected(boolean[][] connected, List<String> wordList) {
    int len = connected.length;
    for (int i = 0; i < len - 1; i++)
      for (int j = i + 1; j < len; j++)
        if (distance(wordList.get(i), wordList.get(j))) {
          connected[i][j] = true;
          connected[j][i] = true;
        }
  }

  public static void main(String[] args) {
    String beg1 = "hit", end1 = "cog";
    List<String> wl1 =
        new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    List<String> wl2 = new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
    List<String> wl3 = new ArrayList<String>(Arrays.asList("hot", "dot", "log", "cog"));
    Solution s = new Solution();
    System.out.println(s.ladderLength(beg1, end1, wl1));
    System.out.println(s.ladderLength(beg1, end1, wl2));
    System.out.println(s.ladderLength(beg1, end1, wl3));

    String beg2 = "hot", end2 = "dog";
    List<String> wl4 = new ArrayList<String>(Arrays.asList("hot", "dog", "dot"));
    System.out.println(s.ladderLength(beg2, end2, wl4));
  }

}
