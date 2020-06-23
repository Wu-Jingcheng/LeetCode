import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Stack;

public class Solution {

  public int findKthLargest(int[] nums, int k) {
    int finalIndex = nums.length - k;
    int start = 0, end = nums.length - 1;
    int pivotIndex = partition(nums, start, end);
    while (pivotIndex != finalIndex) {
      if (pivotIndex < finalIndex)
        start = pivotIndex + 1;
      else
        end = pivotIndex - 1;
      pivotIndex = partition(nums, start, end);
    }
    return nums[finalIndex];
  }

  private int partition(int[] nums, int start, int end) {
    int pivot = nums[end];
    int smallIndex = start - 1;
    while (start <= end) {
      if (nums[start] <= pivot) {
        smallIndex++;
        if (smallIndex != start)
          swap(nums, smallIndex, start);
      }
      start++;
    }
    return smallIndex;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  // Direct Sorting
  public int findKthLargest1(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
  }

  // Heap
  public int findKthLargest2(int[] nums, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
    for (int n : nums) {
      heap.add(n);
    }
    for (; k > 1; k--)
      heap.poll();
    return heap.poll();
  }

  public static void main(String[] args) {
    int[] arr1 = {3, 2, 1, 5, 6, 4}, arr2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    int k1 = 2, k2 = 4;
    int res1 = 5, res2 = 4;

    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.findKthLargest(arr1, k1) == res1));
    System.out.println("Checking case2: " + (s.findKthLargest(arr2, k2) == res2));
  }

}
