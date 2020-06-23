
public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (n <= 0)
      return head;
    ListNode current = head;
    for (; n > 0; n--, current = current.next)
      if (current == null)
        return null;
    if (current == null)
      return head.next;
    ListNode removedOne = head;
    for (; current.next != null; current = current.next, removedOne = removedOne.next);
    removedOne.next = removedOne.next.next;
    return head;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    ListNode ln1 = new ListNode(1);
    ln1.next = new ListNode(2);
    ln1.next.next = new ListNode(3);
    ln1.next.next.next = new ListNode(4);
    ln1 = s.removeNthFromEnd(ln1, 3);
    System.out.println("Checking ln1&3: " + (ln1.next.val == 3));

    ListNode ln2 = new ListNode(1);
    ln2.next = new ListNode(2);
    ln2.next.next = new ListNode(3);
    ln2.next.next.next = new ListNode(4);
    ln2.next.next.next.next = new ListNode(5);
    ln2 = s.removeNthFromEnd(ln2, 2);
    System.out.println("Checking ln2&2: " + (ln2.next.next.next.val == 5));

    ListNode ln3 = new ListNode(1);
    ln3.next = new ListNode(2);
    ln3.next.next = new ListNode(3);
    ln3 = s.removeNthFromEnd(ln3, 3);
    System.out.println("Checking ln3&3: " + (ln3.val == 2));
    ln3 = s.removeNthFromEnd(ln3, 3);
    System.out.println("Checking an erroneous operation: " + (ln3 == null));
  }

}
