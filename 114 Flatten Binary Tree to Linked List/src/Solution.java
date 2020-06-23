import java.util.Queue;
import java.util.LinkedList;

public class Solution {

  public void flatten(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    flattenCore(root, queue);
    TreeNode dummyRoot = new TreeNode(0);
    while (!queue.isEmpty()) {
      dummyRoot.right = queue.poll();
      dummyRoot = dummyRoot.right;
    }
  }

  private void flattenCore(TreeNode root, Queue<TreeNode> queue) {
    if (root != null) {
      queue.add(root);
      flattenCore(root.left, queue);
      flattenCore(root.right, queue);
      root.left = null;
    }
  }

  public static void main(String[] args) {
    TreeNode tn = new TreeNode(1);
    tn.left = new TreeNode(2);
    tn.left.left = new TreeNode(3);
    tn.left.right = new TreeNode(4);
    tn.right = new TreeNode(5);
    tn.right.right = new TreeNode(6);

    Solution s = new Solution();
    s.flatten(tn);

    System.out.println("Checking: " + (tn.val == 1 && tn.right.val == 2 && tn.right.right.val == 3
        && tn.right.right.right.val == 4 && tn.right.right.right.right.val == 5
        && tn.right.right.right.right.right.val == 6));
  }

}
