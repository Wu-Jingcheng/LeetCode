
public class Solution {
  public ListNode detectCycle(ListNode head) {
    if (head == null)
      return null;
    ListNode slow = head, fast = head.next;
    while (fast != null && fast.next != null && fast != slow) {
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast == null || fast.next == null)
      return null;
    int count = 1;

    for (fast = fast.next; fast != slow; count++, fast = fast.next);
    fast = head;
    slow = head;

    for (; count != 0; count--, fast = fast.next);
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }

  public static void main(String[] args) {
    ListNode ln1 = new ListNode(3), lh1 = new ListNode(2);
    ln1.next = lh1;
    lh1.next = new ListNode(0);
    lh1.next.next = new ListNode(-4);
    lh1.next.next.next = lh1;

    ListNode ln2 = new ListNode(1), lh2 = ln2;
    ln2.next = new ListNode(2);
    ln2.next.next = lh2;

    ListNode ln3 = new ListNode(1), lh3 = null;

    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.detectCycle(ln1) == lh1));
    System.out.println("Checking case2: " + (s.detectCycle(ln2) == lh2));
    System.out.println("Checking case3: " + (s.detectCycle(ln3) == lh3));
  }

}


class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}
