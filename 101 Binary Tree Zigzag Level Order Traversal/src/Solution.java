import java.util.*;

public class Solution {
  // Or BFS with doubleLinkedList
  // Or DfS with EvenOrOdd judgement
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    if (root != null)
      stack.push(root);
    int depth = 0;
    while (!stack.isEmpty()) {
      List<Integer> temp = new ArrayList<Integer>();
      while (!stack.isEmpty())
        queue.add(stack.pop());
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (depth % 2 == 0) {
          if (node.left != null)
            stack.push(node.left);
          if (node.right != null)
            stack.push(node.right);
        } else {
          if (node.right != null)
            stack.push(node.right);
          if (node.left != null)
            stack.push(node.left);
        }
        temp.add(node.val);
      }
      res.add(temp);
      depth++;
    }
    return res;
  }

  public static void main(String[] args) {
    TreeNode tn = new TreeNode(3);
    tn.left = new TreeNode(9);
    tn.right = new TreeNode(20);
    tn.right.left = new TreeNode(15);
    tn.right.right = new TreeNode(7);
    Solution s = new Solution();
    System.out.println(s.zigzagLevelOrder(tn));
    tn.left.left = new TreeNode(1);
    System.out.println(s.zigzagLevelOrder(tn));
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
