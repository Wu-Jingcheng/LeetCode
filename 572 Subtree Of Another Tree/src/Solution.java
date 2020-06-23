import java.util.*;

public class Solution {
  private boolean flag;

  public boolean isSubtree(TreeNode s, TreeNode t) {
    flag = false;
    int tDepth = depth(t);
    TreeNode dummyRoot = new TreeNode(0);
    List<TreeNode> list = new LinkedList<TreeNode>();
    dummyRoot.left = keeplevel(s, t, list, tDepth);
    return flag;
  }

  private int depth(TreeNode t) {
    if (t == null)
      return 0;
    return 1 + Math.max(depth(t.left), depth(t.right));
  }

  private TreeNode keeplevel(TreeNode s, TreeNode t, List<TreeNode> list, int tDepth) {
    if (s == null || flag)
      return null;
    TreeNode left = keeplevel(s.left, t, list, tDepth);
    TreeNode right = keeplevel(s.right, t, list, tDepth);
    int l = left == null ? 1 : left.val + 1;
    int r = right == null ? 1 : right.val + 1;
    TreeNode node = new TreeNode(Math.max(l, r));
    if (node.val == tDepth && match(s, t)) {
      flag = true;
      return null;
    }
    node.left = left;
    node.right = right;
    return node;
  }

  private boolean match(TreeNode s, TreeNode t) {
    if (s == null && t == null)
      return true;
    if (s == null || t == null)
      return false;
    return s.val == t.val && match(s.left, t.left) && match(s.right, t.right);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode tn1 = new TreeNode(3);
    tn1.left = new TreeNode(4);
    tn1.right = new TreeNode(5);
    tn1.left.left = new TreeNode(1);
    tn1.left.right = new TreeNode(2);

    TreeNode t = new TreeNode(4);
    t.left = new TreeNode(1);
    t.right = new TreeNode(2);

    System.out.println(s.isSubtree(tn1, t));// true

    tn1.left.right.left = new TreeNode(0);
    System.out.println(s.isSubtree(tn1, t));// false
  }

}


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}
