
public class Solution {

  public ListNode sortList(ListNode head) {
    // 1、递归结束条件
    if (head == null || head.next == null) {
      return head;
    }

    // 2、找到链表中间节点并断开链表 & 递归下探
    ListNode midNode = middleNode(head);
    ListNode rightHead = midNode.next;
    midNode.next = null;

    ListNode left = sortList(head);
    ListNode right = sortList(rightHead);

    // 3、当前层业务操作（合并有序链表）
    return mergeTwoLists(left, right);
  }

  // 找到链表中间节点（876. 链表的中间结点）
  private ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head.next.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  // 合并两个有序链表（21. 合并两个有序链表）
  private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode sentry = new ListNode(-1);
    ListNode curr = sentry;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        curr.next = l1;
        l1 = l1.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
      }

      curr = curr.next;
    }

    curr.next = l1 != null ? l1 : l2;
    return sentry.next;
  }

  public static void print(ListNode node) {
    while (node != null) {
      System.out.print(node.val + "!");
      node = node.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    ListNode ln1 = new ListNode(4);
    ln1.next = new ListNode(2);
    ln1.next.next = new ListNode(1);
    ln1.next.next.next = new ListNode(3);

    ListNode ln2 = new ListNode(-1);
    ln2.next = new ListNode(5);
    ln2.next.next = new ListNode(3);
    ln2.next.next.next = new ListNode(4);
    ln2.next.next.next.next = new ListNode(0);

    Solution s = new Solution();
    print(s.sortList(ln1));
    print(s.sortList(ln2));
  }

}


class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}
