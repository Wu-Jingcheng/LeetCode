
public class Solution {

  public int maxDepth(TreeNode root) {
    if (root == null)
      return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    TreeNode tn = new TreeNode(3);
    tn.left = new TreeNode(9);
    tn.right = new TreeNode(20);
    tn.right.left = new TreeNode(15);
    tn.right.right = new TreeNode(7);

    System.out.println("Checking: " + (s.maxDepth(tn) == 3));
  }

}
