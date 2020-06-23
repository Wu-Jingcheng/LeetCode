
public class Solution {

  public ListNode middleNode(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode current = head;
    int count = 0;
    for (; current != null; current = current.next, count++);
    for (count /= 2, current = head; count != 0; current = current.next, count--);
    return current;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    ListNode ln1 = new ListNode(1);
    ln1.next = new ListNode(2);
    ln1.next.next = new ListNode(3);
    ln1.next.next.next = new ListNode(4);
    ln1.next.next.next.next = new ListNode(5);

    System.out.println("Checking case1: " + (s.middleNode(ln1).val == 3));
    ln1.next.next.next.next.next = new ListNode(6);
    System.out.println("Checking case2: " + (s.middleNode(ln1).val == 4));

    ListNode ln2 = null;
    System.out.println("Checking case3: " + (s.middleNode(ln2) == null));
  }

}
