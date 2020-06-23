
public class Solution {
  public Node copyRandomList(Node head) {
    if (head == null)
      return null;
    Node cur, next;
    for (cur = head; cur != null; cur = next) {
      next = cur.next;
      cur.next = new Node(cur.val);
      cur.next.next = next;
    }
    Node res = head.next;
    for (cur = head; cur != null; cur = next.next) {
      next = cur.next;
      next.random = (cur.random == null ? null : cur.random.next);
    }
    for (cur = head; cur != null; cur = cur.next) {
      next = cur.next;
      cur.next = next.next;
      if (next.next != null)
        next.next = next.next.next;
    }
    return res;
  }

  public static void print(Node head) {
    for (; head != null; head = head.next) {
      System.out.print(head.val + "(" + (head.random == null ? null : head.random.val) + ")");
    }
    System.out.println(null + "");
  }

  public static void main(String[] args) {
    Node[] nodes1 = {new Node(7), new Node(13), new Node(11), new Node(10), new Node(1)};
    for (int i = 0; i < nodes1.length - 1; i++)
      nodes1[i].next = nodes1[i + 1];
    nodes1[0].random = null;
    nodes1[1].random = nodes1[0];
    nodes1[2].random = nodes1[4];
    nodes1[3].random = nodes1[2];
    nodes1[4].random = nodes1[0];
    Node[] nodes2 = {new Node(1), new Node(2)};
    for (int i = 0; i < nodes2.length - 1; i++)
      nodes2[i].next = nodes2[i + 1];
    nodes2[0].random = nodes2[1];
    nodes2[1].random = nodes2[1];
    Node[] nodes3 = {new Node(3), new Node(3), new Node(3)};
    for (int i = 0; i < nodes3.length - 1; i++)
      nodes3[i].next = nodes3[i + 1];
    nodes3[1].random = nodes3[0];

    Node n1 = nodes1[0], n2 = nodes2[0], n3 = nodes3[0], n4 = null;

    print(n1);
    print(n2);
    print(n3);
    print(n4);
    System.out.println();
    Solution s = new Solution();
    print(s.copyRandomList(n1));
    print(s.copyRandomList(n2));
    print(s.copyRandomList(n3));
    print(s.copyRandomList(n4));
  }

}


class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}
