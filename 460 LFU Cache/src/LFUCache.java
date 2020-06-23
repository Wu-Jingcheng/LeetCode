import java.util.*;
// 并没有写完的题目，可以考虑写成链表的链表的形式，可以加快速度
public class LFUCache {

  private void insertNode(DoubleLinkedNode node, DoubleLinkedNode pre, DoubleLinkedNode next) {
    node.pre = pre;
    node.next = next;
    if (pre != null)
      pre.next = node;
    else
      this.head = node;
    if (next != null)
      next.pre = node;
  }

  private void addNode(DoubleLinkedNode node) {
    insertNode(node, null, this.head);
  }

  private DoubleLinkedNode popNode(DoubleLinkedNode node) {
    DoubleLinkedNode pre = node.pre;
    DoubleLinkedNode next = node.next;
    if (pre != null)
      pre.next = next;
    else
      this.head = next;
    if (next != null)
      next.pre = pre;
    node.pre = null;
    node.next = null;
    return node;
  }

  private void updateNode(DoubleLinkedNode node) {
    if (node.next == null || node.next.freq > node.freq)
      return;
    DoubleLinkedNode current = node;
    while (current.next != null && current.next.freq <= node.freq)
      current = current.next;
    popNode(node);
    insertNode(node, current, current.next);
  }

  private DoubleLinkedNode popHead() {
    return popNode(this.head);
  }

  private DoubleLinkedNode head = null;
  private int capacity;
  private int size;
  private Map<Integer, DoubleLinkedNode> map = new HashMap<Integer, DoubleLinkedNode>();

  public LFUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (this.map.containsKey(key)) {
      DoubleLinkedNode node = this.map.get(key);
      node.freq++;
      updateNode(node);
      return node.value;
    } else
      return -1;
  }

  public void put(int key, int value) {
    if (this.capacity == 0)
      return;
    if (this.map.containsKey(key)) {
      DoubleLinkedNode node = this.map.get(key);
      node.freq++;
      node.value = value;
      updateNode(node);
    } else {
      DoubleLinkedNode node = new DoubleLinkedNode();
      node.value = value;
      node.key = key;
      map.put(key, node);
      if (this.size == this.capacity) {
        DoubleLinkedNode poppedNode = popHead();
        map.remove(poppedNode.key);
      } else {
        this.size++;
      }
      addNode(node);
      updateNode(node);
    }
  }

  public static void main(String[] args) {
    LFUCache cache = new LFUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println("Checking case1: " + (cache.get(1) == 1));
    cache.put(3, 3);
    System.out.println("Checking case2: " + (cache.get(2) == -1));
    System.out.println("Checking case3: " + (cache.get(3) == 3));
    cache.put(4, 4);
    System.out.println("Checking case4: " + (cache.get(1) == -1));
    System.out.println("Checking case5: " + (cache.get(3) == 3));
    System.out.println("Checking case6: " + (cache.get(4) == 4));
  }

}


class DoubleLinkedNode {
  public DoubleLinkedNode pre = null;
  public DoubleLinkedNode next = null;
  public int value;
  public int key;
  public int freq = 1;
}
