
public class Solution {
  // Modified / in-place
  public int rob(TreeNode root) {
    if (root == null)
      return 0;
    rob(root.left);
    rob(root.right);
    int ll = 0, lr = 0, rl = 0, rr = 0, l = 0, r = 0;
    if (root.left != null) {
      l = root.left.val;
      ll = root.left.left == null ? 0 : root.left.left.val;
      lr = root.left.right == null ? 0 : root.left.right.val;
    }
    if (root.right != null) {
      r = root.right.val;
      rl = root.right.left == null ? 0 : root.right.left.val;
      rr = root.right.right == null ? 0 : root.right.right.val;
    }
    root.val = Math.max(l + r, ll + lr + rl + rr + root.val);
    return root.val;
  }

  // Unmodified / not in-place
  public int rob2(TreeNode root) {
    if (root == null)
      return 0;
    TreeNode copy = new TreeNode(0);
    copyTree(root, copy);
    robHelper(copy);
    return copy.val;
  }

  private void robHelper(TreeNode node) {
    if (node == null)
      return;
    robHelper(node.left);
    robHelper(node.right);
    int ll = 0, lr = 0, rl = 0, rr = 0, l = 0, r = 0;
    if (node.left != null) {
      l = node.left.val;
      ll = node.left.left == null ? 0 : node.left.left.val;
      lr = node.left.right == null ? 0 : node.left.right.val;
    }
    if (node.right != null) {
      r = node.right.val;
      rl = node.right.left == null ? 0 : node.right.left.val;
      rr = node.right.right == null ? 0 : node.right.right.val;
    }
    node.val = Math.max(l + r, ll + lr + rl + rr + node.val);
  }

  private void copyTree(TreeNode node, TreeNode copy) {
    copy.val = node.val;
    if (node.left != null) {
      copy.left = new TreeNode(0);
      copyTree(node.left, copy.left);
    }
    if (node.right != null) {
      copy.right = new TreeNode(0);
      copyTree(node.right, copy.right);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    TreeNode tn = new TreeNode(3);
    tn.left = new TreeNode(2);
    tn.left.right = new TreeNode(3);
    tn.right = new TreeNode(3);
    tn.right.right = new TreeNode(1);

    System.out.println("Case1: " + (s.rob(tn) == 7));

    tn.val = 3;
    tn.left.val = 2;
    tn.left.right.val = 3;
    tn.right.val = 3;
    tn.right.right.val = 1;
    tn.left.left = new TreeNode(1);
    tn.right.left = new TreeNode(1);
    System.out.println("Case2: " + (s.rob(tn) == 9));

    tn.left.val = 100;
    tn.right.val = 100;
    System.out.println("Case3: " + (s.rob(tn) == 200));
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
