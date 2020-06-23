
public class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    int left = 0, right = nums.length - 1;
    return BSTHelper(nums, left, right);
  }

  private TreeNode BSTHelper(int[] nums, int left, int right) {
    if (left > right)
      return null;
    int mid = (left + right + 1) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = BSTHelper(nums, left, mid - 1);
    node.right = BSTHelper(nums, mid + 1, right);
    return node;
  }

  public static void main(String[] args) {
    int[] arr = {-10, -3, 0, 5, 9};
    Solution s = new Solution();
    TreeNode root = s.sortedArrayToBST(arr);
    System.out.println(root.val == 0);
    System.out.println(root.left.val == -3);
    System.out.println(root.left.left.val == -10);
    System.out.println(root.right.val == 9);
    System.out.println(root.right.left.val == 5);
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
