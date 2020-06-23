import java.util.*;

public class Solution {
  // A more neat way
  public int numberOfSubarrays(int[] nums, int k) {
    int[] counts = new int[nums.length + 1];
    counts[0] = 1;
    int odd = 0, res = 0;
    for (int i = 0; i < nums.length; i++) {
      odd += nums[i] & 1;
      res += odd >= k ? counts[odd - k] : 0;
      counts[odd]++;
    }
    return res;
  }

  // More neat, still slow
  public int numberOfSubarrays4(int[] nums, int k) {
    int res = 0;
    List<Integer> indices = new ArrayList<Integer>();
    indices.add(-1);
    for (int i = 0; i <= nums.length; i++) {
      if (i == nums.length || nums[i] % 2 == 1) {
        indices.add(i);
        if (indices.size() > k + 1) {
          int index = indices.size() - 1;
          res += (indices.get(index) - indices.get(index - 1))
              * (indices.get(index - k) - indices.get(index - k - 1));
        }
      }
    }
    return res;
  }

  // ArrayList, slow
  public int numberOfSubarrays3(int[] nums, int k) {
    int res = 0;
    List<Integer> indices = new ArrayList<Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 2 == 1)
        indices.add(i);
    }
    res = 0;
    for (int i = 0; i <= indices.size() - k; i++) {
      int j = i + k - 1;
      int preRight = indices.get(i);
      int nextLeft = indices.get(j);
      int preLeft = i - 1 >= 0 ? indices.get(i - 1) : -1;
      int nextRight = j + 1 < indices.size() ? indices.get(j + 1) : nums.length;
      res += (preRight - preLeft) * (nextRight - nextLeft);
    }
    return res;
  }

  // Double arrays, still slow
  public int numberOfSubarrays2(int[] nums, int k) {
    int res = 0;
    for (int num : nums) {
      if (num % 2 == 1)
        res++;
    }
    int[] indices = new int[res];
    int index = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 2 == 1)
        indices[index++] = i;
    }
    res = 0;
    for (int i = 0; i <= indices.length - k; i++) {
      int j = i + k - 1;
      int preRight = indices[i];
      int nextLeft = indices[j];
      int preLeft = i - 1 >= 0 ? indices[i - 1] : -1;
      int nextRight = j + 1 < indices.length ? indices[j + 1] : nums.length;
      res += (preRight - preLeft) * (nextRight - nextLeft);
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 1, 2, 1, 1}, nums2 = {2, 4, 6}, nums3 = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
    int k1 = 3, k2 = 1, k3 = 2;
    Solution s = new Solution();
    System.out.println(s.numberOfSubarrays(nums1, k1));
    System.out.println(s.numberOfSubarrays(nums2, k2));
    System.out.println(s.numberOfSubarrays(nums3, k3));
  }

}
