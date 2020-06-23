
public class Solution {

  private int max = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    maxPathSumCore(root);
    return max;
  }

  private int maxPathSumCore(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = maxPathSumCore(root.left);
    int right = maxPathSumCore(root.right);
    int temp = Math.max(Math.max(left + right + root.val, root.val),
        Math.max(left + root.val, right + root.val));
    if (temp > max)
      max = temp;
    return Math.max(Math.max(left, right), 0) + root.val;
  }

  public static void main(String[] args) {
    TreeNode tn1 = new TreeNode(1);
    tn1.left = new TreeNode(2);
    tn1.right = new TreeNode(3);

    TreeNode tn2 = new TreeNode(-10);
    tn2.left = new TreeNode(9);
    tn2.right = new TreeNode(20);
    tn2.right.left = new TreeNode(15);
    tn2.right.right = new TreeNode(7);

    Solution s1 = new Solution(), s2 = new Solution();

    System.out.println("Checking case1: " + (s1.maxPathSum(tn1) == 6));
    System.out.println("Checking case2: " + (s2.maxPathSum(tn2) == 42));
  }

}
