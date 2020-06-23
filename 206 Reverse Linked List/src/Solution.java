
public class Solution {

  public ListNode reverseList(ListNode head) {
    if (head == null)
      return null;
    ListNode pre = null, next = head.next;
    while (next != null) {
      head.next = pre;
      pre = head;
      head = next;
      next = next.next;
    }
    head.next = pre;
    return head;
  }

  public static void print(ListNode head) {
    while (head != null) {
      System.out.print(head.val + "!");
      head = head.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    ListNode ln1 = new ListNode(1);
    ln1.next = new ListNode(2);
    ln1.next.next = new ListNode(3);
    ln1.next.next.next = new ListNode(4);
    ln1.next.next.next.next = new ListNode(5);

    Solution s = new Solution();


    print(s.reverseList(ln1));
  }

}


class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}
