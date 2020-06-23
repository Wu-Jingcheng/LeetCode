
public class Solution {
  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null)
      return 0;
    int[] dummyArr = new int[1];
    diameterOfBinaryTreeCore(root, dummyArr);
    return dummyArr[0]-1;
  }

  private int diameterOfBinaryTreeCore(TreeNode root, int[] dummyArr) {
    if (root == null)
      return 0;
    int left = diameterOfBinaryTreeCore(root.left, dummyArr);
    int right = diameterOfBinaryTreeCore(root.right, dummyArr);
    int length = left + right + 1;
    if (length > dummyArr[0])
      dummyArr[0] = length;
    return Math.max(left, right) + 1;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    TreeNode tn1 = new TreeNode(1);
    tn1.left = new TreeNode(2);
    tn1.right = new TreeNode(3);
    tn1.left.left = new TreeNode(4);
    tn1.left.right = new TreeNode(5);
    System.out.println("Checking tn1: " + (s.diameterOfBinaryTree(tn1) == 3));

    TreeNode tn2 = new TreeNode(1);
    tn2.right = new TreeNode(3);
    tn2.left = new TreeNode(2);
    tn2.left.left = new TreeNode(4);
    tn2.left.right = new TreeNode(5);
    tn2.left.left.left = new TreeNode(6);
    tn2.left.right.right = new TreeNode(7);
    tn2.left.left.left.left = new TreeNode(8);
    tn2.left.right.right.right = new TreeNode(9);
    System.out.println("Checking tn2: " + (s.diameterOfBinaryTree(tn2) == 6));
  }

}
