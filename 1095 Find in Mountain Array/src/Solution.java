import java.util.*;

public class Solution {
  public int findInMountainArray(int target, MountainArray mountainArr) {
    boolean leftPotential = true, rightPotential = true;
    int res = -1;
    int left = 0, right = mountainArr.length() - 1;
    int leftValue = mountainArr.get(0), rightValue = mountainArr.get(right);
    if (leftValue == target)
      return left;
    else
      leftPotential = target > leftValue;
    if (rightValue == target)
      res = right;
    else
      rightPotential = target > rightValue;
    if (!leftPotential && !rightPotential)
      return -1;

    int mid, midValue;
    while (left < right - 1) {
      mid = (left + right) / 2;
      if (mountainArr.get(mid) > mountainArr.get(mid + 1))
        right = mid;
      else
        left = mid + 1;
    }
    leftValue = mountainArr.get(left);
    rightValue = mountainArr.get(right);
    if (leftValue > rightValue) {
      mid = left;
      midValue = leftValue;
    } else {
      mid = right;
      midValue = rightValue;
    }
    // System.out.println(left + "," + right);
    // System.out.println(leftValue + "," + rightValue);
    // System.out.println(midValue);
    if (midValue == target)
      return mid;
    else if (midValue < target) {
      leftPotential = false;
      rightPotential = false;
    }

    int peak = mid;
    if (leftPotential) {
      for (left = 0, right = mid - 1; left < right - 1;) {
        mid = (left + right) / 2;
        midValue = mountainArr.get(mid);
        if (midValue < target)
          left = mid + 1;
        else if (midValue > target)
          right = mid - 1;
        else
          return mid;
      }
      // System.out.println(left + "," + right);
      if (mountainArr.get(left) == target)
        return left;
      else if (mountainArr.get(right) == target)
        return right;
      else
        leftPotential = false;
    }

    if (!leftPotential && rightPotential) {
      for (left = peak + 1, right = mountainArr.length() - 1; left < right - 1;) {
        mid = (left + right) / 2;
        midValue = mountainArr.get(mid);
        if (midValue < target)
          right = mid - 1;
        else if (midValue > target)
          left = mid + 1;
        else
          return mid;
      }
      // System.out.println(left + "," + right);
      if (mountainArr.get(left) == target)
        return left;
      else if (mountainArr.get(right) == target)
        return right;
    }
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    MountainArray ma = new MountainArray(Arrays.asList(1, 2, 3, 4, 5, 3, 1));
    System.out.println(s.findInMountainArray(3, ma) == 2);
    ma = new MountainArray(Arrays.asList(0, 1, 2, 4, 2, 1));
    System.out.println(s.findInMountainArray(3, ma) == -1);
    ma = new MountainArray(Arrays.asList(1, 2, 3, 5, 3));
    System.out.println(s.findInMountainArray(3, ma));
    ma = new MountainArray(Arrays.asList(1, 5, 2));
    System.out.println(s.findInMountainArray(2, ma));
  }

}


class MountainArray {
  private List<Integer> al;

  public MountainArray() {
    al = new ArrayList<Integer>();
  }

  public MountainArray(List<Integer> list) {
    al = new ArrayList<Integer>(list);
  }

  public int get(int i) {
    return al.get(i);
  }

  public int length() {
    return al.size();
  }
}
