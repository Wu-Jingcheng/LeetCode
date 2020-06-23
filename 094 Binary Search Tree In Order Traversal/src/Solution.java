import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
  // Iterative Solution
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if (root == null)
      return res;
    TreeNode current = root;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    while (current != null || !stack.isEmpty()) {
      while (current != null) {
        stack.push(current);
        current = current.left;
      }
      current = stack.pop();
      res.add(current.val);
      current = current.right;
    }
    return res;
  }

  // Recursive Solution
  public List<Integer> inorderTraversal1(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    inorderCore(root, res);
    return res;
  }

  private void inorderCore(TreeNode node, List<Integer> list) {
    if (node == null)
      return;
    inorderCore(node.left, list);
    list.add(node.val);
    inorderCore(node.right, list);
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    TreeNode tn1 = new TreeNode(1);
    tn1.right = new TreeNode(2);
    tn1.right.left = new TreeNode(3);

    System.out.println("Checking :" + s.inorderTraversal(tn1));
  }

}
