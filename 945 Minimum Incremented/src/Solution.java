
public class Solution {

  public int minIncrementForUnique(int[] A) {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int i = 0; i < A.length; i++) {
      if (A[i] > max)
        max = A[i];
      if (A[i] < min)
        min = A[i];
    }

    int res = 0, bottleneck = 0, available = 0;
    int[] counts = new int[max - min + 1];
    for (int i = 0; i < A.length; i++) {
      counts[A[i] - min]++;
    }

    for (; bottleneck < counts.length && bottleneck < A.length; bottleneck++) {
      while (counts[bottleneck] > 1) {
        if (available < counts.length) {
          for (available =
              available < bottleneck ? bottleneck : available; available < counts.length
                  && counts[available] != 0; available++);
          res += available++ - bottleneck;
          counts[bottleneck]--;
        } else {
          res += available++ - bottleneck;
          counts[bottleneck]--;
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] arr1 = {1, 2, 2}, arr2 = {3, 2, 1, 2, 1, 7}, arr3 = {}, arr4 = {0, 2, 2},
        arr5 = {2, 2, 2, 1};
    int output1 = 1, output2 = 6, output3 = 0, output4 = 1, output5 = 3;

    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.minIncrementForUnique(arr1) == output1));
    System.out.println("Checking case2: " + (s.minIncrementForUnique(arr2) == output2));
    System.out.println("Checking case3: " + (s.minIncrementForUnique(arr3) == output3));
    System.out.println("Checking case4: " + (s.minIncrementForUnique(arr4) == output4));
    System.out.println("Checking case5: " + (s.minIncrementForUnique(arr5) == output5));
  }

}
