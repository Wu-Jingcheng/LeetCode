public class Solution {

  public int[] maxDepthAfterSplit(String seq) {
    int count0 = 0, count1 = 0;
    int[] res = new int[seq.length()];
    for (int i = 0; i < res.length; i++) {
      char cur = seq.charAt(i);
      if (cur == '(') {
        if (count1 < count0) {
          count1++;
          res[i] = 1;
        } else
          count0++;
      } else {
        if (count0 > count1)
          count0--;
        else {
          count1--;
          res[i] = 1;
        }
      }
    }
    return res;
  }

  public static void print(int[] nums) {
    for (int num : nums)
      System.out.print(num + "!");
    System.out.println();
  }

  public static void main(String[] args) {
    String seq1 = "(()())", seq2 = "()(())()";
    Solution s = new Solution();
    print(s.maxDepthAfterSplit(seq1));
    print(s.maxDepthAfterSplit(seq2));
  }

}
