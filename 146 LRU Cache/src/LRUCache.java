import java.util.*;

public class LRUCache {

  private void addNode(DoubleLinkedNode node) {
    node.next = this.head;
    if (this.head != null)
      this.head.pre = node;
    node.pre = null;
    this.head = node;
    if (this.tail == null)
      this.tail = node;
  }

  private void removeNode(DoubleLinkedNode node) {
    DoubleLinkedNode pre = node.pre;
    DoubleLinkedNode next = node.next;
    if (pre != null)
      pre.next = next;
    else
      this.head = next;

    if (next != null)
      next.pre = pre;
    else
      this.tail = pre;
  }

  private void moveToHead(DoubleLinkedNode node) {
    removeNode(node);
    addNode(node);
  }

  private DoubleLinkedNode popTail() {
    DoubleLinkedNode tail = this.tail;
    removeNode(tail);
    return tail;
  }

  private int size;
  private int capacity;
  private Map<Integer, DoubleLinkedNode> map = new HashMap<Integer, DoubleLinkedNode>();
  private DoubleLinkedNode head = null;
  private DoubleLinkedNode tail = null;

  public LRUCache(int capacity) {
    this.size = 0;
    this.capacity = capacity;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      DoubleLinkedNode node = map.get(key);
      moveToHead(node);
      return node.value;
    } else
      return -1;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      DoubleLinkedNode node = map.get(key);
      node.value = value;
      moveToHead(node);
    } else {
      DoubleLinkedNode node = new DoubleLinkedNode();
      node.value = value;
      node.key = key;
      this.map.put(key, node);
      addNode(node);
      this.size++;
    }

    if (this.size > this.capacity) {
      DoubleLinkedNode node = popTail();
      map.remove(node.key);
      size--;
    }
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println("Checking case1: " + (cache.get(1) == 1));
    cache.put(3, 3);
    System.out.println("Checking case2: " + (cache.get(2) == -1));
    cache.put(4, 4);
    System.out.println("Checking case3: " + (cache.get(1) == -1));
    System.out.println("Checking case4: " + (cache.get(3) == 3));
    System.out.println("Checking case5: " + (cache.get(4) == 4));
  }

}


class DoubleLinkedNode {
  public int key;
  public int value;
  public DoubleLinkedNode pre;
  public DoubleLinkedNode next;
}
