
public class Solution {
  public boolean isBalanced(TreeNode root) {
    return isBalancedHelper(root, 1) != -1;
  }

  private int isBalancedHelper(TreeNode node, int level) {
    if (node == null)
      return level;
    level++;
    int left = isBalancedHelper(node.left, level);
    if (left == -1)
      return -1;
    int right = isBalancedHelper(node.right, level);
    if (right == -1 || left > right + 1 || left < right - 1)
      return -1;
    return Math.max(left, right);
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    TreeNode root1 = new TreeNode(3);
    root1.left = new TreeNode(9);
    root1.right = new TreeNode(20);
    root1.right.left = new TreeNode(15);
    root1.right.right = new TreeNode(7);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.right = new TreeNode(2);
    root2.left.left = new TreeNode(3);
    root2.left.right = new TreeNode(3);
    root2.left.left.left = new TreeNode(4);
    root2.left.left.right = new TreeNode(4);

    System.out.println(s.isBalanced(root1));// true
    System.out.println(s.isBalanced(root2));// false
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
