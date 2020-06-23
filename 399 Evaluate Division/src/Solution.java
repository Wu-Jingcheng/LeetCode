import java.util.*;

public class Solution {
  public double[] calcEquation(List<List<String>> equations, double[] values,
      List<List<String>> queries) {
    Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>();
    for (int i = 0; i < values.length; i++) {
      List<String> equation = equations.get(i);
      String a = equation.get(0), b = equation.get(1);
      double value = values[i];
      Map<String, Double> mapA, mapB;
      if (map.containsKey(a))
        mapA = map.get(a);
      else {
        mapA = new HashMap<String, Double>();
        map.put(a, mapA);
      }
      if (map.containsKey(b))
        mapB = map.get(b);
      else {
        mapB = new HashMap<String, Double>();
        map.put(b, mapB);
      }
      mapA.put(b, value);
      mapB.put(a, 1. / value);
    }

    double[] res = new double[queries.size()];
    for (int i = 0; i < res.length; i++) {
      List<String> query = queries.get(i);
      String a = query.get(0);
      String b = query.get(1);
      if (!map.containsKey(a) || !map.containsKey(b))
        res[i] = -1.;
      else if (a.equals(b))
        res[i] = 1.;
      else if (map.get(a).containsKey(b))
        res[i] = map.get(a).get(b);
      else {
        res[i] = dfs(map, a, b, new HashSet<String>());
        if (res[i] > 0) {
          map.get(a).put(b, res[i]);
          map.get(b).put(a, 1. / res[i]);
        }
      }
    }
    return res;
  }

  private double dfs(Map<String, Map<String, Double>> map, String a, String b, Set<String> set) {
    if (map.get(a).containsKey(b))
      return map.get(a).get(b);
    double res = -1.;
    for (String next : map.get(a).keySet()) {
      if (set.contains(next))
        continue;
      set.add(next);
      double temp = dfs(map, next, b, set);
      if (temp > 0) {
        res = map.get(a).get(next) * temp;
        break;
      }
    }
    return res;
  }

  // Might triger concurrent modification exception
  public double[] calcEquation2(List<List<String>> equations, double[] values,
      List<List<String>> queries) {
    Map<String, Node> map = new HashMap<String, Node>();
    for (int i = 0; i < values.length; i++) {
      List<String> equation = equations.get(i);
      String a = equation.get(0);
      String b = equation.get(1);
      double value = values[i];
      Node nodeA, nodeB;
      if (map.containsKey(a))
        nodeA = map.get(a);
      else {
        nodeA = new Node(a);
        map.put(a, nodeA);
      }
      if (map.containsKey(b))
        nodeB = map.get(b);
      else {
        nodeB = new Node(b);
        map.put(b, nodeB);
      }
      nodeA.setLink(nodeB, value);
      nodeB.setLink(nodeA, 1 / value);
      update(nodeA, nodeB);
      update(nodeB, nodeA);
    }

    int len = queries.size();
    double[] res = new double[len];
    for (int i = 0; i < len; i++) {
      List<String> query = queries.get(i);
      String a = query.get(0);
      String b = query.get(1);
      if (!map.containsKey(a) || !map.containsKey(b)) {
        res[i] = -1;
        continue;
      }
      Node nodeA = map.get(a);
      Node nodeB = map.get(b);
      if (!nodeA.map.containsKey(nodeB)) {
        res[i] = -1;
        continue;
      }
      res[i] = nodeA.map.get(nodeB);
    }

    return res;
  }

  private void update(Node nodeA, Node nodeB) {
    for (Node nodeMid : nodeA.map.keySet()) {
      if (!nodeMid.map.containsKey(nodeB)) {
        double value = nodeMid.map.get(nodeA) * nodeA.map.get(nodeB);
        nodeMid.map.put(nodeB, value);
        nodeB.map.put(nodeMid, 1 / value);
        update(nodeMid, nodeB);
        update(nodeB, nodeMid);
      }
    }
  }

  public static void print(double[] nums) {
    for (double num : nums)
      System.out.print(num + "!");
    System.out.println();
  }

  public static void main(String[] args) {
    List<List<String>> equations = new ArrayList<List<String>>();
    equations.add(new ArrayList<String>() {
      {
        add("a");
      }
      {
        add("b");
      }
    });
    equations.add(new ArrayList<String>() {
      {
        add("b");
      }
      {
        add("c");
      }
    });

    double[] values = {2., 3.};

    List<List<String>> queries = new ArrayList<List<String>>();
    queries.add(new ArrayList<String>() {
      {
        add("a");
      }
      {
        add("c");
      }
    });
    queries.add(new ArrayList<String>() {
      {
        add("b");
      }
      {
        add("a");
      }
    });
    queries.add(new ArrayList<String>() {
      {
        add("a");
      }
      {
        add("e");
      }
    });
    queries.add(new ArrayList<String>() {
      {
        add("a");
      }
      {
        add("a");
      }
    });
    queries.add(new ArrayList<String>() {
      {
        add("x");
      }
      {
        add("x");
      }
    });
    System.out.println(equations);
    System.out.println(queries);
    Solution s = new Solution();
    print(s.calcEquation(equations, values, queries));
  }

}


class Node {
  String key;
  Map<Node, Double> map = new HashMap<Node, Double>();

  public Node(String key) {
    this.key = key;
    map.put(this, 1.);
  }

  public void setLink(Node node, double value) {
    map.put(node, value);
  }
}
