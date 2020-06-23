import java.util.*;

public class Solution {

  // 字典树
  public int minimumLengthEncoding(String[] words) {
    TrieNode trie = new TrieNode();
    Map<TrieNode, Integer> map = new HashMap<TrieNode, Integer>();

    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      TrieNode current = trie;
      for (int j = word.length() - 1; j >= 0; j--) {
        current = current.get(word.charAt(j));
      }
      map.put(current, i);
    }

    int res = 0;
    for (TrieNode node : map.keySet()) {
      if (node.count == 0)
        res += words[map.get(node)].length() + 1;
    }

    return res;
  }

  // 后缀检查方法O(\sum w^2)
  public int minimumLengthEncoding2(String[] words) {
    Set<String> good = new HashSet<String>(Arrays.asList(words));
    for (String word : words) {
      for (int i = 1; i < word.length(); i++)
        good.remove(word.substring(i));
    }
    int ans = 0;
    for (String word : good)
      ans += word.length() + 1;
    return ans;
  }

  public static void main(String[] args) {
    String[] words1 = {"time", "me", "bell"};
    String[] words2 = {"me", "time", "bell"};
    String[] words3 = {"good"};
    String[] words4 = {"me", "time"};
    String[] words5 = {};
    String[] words6 = {"time", "atime", "btime"};

    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.minimumLengthEncoding(words1) == 10));
    System.out.println("Checking case2: " + (s.minimumLengthEncoding(words2) == 10));
    System.out.println("Checking case3: " + (s.minimumLengthEncoding(words3) == 5));
    System.out.println("Checking case4: " + (s.minimumLengthEncoding(words4) == 5));
    System.out.println("Checking case5: " + (s.minimumLengthEncoding(words5) == 0));
    System.out.println("Checking case6: " + (s.minimumLengthEncoding(words6) == 12));
  }

}


class TrieNode {
  TrieNode[] children;
  int count;

  TrieNode() {
    children = new TrieNode[26];
    count = 0;
  }

  public TrieNode get(char c) {
    if (children[c - 'a'] == null) {
      children[c - 'a'] = new TrieNode();
      count++;
    }
    return children[c - 'a'];
  }
}

