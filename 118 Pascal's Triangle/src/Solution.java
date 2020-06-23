import java.util.*;

public class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (numRows-- > 0)
      res.add(new ArrayList<Integer>() {
        {
          add(1);
        }
      });
    for (; numRows > 0; numRows--) {
      int left, right;
      List<Integer> temp = new ArrayList<Integer>();
      List<Integer> pre = res.get(res.size() - 1);
      for (int i = 0; i <= pre.size(); i++) {
        left = i == 0 ? 0 : pre.get(i - 1);
        right = i == pre.size() ? 0 : pre.get(i);
        temp.add(left + right);
      }
      res.add(temp);
    }
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.generate(5));
    System.out.println(s.generate(0));
    System.out.println(s.generate(1));
  }

}
