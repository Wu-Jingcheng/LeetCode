import java.util.*;

public class Solution {
  // We delicately use the next pointer
  public Node connect(Node root) {
    connectHelper(root, null);
    return root;
  }

  private void connectHelper(Node root, Node next) {
    if (root == null)
      return;
    root.next = next;
    next = next == null ? null : next.left;
    connectHelper(root.left, root.right);
    connectHelper(root.right, next);
  }

  // Straightforward but we can be more neat
  public Node connect2(Node root) {
    Queue<Node> queue = new LinkedList<Node>();
    if (root != null) {
      queue.add(root);
      queue.add(null);
    }
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (node != null) {
        node.next = queue.peek();
        if (node.left != null)
          queue.add(node.left);
        if (node.right != null)
          queue.add(node.right);
      } else if (!queue.isEmpty())
        queue.add(null);
    }

    return root;
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    Solution s = new Solution();
    root = s.connect(root);
    System.out.println(root.next);
    System.out.println(root.left.next.val + "!" + root.right.next);
    System.out.println(root.left.left.next.val + "!" + root.left.right.next.val + "!"
        + root.right.left.next.val + "!" + root.right.right.next + "!");
  }

}


class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {}

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
};
