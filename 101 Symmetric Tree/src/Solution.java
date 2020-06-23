
public class Solution {

  public boolean isSymmetric(TreeNode root) {
    if (root == null)
      return true;
    return isSymmetricCore(root.left, root.right);
  }

  private boolean isSymmetricCore(TreeNode left, TreeNode right) {
    if (left == null && right == null)
      return true;
    if (left != null && right != null)
      return left.val == right.val && isSymmetricCore(left.left, right.right)
          && isSymmetricCore(left.right, right.left);
    else
      return false;
  }

  public static void main(String[] args) {
    TreeNode tn1 = new TreeNode(1);
    tn1.left = new TreeNode(2);
    tn1.right = new TreeNode(2);
    tn1.left.left = new TreeNode(3);
    tn1.right.right = new TreeNode(3);
    tn1.left.right = new TreeNode(4);
    tn1.right.left = new TreeNode(4);

    TreeNode tn2 = new TreeNode(1);
    tn2.left = new TreeNode(2);
    tn2.right = new TreeNode(2);
    tn2.left.right = new TreeNode(3);
    tn2.right.right = new TreeNode(4);

    Solution s = new Solution();
    System.out.println("Checking case1: " + (s.isSymmetric(tn1)));
    System.out.println("Checking case2: " + !(s.isSymmetric(tn2)));
  }

}
