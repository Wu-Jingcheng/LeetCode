import java.util.Arrays;

public class Solution {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0)
      return null;
    int pivot = preorder[0];
    int i;
    for (i = 0; i < inorder.length && inorder[i] != pivot; i++);
    int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1),
        preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length),
        inLeft = Arrays.copyOfRange(inorder, 0, i),
        inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
    TreeNode node = new TreeNode(pivot);
    node.left = buildTree(preLeft, inLeft);
    node.right = buildTree(preRight, inRight);
    return node;
  }

  public static void main(String[] args) {
    int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
    Solution s = new Solution();

    TreeNode tn = s.buildTree(preorder, inorder);
    System.out.println("Checking: " + (tn.val == 3 && tn.left.val == 9 && tn.right.val == 20
        && tn.right.left.val == 15 && tn.right.right.val == 7));
  }

}
