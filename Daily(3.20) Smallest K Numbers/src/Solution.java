
public class Solution {

  public int[] getLeastNumbers(int[] arr, int k) {
    int[] res = new int[k];
    if (k > arr.length / 2)
      excludeLargestK(arr, k, res);
    else
      getLeastK(arr, k, res);
    return res;
  }

  private void excludeLargestK(int[] arr, int k, int[] res) {
    makeMaxHeap(arr);
    for (int i = 0; i < arr.length - k; i++) {
      swap(arr, 0, arr.length - 1 - i);
      adjustMaxHeap(arr, 0, arr.length - 2 - i);
    }
    for (int i = 0; i < k; i++)
      res[i] = arr[i];
  }

  private void getLeastK(int[] arr, int k, int[] res) {
    makeMinHeap(arr);
    for (int i = 0; i < k; i++) {
      res[i] = arr[0];
      swap(arr, 0, arr.length - 1 - i);
      adjustMinHeap(arr, 0, arr.length - 2 - i);
    }
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private void makeMaxHeap(int[] arr) {
    for (int i = arr.length / 2; i >= 0; i--)
      adjustMaxHeap(arr, i, arr.length - 1);
  }

  private void makeMinHeap(int[] arr) {
    for (int i = arr.length / 2; i >= 0; i--)
      adjustMinHeap(arr, i, arr.length - 1);
  }

  private void adjustMaxHeap(int[] arr, int index, int last) {
    int maxIndex = index;
    if (2 * index + 1 <= last && arr[2 * index + 1] > arr[maxIndex])
      maxIndex = 2 * index + 1;
    if (2 * index + 2 <= last && arr[2 * index + 2] > arr[maxIndex])
      maxIndex = 2 * index + 2;
    if (maxIndex != index) {
      swap(arr, index, maxIndex);
      adjustMaxHeap(arr, maxIndex, last);
    }
  }

  private void adjustMinHeap(int[] arr, int index, int last) {
    int minIndex = index;
    if (2 * index + 1 <= last && arr[2 * index + 1] < arr[minIndex])
      minIndex = 2 * index + 1;
    if (2 * index + 2 <= last && arr[2 * index + 2] < arr[minIndex])
      minIndex = 2 * index + 2;
    if (minIndex != index) {
      swap(arr, index, minIndex);
      adjustMinHeap(arr, minIndex, last);
    }
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++)
      System.out.print(arr[i] + "!");
    System.out.println();
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] arr1 = {3, 2, 1}, arr2 = {0, 1, 2, 1}, arr3 = {0, 0, 0, 1, 2, 2, 3, 7, 6, 1};
    int k1 = 2, k2 = 1, k3 = 3;

    print(s.getLeastNumbers(arr1, k1));
    print(s.getLeastNumbers(arr2, k2));
    print(s.getLeastNumbers(arr3, k3));
  }

}
