
public class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode current = dummyHead;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        current.next = l1;
        l1 = l1.next;
      } else {
        current.next = l2;
        l2 = l2.next;
      }
      current = current.next;
    }
    if (l2 != null)
      current.next = l2;
    if (l1 != null)
      current.next = l1;
    return dummyHead.next;
  }

  public static void print(ListNode ln) {
    while (ln != null) {
      System.out.print(ln.val+"!");
      ln = ln.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    ListNode ln1 = new ListNode(1);
    ln1.next = new ListNode(2);
    ln1.next.next = new ListNode(4);

    ListNode ln2 = new ListNode(1);
    ln2.next = new ListNode(3);
    ln2.next.next = new ListNode(4);

    Solution s = new Solution();
    ListNode res = s.mergeTwoLists(ln1, ln2);
    print(res);

    ListNode ln3 = new ListNode(1);
    ln3.next = new ListNode(2);
    ln3.next.next = new ListNode(4);

    ListNode ln4 = new ListNode(1);
    ln4.next = new ListNode(3);
    ln4.next.next = new ListNode(4);
    ln4.next.next.next = new ListNode(9);
    ln4.next.next.next.next = new ListNode(100);

    ListNode res1 = s.mergeTwoLists(ln3, ln4);
    print(res1);
  }

}
