
public class Solution {
  public void deleteNode(ListNode node) {
    for (; node.next.next != null; node = node.next)
      node.val = node.next.val;
    node.val = node.next.val;
    node.next = null;
  }

  public static void print(ListNode head) {
    for (; head != null; System.out.print(head.val + "!"), head = head.next);
    System.out.println(null + "");
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode head1 = new ListNode(4), node1 = new ListNode(5);
    head1.next = node1;
    node1.next = new ListNode(1);
    node1.next.next = new ListNode(9);
    print(head1);
    s.deleteNode(node1);
    print(head1);
  }

}


class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}
