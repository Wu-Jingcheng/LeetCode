public class Solution {

  public boolean isPalindrome(ListNode head) {
    if (head == null)
      return true;
    ListNode firstHalfEnd = findFirstEnd(head);
    ListNode secondHalfStart = reverseLinkedList(firstHalfEnd.next);
    ListNode p1 = head;
    ListNode p2 = secondHalfStart;
    boolean res = true;
    while (res && p2 != null) {
      res = p1.val == p2.val;
      p1 = p1.next;
      p2 = p2.next;
    }
    firstHalfEnd.next = reverseLinkedList(secondHalfStart);
    return res;
  }

  private ListNode findFirstEnd(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private ListNode reverseLinkedList(ListNode head) {
    ListNode cur = head, pre = null;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

  // recursion is not O(n)
  private ListNode secHalf;
  private boolean isEven;

  public boolean isPalindrome2(ListNode head) {
    ListNode current = head;
    for (secHalf = head; current != null && current.next != null; secHalf = secHalf.next, current =
        current.next.next);
    isEven = current == null;
    return isPalindromeCore(head);
  }

  private boolean isPalindromeCore(ListNode head) {
    if (head == secHalf) {
      if (isEven) {
        return true;
      } else {
        secHalf = secHalf.next;
        return true;
      }
    }
    boolean isGood = isPalindromeCore(head.next) && head.val == secHalf.val;
    secHalf = secHalf.next;
    return isGood;
  }

  public static void main(String[] args) {
    ListNode ln = new ListNode(1);
    ln.next = new ListNode(2);
    Solution s = new Solution();

    System.out.println(s.isPalindrome(ln) == false);

    s = new Solution();
    ln.next.next = new ListNode(2);
    ln.next.next.next = new ListNode(1);
    System.out.println(s.isPalindrome(ln) == true);

    System.out.println(ln.next.next.next.next == null);
  }

}


class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}
