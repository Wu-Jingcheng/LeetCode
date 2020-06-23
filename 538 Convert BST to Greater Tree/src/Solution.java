
public class Solution {
  public TreeNode convertBST(TreeNode root) {
    convertHelper(root, 0);
    return root;
  }

  private int convertHelper(TreeNode node, int addition) {
    if (node == null)
      return 0;
    int right = node.val + convertHelper(node.right, addition);
    node.val = right + addition;
    int left = convertHelper(node.left, node.val);
    return left + right;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(13);
    Solution s = new Solution();
    root = s.convertBST(root);
    System.out.println(root.left.val);
    System.out.println(root.val);
    System.out.println(root.right.val);
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
