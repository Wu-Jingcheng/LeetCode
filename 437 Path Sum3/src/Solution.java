
public class Solution {
  public int pathSum(TreeNode root, int sum) {
    if (root == null)
      return 0;
    return pathSumHelper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
  }

  private int pathSumHelper(TreeNode root, int rem) {
    if (root == null)
      return 0;
    int count = 0;
    if (rem == root.val)
      count++;
    return count + pathSumHelper(root.left, rem - root.val)
        + pathSumHelper(root.right, rem - root.val);
  }

  public static void main(String[] args) {
    TreeNode tn = new TreeNode(10);
    tn.left = new TreeNode(5);
    tn.right = new TreeNode(-3);
    tn.left.left = new TreeNode(3);
    tn.left.right = new TreeNode(2);
    tn.right.right = new TreeNode(11);
    tn.left.left.left = new TreeNode(3);
    tn.left.left.right = new TreeNode(-2);
    tn.left.right.right = new TreeNode(1);
    Solution s = new Solution();
    System.out.println(s.pathSum(tn, 8));
    tn.left.left.left.left = new TreeNode(-3);
    System.out.println(s.pathSum(tn, 8));
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
