
public class Solution {
  // 标准答案：分治法
  // 复杂度O(n)*O(logk)=O(n*logk)
  public ListNode mergeKLists(ListNode[] lists) {
    return divideLists(lists, 0, lists.length);
  }

  private ListNode divideLists(ListNode[] lists, int start, int end) {
    if (start == end)
      return null;
    if (start == end - 1)
      return lists[start];
    int mid = (start + end) / 2;
    return mergeLists(divideLists(lists, start, mid), divideLists(lists, mid, end));
  }

  private ListNode mergeLists(ListNode ln1, ListNode ln2) {
    ListNode dummyHead = new ListNode(0);
    ListNode current = dummyHead;
    while (ln1 != null && ln2 != null) {
      if (ln1.val < ln2.val) {
        current.next = ln1;
        ln1 = ln1.next;
      } else {
        current.next = ln2;
        ln2 = ln2.next;
      }
      current = current.next;
    }
    if (ln1 != null)
      current.next = ln1;
    if (ln2 != null)
      current.next = ln2;
    return dummyHead.next;
  }

  // 正常的想法
  // complexity: O(N)*O(k)=O(N*k)
  public ListNode mergeKLists2(ListNode[] lists) {
    if (lists.length == 0)
      return null;
    int last = lists.length - 1;
    ListNode dummyHead = new ListNode(0);
    ListNode current = dummyHead;
    while (last >= 0) {
      int minIndex = 0, i = 0, minVal = Integer.MAX_VALUE;
      for (; i <= last;) {
        if (lists[i] == null) {
          swap(lists, i, last);
          last--;
        } else {
          if (lists[i].val < minVal) {
            minIndex = i;
            minVal = lists[i].val;
          }
          i++;
        }
      }
      if (lists[minIndex] != null) {
        current.next = lists[minIndex];
        lists[minIndex] = lists[minIndex].next;
        current = current.next;
      }
    }
    return dummyHead.next;
  }

  private void swap(ListNode[] lists, int i, int j) {
    ListNode temp = lists[i];
    lists[i] = lists[j];
    lists[j] = temp;
  }

  public static void print(ListNode ln) {
    while (ln != null) {
      System.out.print(ln.val + "!");
      ln = ln.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    ListNode ln1 = new ListNode(1);
    ln1.next = new ListNode(4);
    ln1.next.next = new ListNode(5);

    ListNode ln2 = new ListNode(1);
    ln2.next = new ListNode(3);
    ln2.next.next = new ListNode(4);

    ListNode ln3 = new ListNode(2);
    ln3.next = new ListNode(6);

    Solution s = new Solution();

    ListNode[] lists = {ln1, ln2, ln3};
    print(s.mergeKLists(lists));
  }

}
