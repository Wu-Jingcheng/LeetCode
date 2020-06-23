import java.util.*;

public class Solution {

  public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    for (int num : nums) {
      if (!map.containsKey(num))
        map.put(num, new Node(num, 1));
      else
        map.get(num).value++;
    }
    Node[] list = new Node[map.size()];
    int i = 0;
    for (Node node : map.values()) {
      list[i++] = node;
    }
    Arrays.sort(list, new Comparator<Node>() {
      public int compare(Node node1, Node node2) {
        return node2.value - node1.value;
      }
    });
    List<Integer> res = new ArrayList<Integer>();
    for (i = 0; i < k; i++)
      res.add(list[i].key);
    return res;
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 1, 1, 2, 2, 3}, nums2 = {1};
    int k1 = 2, k2 = 1;
    Solution s = new Solution();
    System.out.println(s.topKFrequent(nums1, k1));
    System.out.println(s.topKFrequent(nums2, k2));
  }

}


class Node {
  public int key;
  public int value;

  public Node(int key, int value) {
    this.key = key;
    this.value = value;
  }
}
