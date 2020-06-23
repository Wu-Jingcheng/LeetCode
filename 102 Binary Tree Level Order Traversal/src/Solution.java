import java.util.List;
import java.util.ArrayList;

public class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> al = new ArrayList<List<Integer>>();
    levelOrderCore(root, 0, al);
    return al;
  }

  private void levelOrderCore(TreeNode root, int level, List<List<Integer>> al) {
    if (root == null)
      return;
    if (level == al.size())
      al.add(new ArrayList<Integer>());
    al.get(level).add(root.val);
    levelOrderCore(root.left, ++level, al);
    levelOrderCore(root.right, level, al);
  }

  public static void main(String[] args) {
    TreeNode tn1 = new TreeNode(3);
    tn1.left = new TreeNode(9);
    tn1.right = new TreeNode(20);
    tn1.right.left = new TreeNode(15);
    tn1.right.right = new TreeNode(7);

    Solution s = new Solution();

    System.out.println("Checking: " + s.levelOrder(tn1));
  }

}
