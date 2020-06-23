
public class Solution {
  public int leastInterval(char[] tasks, int n) {
    int[] counts = new int[26];
    for (char c : tasks)
      counts[c - 'A']++;
    int max = 0;
    for (int count : counts)
      if (count > max)
        max = count;
    int maxNum = 0;
    for (int count : counts)
      if (count == max)
        maxNum++;
    int capacity = (max - 1) * (n + 1) + maxNum;
    if (capacity > tasks.length)
      return capacity;
    else
      return tasks.length;
  }

  public static void main(String[] args) {
    String str = "AAABBB";
    char[] arr = str.toCharArray();
    int n = 2;
    Solution s = new Solution();
    System.out.println(s.leastInterval(arr, n));
  }

}
