
public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int len1 = 0, len2 = 0;
    ListNode cur1 = l1, cur2 = l2;
    for (; cur1 != null; len1++, cur1 = cur1.next);
    for (; cur2 != null; len2++, cur2 = cur2.next);
    if (len1 < len2) {
      int tmpLen = len1;
      len1 = len2;
      len2 = tmpLen;
      ListNode tmpLN = l1;
      l1 = l2;
      l2 = tmpLN;
    }
    int diff = len1 - len2;
    ListNode dummyHead = new ListNode(0);
    if (l2 != null)
      dummyHead.next = new ListNode(0);
    else
      return l1;
    dummyHead.val += addHelper(dummyHead.next, l1, l2, diff);
    return dummyHead.val == 0 ? dummyHead.next : dummyHead;
  }

  private int addHelper(ListNode current, ListNode l1, ListNode l2, int diff) {
    if (diff > 0) {
      current.next = new ListNode(0);
      int temp = l1.val + addHelper(current.next, l1.next, l2, diff - 1);
      current.val = temp % 10;
      return temp / 10;
    }
    if (l2.next == null) {
      int temp = l1.val + l2.val;
      current.val = temp % 10;
      return temp / 10;
    }
    current.next = new ListNode(0);
    int temp = l1.val + l2.val + addHelper(current.next, l1.next, l2.next, diff);
    current.val = temp % 10;
    return temp / 10;
  }

  public static void print(ListNode ln) {
    for (; ln != null; ln = ln.next)
      System.out.print(ln.val + "!");
    System.out.println();
  }

  public static void main(String[] args) {
    ListNode lna1 = new ListNode(7);
    lna1.next = new ListNode(2);
    lna1.next.next = new ListNode(4);
    lna1.next.next.next = new ListNode(3);

    ListNode lna2 = new ListNode(5);
    lna2.next = new ListNode(6);
    lna2.next.next = new ListNode(4);

    Solution s = new Solution();

    print(s.addTwoNumbers(lna1, lna2));
    print(s.addTwoNumbers(lna1.next, lna2));
    print(s.addTwoNumbers(lna1.next.next, lna2.next));
    print(s.addTwoNumbers(lna1, null));
    print(s.addTwoNumbers(null, lna1));
  }

}


class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}
