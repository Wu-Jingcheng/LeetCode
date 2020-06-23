public class Codec {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuffer sb = new StringBuffer();
    serializeHelper(root, sb);
    return sb.toString();
  }

  private void serializeHelper(TreeNode node, StringBuffer sb) {
    if (node == null)
      sb.append("null!");
    else {
      sb.append(node.val + "!");
      serializeHelper(node.left, sb);
      serializeHelper(node.right, sb);
    }
  }

  private int index = 0;

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] s = data.split("!");
    TreeNode res = deserializeHelper(s);
    return res;
  }

  private TreeNode deserializeHelper(String[] s) {
    String str = s[index++];
    if (str.equals("null"))
      return null;
    int value = Integer.valueOf(str);
    TreeNode node = new TreeNode(value);
    if (index < s.length) {
      node.left = deserializeHelper(s);
      node.right = deserializeHelper(s);
    }
    return node;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    Codec c = new Codec();
    System.out.println(c.serialize(root));
    String s = c.serialize(root);
    System.out.println(c.serialize(c.deserialize(s)));
  }

}


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}
