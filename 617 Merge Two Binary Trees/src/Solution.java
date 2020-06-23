
public class Solution {
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null)
      return t2;
    if (t2 == null)
      return t1;
    t1.val += t2.val;
    t1.left = mergeTrees(t1.left, t2.left);
    t1.right = mergeTrees(t1.right, t2.right);
    return t1;
  }

  public static void print(TreeNode tn) {
    if (tn == null) {
      System.out.print(null + "!");
      return;
    }
    System.out.print(tn.val + "!");
    print(tn.left);
    print(tn.right);
  }

  public static void main(String[] args) {
    TreeNode tree1 = new TreeNode(1);
    tree1.left = new TreeNode(3);
    tree1.left.left = new TreeNode(5);
    tree1.right = new TreeNode(2);

    TreeNode tree2 = new TreeNode(2);
    tree2.left = new TreeNode(1);
    tree2.left.right = new TreeNode(4);
    tree2.right = new TreeNode(3);
    tree2.right.right = new TreeNode(7);

    Solution s = new Solution();
    print(s.mergeTrees(tree1, tree2));
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
