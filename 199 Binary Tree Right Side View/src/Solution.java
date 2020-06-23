import java.util.*;

public class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null)
      return new ArrayList<Integer>();
    List<Integer> res = new ArrayList<Integer>();
    rightSideViewHelper(root, res, 0);
    return res;
  }

  private void rightSideViewHelper(TreeNode node, List<Integer> res, int height) {
    if (node == null)
      return;
    if (res.size() == height)
      res.add(node.val);
    else
      res.set(height, node.val);
    height++;
    rightSideViewHelper(node.left, res, height);
    rightSideViewHelper(node.right, res, height);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(4);
    Solution s = new Solution();
    System.out.println(s.rightSideView(root));
    root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    System.out.println(s.rightSideView(root));
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
