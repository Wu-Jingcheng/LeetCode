
public class Trie {
  private TrieNode dummyHead = new TrieNode();

  /** Initialize your data structure here. */
  public Trie() {

  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode current = dummyHead;
    for (char c : word.toCharArray()) {
      if (current.next[c - 'a'] == null)
        current.next[c - 'a'] = new TrieNode();
      current = current.next[c - 'a'];
    }
    current.isEnd = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode current = dummyHead;
    for (char c : word.toCharArray()) {
      current = current.next[c - 'a'];
      if (current == null)
        return false;
    }
    return current.isEnd;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode current = dummyHead;
    for (char c : prefix.toCharArray()) {
      current = current.next[c - 'a'];
      if (current == null)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Trie trie = new Trie();

    trie.insert("apple");
    System.out.println("Checking case1: " + (trie.search("apple") == true));
    System.out.println("Checking case2: " + (trie.search("app") == false));
    System.out.println("Checking case3: " + (trie.startsWith("app") == true));
    trie.insert("app");
    System.out.println("Checking case4: " + (trie.search("app") == true));
  }

}


class TrieNode {
  TrieNode[] next = new TrieNode[26];
  boolean isEnd = false;
}
