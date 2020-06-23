/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        return left.val == right.val && isSymmetricHelper(left.left, right.right)
                && isSymmetricHelper(left.right, right.left);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tn1 = new TreeNode(1);
        tn1.left = new TreeNode(2);
        tn1.right = new TreeNode(2);
        tn1.left.left = new TreeNode(3);
        tn1.left.right = new TreeNode(3);
        tn1.right.left = new TreeNode(3);
        tn1.right.right = new TreeNode(3);
        System.out.println(s.isSymmetric(tn1));

        tn1.left.left = null;
        tn1.right.left = null;
        System.out.println(s.isSymmetric(tn1));
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