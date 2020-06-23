
public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null)
      return null;
    if (root == p || root == q)
      return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left == p && right == q || left == q && right == p)
      return root;
    if (left != null && left != p && left != q)
      return left;
    if (right != null && right != p && right != q)
      return right;
    if (left == null)
      return right;
    else
      return left;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    TreeNode root1 = new TreeNode(3);
    TreeNode node5 = new TreeNode(5), node1 = new TreeNode(1);
    root1.left = node5;
    root1.right = node1;
    node5.left = new TreeNode(6);
    node5.right = new TreeNode(2);
    node5.right.left = new TreeNode(7);
    TreeNode node4 = new TreeNode(4);
    node5.right.right = node4;
    node1.left = new TreeNode(0);
    node1.right = new TreeNode(8);

    System.out.println("case1: " + (s.lowestCommonAncestor(root1, node1, node5) == root1));
    System.out.println("case2: " + (s.lowestCommonAncestor(root1, node5, node4) == node5));
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
