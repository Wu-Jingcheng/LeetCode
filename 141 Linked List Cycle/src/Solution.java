import java.util.*;

public class Solution {

  // Dual Pointer
  public boolean hasCycle(ListNode head) {
    if(head==null)return false;
    ListNode slow = head, fast = head.next;
    while (fast != null && fast.next != null) {
      if (slow == fast)
        return true;
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }

  // HashSet
  public boolean hasCycle2(ListNode head) {
    Set<ListNode> set = new HashSet<ListNode>();
    while (head != null) {
      if (set.contains(head))
        return true;
      else
        set.add(head);
      head = head.next;
    }
    return false;
  }

  public static void main(String[] args) {
    ListNode ln1 = new ListNode(3), lh1 = new ListNode(2);
    ln1.next = lh1;
    lh1.next = new ListNode(0);
    lh1.next.next = new ListNode(-4);
    ln1.next.next.next = ln1;

    ListNode ln2 = new ListNode(1), lh2 = new ListNode(2);
    ln2.next = lh2;
    lh2.next = ln2;

    ListNode ln3 = new ListNode(1);

    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.hasCycle(ln1) == true));
    System.out.println("Checking case2: " + (s.hasCycle(ln2) == true));
    System.out.println("Checking case3: " + (s.hasCycle(ln3) == false));
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
