public class Solution {
  // In-order traversal
  int max = Integer.MIN_VALUE;

  public boolean isValidBST(TreeNode root) {
    if (root == null)
      return true;
    if (isValidBST(root.left)) {
      if (max < root.val) {
        max = root.val;
        return isValidBST(root.right);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    TreeNode tn1 = new TreeNode(2);
    tn1.left = new TreeNode(1);
    tn1.right = new TreeNode(3);

    TreeNode tn2 = new TreeNode(5);
    tn2.left = new TreeNode(1);
    tn2.right = new TreeNode(4);
    tn2.right.left = new TreeNode(3);
    tn2.right.right = new TreeNode(6);

    TreeNode tn3 = new TreeNode(5);
    tn3.left = new TreeNode(1);
    tn3.right = new TreeNode(7);
    tn3.right.left = new TreeNode(4);
    tn3.right.right = new TreeNode(8);

    TreeNode tn4 = new TreeNode(-28);
    tn4.left = new TreeNode(-30);
    tn4.left.right = new TreeNode(70);
    tn4.left.right.right = new TreeNode(-19);

    System.out.println("Checking case1: " + (s.isValidBST(tn1) == true));
    System.out.println("Checking case2: " + (s.isValidBST(tn2) == false));
    System.out.println("Checking case3: " + (s.isValidBST(tn3) == false));
    System.out.println("Checking case3: " + (s.isValidBST(tn4) == false));
    
    System.out.println(Double.MAX_VALUE);
    System.out.println(Double.MIN_VALUE);
    
  }

}
