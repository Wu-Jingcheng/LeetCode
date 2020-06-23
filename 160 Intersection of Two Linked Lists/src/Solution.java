
public class Solution {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lenA = 0, lenB = 0;
    ListNode current;
    for (current = headA; current != null; current = current.next, lenA++);
    for (current = headB; current != null; current = current.next, lenB++);
    if (lenA < lenB) {
      int temp = lenA;
      lenA = lenB;
      lenB = temp;
      current = headA;
      headA = headB;
      headB = current;
    }
    int diff = lenA - lenB;
    for (; diff != 0; diff--, headA = headA.next);
    while (headA != headB) {
      headA = headA.next;
      headB = headB.next;
    }
    return headA;
  }

  public static void main(String[] args) {
    ListNode I1 = new ListNode(8);
    I1.next = new ListNode(4);
    I1.next.next = new ListNode(5);
    ListNode A1 = new ListNode(4);
    A1.next = new ListNode(1);
    A1.next.next = I1;
    ListNode B1 = new ListNode(5);
    B1.next = new ListNode(0);
    B1.next.next = new ListNode(1);
    B1.next.next.next = I1;

    ListNode I2 = new ListNode(2);
    I2.next = new ListNode(4);
    ListNode A2 = new ListNode(0);
    A2.next = new ListNode(9);
    A2.next.next = new ListNode(1);
    A2.next.next.next = I2;
    ListNode B2 = new ListNode(3);
    B2.next = I2;

    ListNode A3 = new ListNode(2);
    A3.next = new ListNode(6);
    A3.next = new ListNode(4);
    ListNode B3 = new ListNode(1);
    B3.next = new ListNode(5);

    Solution s = new Solution();
    System.out.println("Checking case1: " + (s.getIntersectionNode(A1, B1) == I1));
    System.out.println("Checking case2: " + (s.getIntersectionNode(A2, B2) == I2));
    System.out.println("Checking case3: " + (s.getIntersectionNode(A3, B3) == null));
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
