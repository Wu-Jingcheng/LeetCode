
public class Solution {
  public TreeNode invertTree(TreeNode root) {
    invertTreeCore(root);
    return root;
  }

  private void invertTreeCore(TreeNode node) {
    if (node == null)
      return;
    TreeNode left = node.left;
    node.left = node.right;
    node.right = left;
    invertTreeCore(node.left);
    invertTreeCore(node.right);
  }

  public static void main(String[] args) {

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
